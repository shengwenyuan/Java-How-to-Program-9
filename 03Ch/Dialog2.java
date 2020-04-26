import javax.swing.JOptionPane;

public class Dialog2
{
    public static void main(String[] args)
    {
        String name =
            JOptionPane.showInputDialog("What is your name");
        
        String message = 
            String.format("Welcome, %s, to JavA Programming!", name);

        JOptionPane.showMessageDialog(null, message);
        JOptionPane.showConfirmDialog(null, message);

    }
}