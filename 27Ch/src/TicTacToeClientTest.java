import javax.swing.*;

public class TicTacToeClientTest
{
    public static void main(String[] args) {
        TicTacToeClient app;

        if(args.length == 0)
            app = new TicTacToeClient("127.0.0.1");
        else
            app = new TicTacToeClient(args[0]);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
