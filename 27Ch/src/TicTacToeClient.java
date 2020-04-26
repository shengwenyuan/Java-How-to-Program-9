import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TicTacToeClient extends JFrame implements Runnable
{
    private JTextField idField;
    private JTextArea displayArea;
    private JPanel boardPanel;
    private JPanel panel2;
    private Square[][] board;
    private Square currentSquare;
    private Socket connection;
    private Scanner input;
    private Formatter output;
    private String ticTacToeHost;
    private String myMark;
    private boolean myTurn;
    private final String X_MARK = "X";
    private final String O_MARK = "O";

    public TicTacToeClient(String host)
    {
        ticTacToeHost = host;
        displayArea = new JTextArea(4, 30);
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.SOUTH);

        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3, 0, 0));

        board = new Square[3][3];

        for(int row = 0; row < board.length; row++)
        {
            for(int column = 0; column < board[row].length; column++)
            {
                board[row][column] = new Square(" ", row * 3 + column);
                boardPanel.add(board[row][column]);
            }
        }

        idField = new JTextField();
        idField.setEditable(false);
        add(idField, BorderLayout.NORTH);

        panel2 = new JPanel();
        panel2.add(boardPanel, BorderLayout.CENTER);
        add(panel2, BorderLayout.CENTER);

        setSize(300, 225);
        setVisible(true);

        startClient();
    }

    private void startClient()
    {
        try {
            connection = new Socket(InetAddress.getByName(ticTacToeHost), 12345);

            input = new Scanner(connection.getInputStream());
            output = new Formatter(connection.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ExecutorService worker = Executors.newFixedThreadPool(1);
        worker.execute(this);
    }

    public void run()
    {
        myMark = input.nextLine();

        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        idField.setText("You are player \"" + myMark + "\"");
                    }
                }
        );

        myTurn = (myMark.equals(X_MARK));

        while (true)
        {
            if(input.hasNextLine())
                processMessage(input.nextLine());
        }
    }

    private void processMessage(String message)
    {
        if(message.equals("Valid move."))
        {
            displayMessage("Valid move, plase wait.\n");
            setMark(currentSquare, myMark);
        }
        else if(message.equals("Invalid move, try again"))
        {
            displayMessage(message + "\n");
            myTurn = true;
        }
        else if(message.equals("Opponent moved"))
        {
            int location = input.nextInt();
            input.nextLine();
            int row = location / 3;
            int column = location % 3;

            setMark(board[row][column], (myMark.equals(X_MARK) ? O_MARK : X_MARK) );
            displayMessage("Opponent moved. Your turn.\n");
            myTurn = true;
        }
        else
            displayMessage(message + "\n");
    }

    private void displayMessage(final String s)
    {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        displayArea.append(s);
                    }
                }
        );
    }

    public void sendClickedSquare(int location)
    {
        if(myTurn)
        {
            output.format("%d\n", location);
            output.flush();
        }
    }

    private void setMark(final Square squareToMark, final String mark)
    {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        squareToMark.setMark(mark);
                    }
                }
        );
    }

    public void setCurrentSquare(Square square)
    {
        currentSquare = square;
    }

    private class Square extends JPanel
    {
        private String mark;
        private int location;

        public Square(String squareMark, int squareLocation)
        {
            mark = squareMark;
            location = squareLocation;

            addMouseListener(
                    new MouseAdapter() {
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            setCurrentSquare(Square.this);
                            sendClickedSquare(getSquareLocation());
                        }
                    }
            );
        }

        public Dimension getPreferredSize()
        {
            return new Dimension(30, 30);
        }

        public Dimension getMinimumSize()
        {
            return getPreferredSize();
        }

        public void setMark(String newMark)
        {
            mark = newMark;
            repaint();
        }

        public int getSquareLocation()
        {
            return location;
        }

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            g.drawRect(0, 0, 29, 29);
            g.drawString(mark, 11, 20);
        }
    }
}
