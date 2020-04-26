import javax.swing.*;

public class Desktop_test
{
    public static void main(String[] args) {
        DesktopFrame desktopFrame = new DesktopFrame();
        desktopFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        desktopFrame.setSize(900, 600);
        desktopFrame.setVisible(true);
    }
}
