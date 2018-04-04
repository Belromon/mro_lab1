import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Analyser {
    private static final int lenght = 30;
    private static final int maskLength = 3;

    private Map<Integer, double[][]> funcInf = new HashMap<>();



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
        double minMatrElement = 150;
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < lenght; j++) {
                if (minMatrElement > matrix[j][i]) minMatrElement = matrix[j][i];
            }
        }

        return minMatrElement;
    }

    public double[] getMinElementMatrix() throws IOException {
        double[] minElementMatrix = new double[31];
        for (int i = 1; i < 31; i++) {
            minElementMatrix[i] += getMinElement(scanMatrixFiveMask(getMatrix(ImageLoader.loadImage("pics/res" + i + ".png"))));
            // System.out.println(minElementMatrix[i]);
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
                int i2, j2 = 0;
                for (int k = i - 2; k <= i + 2; k++) {
                    i2 = 0;
                    for (int l = j - 2; l <= j + 2; l++) {
                        if ((k < 0 || l < 0) || (k >= lenght || l >= lenght))
                            x += Math.pow(0 - mask5[i2][j2], 2);
                        else
                            x += Math.pow(matrix[k][l] - mask5[i2][j2], 2);
                        i2++;

                    }

                    j2++;
                }
                //  System.out.print(x +"\t");

                result[i][j] = x;
            }
            //     System.out.println();
        }


        return result;
    }

    public double getMinFromArray(double[] array) {
        double min = 100;

        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
       // System.out.println("Min from getMin" + min);
        return min;
    }

    public double getMaxFromArray(double[] array) {
        double max = 0;

        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }
public  int[][] AllMass=new int[100][100];
    public int getFunctionInformative(int pictureNumber, int count) throws IOException {
//        double[][] resultMatrix = scanMatrixFiveMask(getMatrix(ImageLoader.loadImage("pics/res" + pictureNumber + ".png")));
        double[][] resultMatrix = scanMatrixFiveMask(getMatrix(ImageLoader.loadImage("pics/res" + pictureNumber + ".png")));
        double max = getMaxFromArray(getMinElementMatrix());
        double min = getMinFromArray(getMinElementMatrix());
        int[][] result = new int[5][5];
        int matrix[][]=getMatrix((ImageLoader.loadImage("pics/res" + pictureNumber + ".png")));
        boolean flag = true;


        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix.length; j++) {
         //       System.out.print(resultMatrix[i][j] + "\t");
            }
       //     System.out.println();
        }

//        System.out.println(min);
//        System.out.println(max);

        while (min <= max) {
            for (int i = 2; i < 28; i++) {
                for (int j = 2; j < 28; j++) {


                    if (resultMatrix[i][j] == min) {
                        for (int k = i - 2; k < i + 3; k++) {
                            for (int l = j - 2; l < j + 3; l++) {
                                if (resultMatrix[k][l] == -1) {
                                    flag = false;
                                }
                            }
                        }

                        if (flag) {
//                            for (int o = 0; o < matrix.length; o++) {
//                                for (int p = 0; p < matrix.length; p++) {
//                                    System.out.print(matrix[o][p] + " ");
//                                }
//                                System.out.println();
//                            }


                            for (int k = i - 2, n = 0; k < i + 3; k++, n++) {
                                for (int l = j - 2, m = 0; l < j + 3; l++, m++) {
                                    result[n][m] = matrix[k][l];
                                    resultMatrix[k][l] = -1;
                                }
                            }
                            int All=1;


//                            for (int o = 0; o < result.length; o++) {
//                                for (int p = 0; p < result.length; p++) {
//                                    System.out.print(result[o][p] + " ");
//                                }
//                                System.out.println();
//                            }

                            AllMass[count][0]=count;
                            for (int k = 0; k < 5; k++) {
                                for (int l = 0; l < 5; l++) {
                                    AllMass[count][All]=result[l][k];
                                    All++;
                                }
                            }
                            count ++;

                        }

                        flag = true;
                    }
                }
            }
            min++;

        }
//
//        for (int i = 0; i < resultMatrix.length; i++) {
//            for (int j = 0; j < resultMatrix.length; j++) {
//                System.out.print(resultMatrix[i][j] + "\t");
//            }
//            System.out.println();
//        }
//
//        System.out.println("---------");
//
//        System.out.println("---------");
//


//        for (double a[][]: funcInf) {
//
//            for (int i = 0; i < a.length; i++) {
//                for (int j = 0; j < a.length; j++) {
//                    System.out.print(a[i][j] + "\t");
//                }
//                System.out.println();
//            }
//        }
        return count;
    }



}
