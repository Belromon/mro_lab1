import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DisplayImage extends JFrame {
    public static void display(BufferedImage image) {
        Image scaled = image.getScaledInstance(image.getWidth()*10, image.getHeight()*10, Image.SCALE_SMOOTH);
        Icon icon = new ImageIcon(scaled);
        JLabel label1 = new JLabel(icon);
        JFrame frame = new JFrame("Lab 1");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.add(label1);
        frame.show();

    }
}
