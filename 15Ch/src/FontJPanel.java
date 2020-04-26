import javax.swing.JPanel;
import java.awt.*;

public class FontJPanel extends JPanel
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setFont(new Font("Serif", Font.BOLD, 12));
        g.drawString("Serif 12 point bold.", 20, 30);

        g.setFont(new Font("Serif", Font.ITALIC, 24));
        g.drawString("Serif 24 point bold.", 20, 50);

        g.setFont(new Font("Serif", Font.PLAIN, 14));
        g.drawString("Serif 14 point bold.", 20, 70);

        g.setColor(Color.RED);
        g.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 18));
        g.drawString(g.getFont().getName() + "," + g.getFont().getSize() + "point bold italic.",
                20, 90);
    }
}
