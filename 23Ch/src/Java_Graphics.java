import javax.swing.*;
import java.awt.*;
import java.applet.*;

public class Java_Graphics extends JApplet {
    public void paint(Graphics g) {
        g.drawString("用Graphics写字和画图的基本方法", 20,40);
        g.drawOval(100, 100, 30, 30);
        g.drawOval(200, 100, 40, 25);
        g.drawLine(20, 140, 200,140);
        g.drawRect(20, 160, 50, 80);
        g.drawRoundRect(110, 160, 100, 100, 25, 18);
    }
}
