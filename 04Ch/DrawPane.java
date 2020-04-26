import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPane extends JPanel
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        int width = getWidth();
        int heigth = getHeight();

        g.drawLine(0, 0, width, heigth);
        g.drawLine(0, heigth, width, 0);
    }
}