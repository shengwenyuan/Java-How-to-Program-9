import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;


public class FractalJPanel extends JPanel
{
    private Color color;
    private int level;

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    public FractalJPanel(int currentLevel)
    {
        color = Color.BLUE;
        level = currentLevel;
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public void drawFractal(int level, int xA, int yA, int xB, int yB, Graphics g)
    {
        if(level == 0)
        {
            g.drawLine(xA, yA, xB, yB);
        }
        else
        {
            int xC = (xA + xB) / 2;
            int yC = (yA + yB) / 2;

            int xD = xA + (xC - xA) / 2 - (yC - yA) / 2;
            int yD = yA + (yC - yA) / 2 + (xC - xA) / 2;

            drawFractal(level - 1, xD, yD, xA, yA, g);
            drawFractal(level - 1, xD, yD, xC, yC, g);
            drawFractal(level - 1, xD, yD, xB, yB, g);
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(color);
        drawFractal(level, 100, 90, 290, 200, g);
    }

    public void setColor(Color c)
    {
        color = c;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
