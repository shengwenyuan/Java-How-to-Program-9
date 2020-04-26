import javax.swing.JFrame;

public class DrawPaneTest
{
    public static void main(String[] args)
    {
        DrawPane panel = new DrawPane();

        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        application.add(panel);
        application.setSize(250, 250);
        application.setVisible(true);
    }
}