import javax.swing.*;
import java.awt.*;

public class Shape2
{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing 2D shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Shapes2JPanel shapes2JPanel = new Shapes2JPanel();
        frame.add(shapes2JPanel);
        frame.setBackground(Color.WHITE);
        frame.setSize(315, 350);
        frame.setVisible(true);
    }
}
