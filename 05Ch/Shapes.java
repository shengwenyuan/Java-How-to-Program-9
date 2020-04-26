import javax.swing.JPanel;
import java.awt.Graphics;

public class Shapes extends JPanel
{
    private int choice;

    public Shapes(int userChoice)
    {
        choice = userChoice;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for(int i = 0; i < 10; i++)
        {
            switch (choice)
            {
                case 1:
                    g.drawRect(10 + i * 10, 10 + i * 10, 50 + i * 10, 50 + i * 10);
                    break;
                
                case 2:
                    g.drawOval(10 + i * 10, 10 + i * 10, 50 + i * 10, 50 + i * 10);

                case 3:
                    g.drawRoundRect(10, 40, 20, 30, 40, 10);
            }
        }
    }
}