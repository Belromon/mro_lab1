import java.awt.image.BufferedImage;
import java.io.IOException;

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
                if (image.getRGB(i, j) == -16777216) {
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
                            x += Math.pow(0 - mask[k][l], 2);
                        else
                            x += Math.pow(matrix[i - 1 + k][j - 1 + l] - mask[k][l], 2);
                    }

                }
                result[i][j] = x;
            }
        }


        return result;
    }

    public double getMinElement(double[][] matrix) {
        double minMatrElement = 40;
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < lenght; j++) {
                if (minMatrElement > matrix[j][i]) minMatrElement = matrix[j][i];
            }
        }

        return minMatrElement;
    }

    public double[] getMinElementMatrix() throws IOException{
        double[] minElementMatrix = new double[100];
        for (int i = 1; i < 100; i++) {
           minElementMatrix[i] += getMinElement(scanMatrixFiveMask(getMatrix(ImageLoader.loadImage("pics/res" + i + ".png"))));
            System.out.println(minElementMatrix[i]);
           }


       return minElementMatrix;
       }

    private int[][] mask5 = {
            {1, 1, 1, 1, 1},
            {1, 3, 3, 3, 1},
            {1, 3, 5, 3, 1},
            {1, 3, 3, 3, 1},
            {1, 1, 1, 1, 1}};

    public double[][] scanMatrixFiveMask(int[][] matrix) {
        double[][] result = new double[lenght][lenght];
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < lenght; j++) {
                double x = 0.0;

                for (int k = 0; k < maskLength; k++) {
                    for (int l = 0; l < maskLength; l++) {
                        if ((i - 1 < 0 || j - 1 < 0) || (i + 1 >= lenght || j + 1 >= lenght))
                            x += Math.pow(0 - mask5[k][l], 2);
                        else {
                            x += Math.pow(matrix[i - 1 + k][j - 1 + l] - mask5[k][l], 2);


                            if ((i - 2 < 0 || j - 2 < 0) || (i + 2 >= lenght || j + 2 >= lenght))
                                x += Math.pow(0 + mask5[k][l], 2);
                            else
                                x += Math.pow(matrix[i - 2 + k][j - 2 + l] - mask5[k][l], 2);
                        }
                    }

                }
                result[i][j] = x;
            }
        }


        return result;
    }
}
