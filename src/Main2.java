import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

public class Main2 {

    public int[][] test1;


//    public double name1[] = new double[26];
//    public double name2[] = new double[36];
//    public double name3[] = new double[7];
    public List<double[][]> retList = new List<double[][]>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<double[][]> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(double[][] doubles) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends double[][]> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends double[][]> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public double[][] get(int index) {
            return new double[0][];
        }

        @Override
        public double[][] set(int index, double[][] element) {
            return new double[0][];
        }

        @Override
        public void add(int index, double[][] element) {

        }

        @Override
        public double[][] remove(int index) {
            return new double[0][];
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<double[][]> listIterator() {
            return null;
        }

        @Override
        public ListIterator<double[][]> listIterator(int index) {
            return null;
        }

        @Override
        public List<double[][]> subList(int fromIndex, int toIndex) {
            return null;
        }
    };
    public static List<Image> imageList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Main2 m = new Main2();
        Code code = new Code();
        Analyser analyser = new Analyser();
        //  BufferedImage image = ImageLoader.loadImage("pics/res1.png");
        //DisplayImage.display(image);
        //int[][] a =  analyser.getMatrix(image);
        // double[][] b = analyser.scanMatrix(a);
        double[] minElementMatrix = new double[31];
        minElementMatrix = analyser.getMinElementMatrix();
        analyser.getMinFromArray(minElementMatrix);
        //analyser.getMinElementMatrix();
        //  analyser.getFunctionInformative(1);
        String name;

//        for (int i = 1; i < 31; i++) {
//            name = "pics/res" + i + ".png";
//            BufferedImage image1 = ImageLoader.loadImage(name);
//            double b[][] = analyser.getMatrixD(image1);
//            abc.add(b);
//        }

        double minMin, maxMin;
        int countFunkInformativ = 0;
        for (int i = 1; i <= 30; i++) {
            countFunkInformativ = analyser.getFunctionInformative(i, countFunkInformativ);
        }
        int abba = 26;
        int[][] test = new int[countFunkInformativ][26];

        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < abba; j++) {
                test[i][j] = analyser.AllMass
                        [i][j];
                // System.out.print(test[i][j]+" ");
            }
            // System.out.println();

        }
        //  test1=test;
        // System.out.println(analyser.fuckThis.length);
        Spectr spectr = new Spectr();
        spectr.createFourTable(countFunkInformativ, test);
        minMin = analyser.retMinMin();
        maxMin = analyser.retMaxMin();
//        spectr.maxim(abc, m.o1, m.name1, m.maxMin, m.minMin);
//
//        spectr.xxx();
//        //  System.out.println(countFunkInformativ);
//        for (double[][] i : m.retList) {
//            for (int j = 0; j < 30; j++) {
//                for (int k = 0; k < 30; k++) {
//                    System.out.print(i[j][k] + " ");
//                }
//                System.out.println();
//            }
//        }

        double[][] o1=spectr.retO1();
        double[][] o2=spectr.retO2();
        double[][] o3=spectr.retO3();

        double[] name1=spectr.retName1();
        double[] name2=spectr.retName2();
        double[] name3=spectr.retName3();

        double count=0;
        for (int i = 1; i < 31; i++) {
            Image image = new Image(i);


            name = "pics/res" + i + ".png";
            boolean flag = true;
            BufferedImage image1 = ImageLoader.loadImage(name);
            // double b[][] = analyser.getMatrixD(image1);
            double b1[][] = new double[30][30];
            double b[][] = analyser.getMatrixD((ImageLoader.loadImage("pics/res" + i + ".png")));
            double[][] resultMatrix = analyser.scanMatrixFiveMask(analyser.getMatrix(ImageLoader.loadImage("pics/res" + i + ".png")));
//            for (int j = 0; j < 30; j++) {
//                for (int k = 0; k < 30; k++) {
//                    b1[j][k] = b[j][k];
//                }
//            }
//                        for (int j = 0; j <30 ; j++) {
//                for (int k = 0; k <30 ; k++) {
//                    System.out.print(b[j][k]);
//                }
//                System.out.println();
//            }
//             System.out.println();
            count = spectr.retCount();
            b = spectr.ChangeEtalon(b, resultMatrix, o1, o2,o3, name1, name2, name3, maxMin, minMin, count);
            double[][] resultMatrix1 = analyser.scanMatrixFiveMaskD(b);
            double[][] resultMatrix2 = analyser.scanMatrixFiveMaskD(b);
//            for (int j = 0; j < 30; j++) {
//                for (int k = 0; k < 30; k++) {
//                     System.out.print(b[j][k]);
//                    if (b1[j][k] != b[j][k]) flag = false;
//                }
//                 System.out.println();
//            }
//            System.out.println(flag);

            code.func(b, resultMatrix1, minMin,maxMin);
            double b11[][] = analyser.getMatrixD((ImageLoader.loadImage("pics/res" + i + ".png")));
            imageList=analyser.method(imageList, i, b11, resultMatrix2, minMin,maxMin, name1, name2, name3);
        }
        code.allCN();





        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                DisplayImage.createGUI(code.count,code.codeNaprAll);
            }
        });


    }
}
