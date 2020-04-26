import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DesktopFrame extends JFrame
{
    private JDesktopPane theDesktop;

    public DesktopFrame()
    {
        super("Using a JDesktopPane");

        JMenuBar bar = new JMenuBar();
        JMenu addMenu = new JMenu("Add");
        JMenuItem newFrame = new JMenuItem("Internal Frame");

        addMenu.add(newFrame);
        bar.add(addMenu);
        setJMenuBar(bar);

        theDesktop = new JDesktopPane();
        add(theDesktop);

        newFrame.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JInternalFrame frame = new JInternalFrame("Internal Frame", true, true,
                                true, true);

                        MyJPanel panel = new MyJPanel();
                        frame.add(panel, BorderLayout.CENTER);
                        frame.pack();

                        theDesktop.add(frame);
                        frame.setVisible(true);
                    }
                }
        );
    }
}

class MyJPanel extends JPanel
{
    private static Random generator = new Random();
    private ImageIcon picture;
    private final static String[] images = { "yellowflowers.png", "yellowflowers.png",
            "yellowflowers.png", "yellowflowers.png" };

    public MyJPanel()
    {
        int randomNumber = generator.nextInt(images.length);
//        picture = new ImageIcon("src//h.jpg");
        picture = new ImageIcon(images[randomNumber]);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        picture.paintIcon(this, g, 0, 0);
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(picture.getIconWidth(), picture.getIconHeight());
    }
}
