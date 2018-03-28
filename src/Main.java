import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {
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

int fuck=0;
        for (int i = 1; i <= 30; i++) {
            fuck = analyser.getFunctionInformative(i, fuck);
        }
        int abba=26;
        int[][] test =  new int[fuck][abba];

        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < abba; j++) {
                test[i][j] = analyser.fuckThis[i][j];
                System.out.print(test[i][j]+" ");
            }
            System.out.println();

        }
       // System.out.println(analyser.fuckThis.length);
        Spectr spectr = new Spectr();
        spectr.createFourTable(fuck, test);
//
//        Gui gui = new Gui();
//        Graphics g = gui.getGraphics();
//        gui.paint(g);


//System.out.println(fuck);


    }
}
