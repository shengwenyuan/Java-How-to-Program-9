import java.awt.Color;
import java.awt.event.InputEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class KeyDemoFrame extends JFrame implements KeyListener
{
    private String line1 = "";
    private String line2 = "";
    private String line3 = "";
    private Font bigSize;
    private JTextArea textArea;

    public KeyDemoFrame()
    {
        super("Demonstrating Keywords Events");

        textArea = new JTextArea(10, 15);
        textArea.setText("Press any key on the keyboard...");
        textArea.setEnabled(false);
        textArea.setDisabledTextColor(Color.BLACK);
        bigSize = new Font("Serif", Font.PLAIN, 30);
        textArea.setFont(bigSize);
        add(textArea);

        addKeyListener(this);
    }

    public void keyPressed(KeyEvent event)
    {
        line1 = String.format("Key pressed: %s", KeyEvent.getKeyText(event.getKeyCode()));
        setLine2and3(event);
    }

    public void keyReleased(KeyEvent event)
    {
        line1 = String.format("Key released: %s", KeyEvent.getKeyText(event.getKeyCode()));
        setLine2and3(event);
    }

    public void keyTyped(KeyEvent event)
    {
        line1 = String.format("Key typed: %s", event.getKeyChar());
        setLine2and3(event);
    }

    private void setLine2and3(KeyEvent event)
    {
        line2 = String.format("This key is %s an action key", (event.isActionKey() ? "none" :
                "not"));
        String temp = InputEvent.getModifiersExText(event.getModifiersEx());

        line3 = String.format("Modifier keys pressed: %s", (temp.equals("") ? "none" : temp));

        textArea.setText(String.format("%s\n%s\n%s\n", line1, line2, line3));
    }
}
