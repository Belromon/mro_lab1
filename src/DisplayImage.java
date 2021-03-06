import javax.swing.*;
import java.awt.*;

public class DisplayImage extends JFrame {

        public static void createGUI(int count, int[][] codeNapr) {
            JFrame frame = new JFrame("Test frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            String[] columnNames = new String[count];

            String[][] names = new String[1][count];

            for (int i = 1 ; i < count; i++) {
                for (int j = 0; j <8; j++) {
                    names[0][i] += codeNapr[i][j];
                    columnNames[i]+=codeNapr[i][j];
                }
            }




            JTable table = new JTable(names, columnNames);

            JScrollPane scrollPane = new JScrollPane(table);

            frame.getContentPane().add(scrollPane);
            frame.setPreferredSize(new Dimension(450, 200));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

//    public static void createGUI(int count, int[][] codeNapr) {
//        JFrame frame = new JFrame("Test frame");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        String[] columnNames = {
//                "Name",
//                "Last modified",
//                "Type",
//                "Size"
//        };
//
//        String[][] data = {
//                {"addins", "02.11.2006 19:15", "Folder", ""},
//                {"AppPatch", "03.10.2006 14:10", "Folder", ""},
//                {"assembly", "02.11.2006 14:20", "Folder", ""},
//                {"Boot", "13.10.2007 10:46", "Folder", ""},
//                {"Branding", "13.10.2007 12:10", "Folder", ""},
//                {"Cursors", "23.09.2006 16:34", "Folder", ""},
//                {"Debug", "07.12.2006 17:45", "Folder", ""},
//                {"Fonts", "03.10.2006 14:08", "Folder", ""},
//                {"Help", "08.11.2006 18:23", "Folder", ""},
//                {"explorer.exe", "18.10.2006 14:13", "File", "2,93MB"},
//                {"helppane.exe", "22.08.2006 11:39", "File", "4,58MB"},
//                {"twunk.exe", "19.08.2007 10:37", "File", "1,08MB"},
//                {"nsreg.exe", "07.08.2007 11:14", "File", "2,10MB"},
//                {"avisp.exe", "17.12.2007 16:58", "File", "12,67MB"},
//        };
//
//        JTable table = new JTable(data, columnNames);
//
//        JScrollPane scrollPane = new JScrollPane(table);
//
//        frame.getContentPane().add(scrollPane);
//        frame.setPreferredSize(new Dimension(450, 200));
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//    }


}

