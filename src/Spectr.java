import java.util.Scanner;

public class Spectr {
    private static final int SIZE = 1;


//    public String choseStartPoint() {
//        System.out.println("Enter start point");
//        Scanner sc = new Scanner(System.in);
//        if (sc.hasNext()) {
//            startPoint = sc.nextLine();
//        }
//        // System.out.println(startPoint);
//        return startPoint;
//
//    }

    public void createFourTable(int amountOfImages, int[][] data) {

        int amountOfTags = 25;
        double[][] Buffer = new double[30][30];
        double[] nameArray = new double[50 + 1];
        double[][] fourTable = new double[amountOfImages + 1][amountOfImages + 1];
        double[][] rast = new double[amountOfImages + 1][amountOfImages + 1];
        double[][] porog = new double[50 + 1][50 + 1];
        double[] namePorog = new double[50 + 1];
        double[][] porog1 = new double[50 + 1][50 + 1];

        double startPoint = -1;
        boolean flag = true;
        int i = 0;
        int resultString = 0;

        System.out.println("Enter start point");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            startPoint = sc.nextInt();
        }

        while (flag) {
            if (startPoint == data[i][0]) {
                resultString = i;
                flag = false;
            } else {
                i++;
            }
        }
        for (int k = 1; k <= amountOfTags; k++) {
            Buffer[0][k] = Double.valueOf(data[resultString][k]);
        }


        nameArray[0] = data[resultString][0];

        int i_min = resultString;

// в этом цикле считается указанное количество расстояний

        for (int x = 0; x < amountOfImages - 1; x++) {

            for (int j = 0; j < 26; j++) {
                if (i_min == j) {
                    for (int l = j; l < amountOfImages; l++) {
                        for (int m = 0; m <= 26; m++) {

                            data[l][m] = data[l + 1][m];


                        }
                    }
                    j = amountOfImages;//прерывание цикла(пасхалочка2)
                }
            }
            amountOfImages--;

//***********Нахождение расстояния************//


            for (int j = 0; j < amountOfImages; j++) {
                fourTable[0][j] =
                        Math.sqrt(Math.pow((Double.valueOf(Buffer[0][1]) - Double.valueOf(data[j][1])), 2) +
                                Math.pow((Double.valueOf(Buffer[0][2]) - Double.valueOf(data[j][2])), 2) +
                                Math.pow((Double.valueOf(Buffer[0][3]) - Double.valueOf(data[j][3])), 2) +
                                Math.pow((Double.valueOf(Buffer[0][4]) - Double.valueOf(data[j][4])), 2) +
                                Math.pow((Double.valueOf(Buffer[0][5]) - Double.valueOf(data[j][5])), 2) +
                                Math.pow((Double.valueOf(Buffer[0][6]) - Double.valueOf(data[j][6])), 2));
            }

//****************Нахождения минимального****************//
            double min;
//проверка на расстояния между одинаковыми элементами
            if (fourTable[0][0] != 0) {
                min = fourTable[0][0];
                i_min = 0;
            } else {
                min = fourTable[0][1];
                i_min = 1;
            }


            for (int j = 0; j < amountOfImages; j++) {
                if ((fourTable[0][j] < min) && (fourTable[0][j] != 0)) {
                    min = fourTable[0][j];
                    i_min = j;
                }
            }
            rast[0][x] = min;

            //***********Нахождение центра между начальной точкой и ближайшей к ней**********//
            for (int j = 1; j <= amountOfTags; j++) {
                double xx = Double.valueOf(Buffer[0][j]);
                double yy = Double.valueOf(data[i_min][j]);
                Buffer[0][j] = ((xx + yy) / 2);
            }
            nameArray[x + 1] = data[i_min][0];
        }


        System.out.println("Rasstoyania");
        for (int j = 0; j < amountOfImages; j++) {
            System.out.print(rast[0][j] + " ");
        }
//считаем пороги
        int b = 0;
/////??????


        for (int j = 1; j < amountOfImages - 1; j++) {
            if (rast[0][j - 1] < rast[0][j]) {

                namePorog[b] = nameArray[j];
                porog[0][b] = (rast[0][j] - rast[0][j - 1]);
                b++;
            }

        }

        int count = 1;
        if (b != 0) count = b - 1;////????
        System.out.println();
        System.out.println("Porog do sort");
        for (int j = 0; j < count; j++) {
            System.out.print( porog[0][j] + " ");
        }

        for (int l = 0; l < 49; l++) {
            porog1[0][l] = porog[0][l];
        }


        double[] o1_cl = new double[80];
        double[] o2_cl = new double[80];
        double[] o3_cl = new double[80];

        //int numClass = 0;
        //System.out.println("ENter class");
        //Scanner sc = new Scanner(System.in);
        //if (sc.hasNextInt()) {
        //  numClass = sc.nextInt();
        //}

        int countName = 0;
        for (int j = 1; j < count; j++) {

            if (porog[0][j - 1] < porog[0][j]) {
                double buff = 0;
                double buffName;
                if (countName == 0)
                    for (int l = 0; l < j; l++) {
                        o1_cl[l] = nameArray[l];
                        countName = 1;
                    }
                buffName = namePorog[j - 1];
                namePorog[j - 1] = namePorog[j];
                namePorog[j] = buffName;

                buff = porog[0][j - 1];
                porog[0][j - 1] = porog[0][j];
                porog[0][j] = buff;
                j = 0;


            }
        }


        int countClass1 = 0;
        for (int l = 0; l < 49; l++) {
            if (namePorog[0] == nameArray[l]) {
                countClass1 = l;
            }
        }
        int countClass2 = 0;
        int countBuff = 0;
        for (int l = 0; l < 49; l++) {
            if (namePorog[1] == nameArray[l]) {
                countClass2 = l;
            }
        }
        if (countClass1 > countClass2) {
            countBuff = countClass1;
            countClass1 = countClass2;
            countClass2 = countBuff;
        }

        for (int j = 0; j <= countClass1; j++) {
            o1_cl[j] = nameArray[j];
        }
        for (int j = countClass1 + 1, p = 0; j <= countClass2; j++, p++) {
            o2_cl[p] = nameArray[j];
        }

        for (int j = countClass2 + 1, p = 0; j < amountOfImages; j++, p++) {
            o3_cl[p] = nameArray[j];
        }


        System.out.println();
        System.out.println("Porog posle sort");

        for (int j = 0; j < count; j++) {

            System.out.print(porog[0][j] + " ");

        }
        System.out.println();


        for (int j = 0; j < amountOfImages; j++) {
            System.out.print(nameArray[j] + "  ");
        }
        System.out.println();
        System.out.println("1klass");
        for (int j = 0; j < amountOfImages; j++) {
            System.out.print(o1_cl[j] + "  ");
        }
        System.out.println();
        System.out.println("2klass");
        for (int j = 0; j < amountOfImages; j++) {
            System.out.print(o2_cl[j] + "  ");
        }
        System.out.println();
        System.out.println("3klass");
        for (int j = 0; j < amountOfImages; j++) {
            System.out.print(o3_cl[j] + "  ");
        }

        System.out.println();
       // System.out.println("OTBET: " + porog[0][1]);
    }

    public void setBuffer(Double[][] buffer) {

    }
}
