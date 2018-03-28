import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Gui extends JPanel{
    ArrayList<Integer> data;
    int maxNum = 0;




        public void paint(Graphics g) {
            data.add(1);
            data.add(2);
            data.add(3);
            data.add(7);
            int poloska_w = getWidth() / data.size(); // Считаем ширину одной полоски (каждый раз, т.к. размеры окошка могут меняться)

            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1); // это рамочка

            for (int i = 0; i < data.size(); i++) {
                int poloska_h = data.get(i) * getHeight() / maxNum; // считаем высоту полоски
                g.drawRect(i * poloska_w, getHeight() - poloska_h, poloska_w, poloska_h); // рисуем снизу вверх
            }
        }


}
