import javax.swing.*;

public class Client2_test
{
    public static void main(String[] args) {
        Client2 app = new Client2();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(1000,600);
        app.waitForPackets();
    }
}
