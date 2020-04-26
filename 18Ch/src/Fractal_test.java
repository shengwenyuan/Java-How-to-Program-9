import javax.swing.*;

public class Fractal_test
{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing fractal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FractalJPanel fractalJPanel = new FractalJPanel(8);

        frame.add(fractalJPanel);
//        fractalJPanel.paintComponent();
        frame.setSize(450, 450);
        frame.setVisible(true);
    }
}
