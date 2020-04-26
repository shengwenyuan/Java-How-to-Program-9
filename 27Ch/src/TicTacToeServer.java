import javax.swing.*;
import java.awt.BorderLayout;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class TicTacToeServer extends JFrame
{
    private String[] board = new String[9];
    private JTextArea outputArea;
    private Player[] players;
    private ServerSocket server;
    private int currentPlayer;
    private final static int PLAYER_X = 0;
    private final static int PLAYER_O = 1;
    private final static String[] MARKS = {"X", "O"};
    private ExecutorService runGame;
    private Lock gameLock;
    private Condition otherPlayerConnected;
    private Condition otherPlayerTurn;

    public TicTacToeServer()
    {
        super("Tic-Tac-Toe Server");

        runGame = Executors.newFixedThreadPool(2);
        gameLock = new ReentrantLock();

        otherPlayerConnected = gameLock.newCondition();
        otherPlayerTurn = gameLock.newCondition();

        for(int i = 0; i < 9; i++)
            board[i] = new String("");
        players = new Player[2];
        currentPlayer = PLAYER_X;

        try {
            server = new ServerSocket(12345, 2);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        outputArea = new JTextArea();
        add(outputArea, BorderLayout.CENTER);
        outputArea.setText("Server awaiting connections\n");

        setSize(300, 300);
        setVisible(true);
    }

    public void execute()
    {
        for(int i = 0; i < players.length; i++)
        {
            try {
                players[i] = new Player(server.accept(), i);
                runGame.execute(players[i]);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        gameLock.lock();

        try {
            players[PLAYER_X].setSuspended(false);
            otherPlayerConnected.signal();
        } finally {
            gameLock.unlock();
        }
    }

    private class Player implements Runnable
    {
        private Socket connection;
        private Scanner input;
        private Formatter output;
        private int playerNumber;
        private String mark;
        private boolean suspended = true;

        public Player(Socket connection, int playerNumber) {
            this.connection = connection;
            this.playerNumber = playerNumber;
            this.mark = MARKS[playerNumber];

            try {
                input = new Scanner(connection.getInputStream());
                output = new Formatter(connection.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        public void otherPlayerMoved(int location)
        {
            output.format("Opponent moved\n");
            output.format("%d\n", location);
            output.flush();
        }

        public void run()
        {
            try
            {
                displayMessage("Player " + mark + " connected\n");
                output.format("%s\n", mark);
                output.flush();

                if(playerNumber == PLAYER_X)
                {
                    output.format("%s\n%s", "Player X connected", "Waiting for another player\n");
                    output.flush();

                    gameLock.lock();

                    try
                    {
                        while (suspended)
                        {
                            otherPlayerConnected.await();
                        }
                    }
                    catch (InterruptedException exc)
                    {
                        exc.printStackTrace();
                    }
                    finally {
                        gameLock.unlock();
                    }

                    output.format("Other player connected. Your move.\n");
                    output.flush();
                }
                else
                {
                    output.format("Player O connected, please wait.\n");
                    output.flush();
                }

                while (!isGameOver())
                {
                    int location = 0;
                    if(input.hasNext())
                        location = input.nextInt();

                    if(validateAndMove(location, playerNumber))
                    {
                        displayMessage("\nlocation: " + location);
                        output.format("Valid move.\n");
                        output.flush();
                    }
                    else
                    {
                        output.format("Invalid move, try again\n");
                        output.flush();
                    }
                }
            }
            finally {

                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }

        public void setSuspended(boolean status)
        {
            suspended = status;
        }
    }   //end Player class

    public boolean isGameOver()
    {
        return false;
    }

    public boolean validateAndMove(int location, int player)
    {
        while (player != currentPlayer)
        {
            gameLock.lock();

            try {
                otherPlayerTurn.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                gameLock.unlock();
            }
        }

        if(!isOccupied(location))
        {
            board[location] = MARKS[currentPlayer];
            currentPlayer = (currentPlayer + 1) % 2;

            players[currentPlayer].otherPlayerMoved(location);

            gameLock.lock();

            try {
                otherPlayerTurn.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                gameLock.unlock();
            }

            return true;
        }
        else
            return false;
    }   //end validateAndMove

    public boolean isOccupied(int location)
    {
        if(board[location].equals(MARKS[PLAYER_X]) || board[location].equals(MARKS[PLAYER_O]))
            return true;
        else
            return false;
    }

    private void displayMessage(final String s)
    {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        outputArea.append(s);
                    }
                }
        );
    }
}
