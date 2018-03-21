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






    }
}
