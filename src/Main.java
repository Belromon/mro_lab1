import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Analyser analyser = new Analyser();
        BufferedImage image = ImageLoader.loadImage("pics/1.png");
        // DisplayImage.display(image);

        int[][] matrix = analyser.getMatrix(image);
        double[][] res = analyser.scanMatrix(matrix);

        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println(" ");
        }

    }
}
