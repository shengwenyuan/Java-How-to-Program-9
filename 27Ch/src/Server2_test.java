import javax.swing.*;
import java.awt.*;

public class Server2_test
{
    public static void main(String[] args) {
        Server2 app = new Server2();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(1000,600);
        app.waitForPackets();
    }
}
