import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main2 {

    public  int[][] test1;

    public static void main(String[] args) throws IOException {
        Analyser analyser = new Analyser();
        BufferedImage image = ImageLoader.loadImage("pics/res1.png");
        //DisplayImage.display(image);
        int[][] a =  analyser.getMatrix(image);
        // double[][] b = analyser.scanMatrix(a);
        double[] minElementMatrix = new double[31];
        minElementMatrix = analyser.getMinElementMatrix();
        analyser.getMinFromArray(minElementMatrix);
        //analyser.getMinElementMatrix();
        //  analyser.getFunctionInformative(1);

        int countFunkInformativ=0;
        for (int i = 1; i <= 30; i++) {
            countFunkInformativ = analyser.getFunctionInformative(i, countFunkInformativ);
        }
        int abba=26;
        int[][] test =  new int[countFunkInformativ][26];

        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < abba; j++) {
                test[i][j] = analyser.AllMass
                        [i][j];
                System.out.print(test[i][j]+" ");
            }
            System.out.println();

        }
         test1=test;
        // System.out.println(analyser.fuckThis.length);
        Spectr spectr = new Spectr();
        spectr.createFourTable(countFunkInformativ, test);
//
//        Gui gui = new Gui();
//        Graphics g = gui.getGraphics();
//        gui.paint(g);
        
//System.out.println(fuck);



    }
}
