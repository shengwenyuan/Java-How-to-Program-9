import javax.swing.*;
import java.awt.*;

public class WelcomeApplet extends JApplet
{
    public void paint(Graphics g)
    {
        super.paint(g);

        g.drawString("Welcome to Java Programming!", 25, 25);
    }
}
