import java.awt.image.BufferedImage;

public class Analyser {
    private static final int lenght = 30;
    private static final int maskLength = 3;
    private int[][] mask = {
            {1, 1, 1},
            {1, 3, 1},
            {1, 1, 1}};

    public int[][] getMatrix(BufferedImage image) {
        int[][] matrix = new int[image.getHeight()][image.getWidth()];

        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                if (image.getRGB(i, j) == -1) {
                    matrix[i][j] = 1;
                }
            }
        }
        return matrix;
    }

    public double[][] scanMatrix(int[][] matrix) {
        double[][] result = new double[lenght][lenght];
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < lenght; j++) {
                double x = 0.0;
                for (int k = 0; k < maskLength; k++) {
                    for (int l = 0; l < maskLength; l++) {
                        if ((i - 1 < 0 || j - 1 < 0) || (i + 1 >= lenght || j + 1 >= lenght))
                            x += Math.pow(0 + mask[k][l], 2);
                        else
                            x += Math.pow(matrix[i - 1 + k][j - 1 + l] - mask[k][l], 2);
                    }
                }
            }
        }


        return result;
    }


}
