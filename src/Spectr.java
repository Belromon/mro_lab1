public class Spectr {
    public Spectr()
    {
        Main2 m = new Main2();

    };
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

        int allIMg = amountOfImages;
        int amountOfTags = 25;
        double[][] Buffer = new double[80][80];
        double[] nameArray = new double[80 + 1];
        double[][] fourTable = new double[amountOfImages + 1][amountOfImages + 1];
        double[][] rast = new double[amountOfImages + 1][amountOfImages + 1];
        double[][] porog = new double[80 + 1][80 + 1];
        double[] namePorog = new double[80 + 1];
        double[][] porog1 = new double[80 + 1][80 + 1];
        //int[][] test = new int[data.length][26];
       // test = data;

        double startPoint = -1;
        boolean flag = true;
        int i = 0;
        int resultString = 0;

        System.out.println("Enter start point");

        // Scanner sc = new Scanner(System.in);
//        if (sc.hasNext()) {
//            startPoint = sc.nextInt();
//        }

        startPoint = 5;
//Определяет является ли точка стартовой
        while (flag) {
            if (startPoint == data[i][0]) {
                resultString = i;
                flag = false;
            } else {
                i++;
            }
        }
        //Забивает в буфер признаки стартовой точки
        for (int k = 1; k <= amountOfTags; k++) {
            Buffer[0][k] = Double.valueOf(data[resultString][k]);
        }

        //Щапоминаем номер старотовой точки
        nameArray[0] = data[resultString][0];
//i_min - начальная точка
        int i_min = resultString;


        //****************************************************//
// в этом цикле считается указанное количество расстояний

        for (int x = 0; x < allIMg; x++) {

            //Удаляет текущую строку из общего списка
            for (int j = 0; j < amountOfImages; j++) {
                if (i_min == j) {
                    for (int l = j; l < amountOfImages - 1; l++) {
                        for (int m = 0; m < 26; m++) {

                            data[l][m] = data[l + 1][m];


                        }
                    }
                    j = amountOfImages;//прерывание цикла(пасхалочка2)
                }
            }
            amountOfImages--;

//***********Нахождение расстояний с текущей точкой************//


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

            //находится минимальное расстояние
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
        //************************************************//


        System.out.println("Rasstoyania");
        for (int j = 0; j < allIMg; j++) {
            System.out.print(rast[0][j] + " ");
        }
//считаем пороги
        int b = 0;
/////??????

        //нахождение порогов
        for (int j = 1; j < allIMg - 1; j++) {
            if (rast[0][j - 1] < rast[0][j]) {

                namePorog[b] = nameArray[j];
                porog[0][b] = (rast[0][j] - rast[0][j - 1]);
                b++;
            }

        }


        int count = 1;
        if (b != 0) count = b;////???? -1

        System.out.println();
        System.out.println("Porog do sort");
        for (int j = 0; j < count; j++) {
            System.out.print(porog[0][j] + " ");
        }

        for (int l = 0; l < count; l++) {
            porog1[0][l] = porog[0][l];
        }


        double[][] o1_cl = new double[80][80];
        double[][] o2_cl = new double[80][80];
        double[][] o3_cl = new double[80][80];


        //int numClass = 0;
        //System.out.println("ENter class");
        //Scanner sc = new Scanner(System.in);
        //if (sc.hasNextInt()) {
        //  numClass = sc.nextInt();
        //}

        int countName = 0;
        //Сортировка порогов
        for (int j = 1; j < count; j++) {

            if (porog[0][j - 1] < porog[0][j]) {
                double buff = 0;
                double buffName;
                //&&&&&&&&&&&&&&&&&&&&&&&&&//
//                if (countName == 0)
//                    for (int l = 0; l < j; l++) {
//                        o1_cl[l] = nameArray[l];
//                        countName = 1;
//                    }
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
        for (int l = 0; l < nameArray.length; l++) {
            if (namePorog[0] == nameArray[l]) {
                countClass1 = l;
            }
        }
        int countClass2 = 0;
        int countBuff = 0;
        for (int l = 0; l < nameArray.length; l++) {
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
            o1_cl[j][0] = nameArray[j];
        }

        for (int j = 0; j < m.test1.length; j++) {
            for (int k = 0; k < 26; k++) {
                System.out.print(test1[j][k] + " ");
            }
            System.out.println();
        }

        for (int j = 0; j < o1_cl.length; j++) {
            for (int k = 0; k < test1.length; k++) {
                if (o1_cl[j][0] == test1[k][0]){

                        for (int m = 1; m < 26 ; m++) {
                            o1_cl[j][m] = test1[k][m];
                        }

                }
            }
        }

        for (int j = countClass1 + 1, p = 0; j <= countClass2; j++, p++) {
            o2_cl[p][0] = nameArray[j];
        }

        for (int j = 0; j < 30; j++) {
            for (int k = 0; k < 66; k++) {
                if (o2_cl[j][0] == test1[k][0]){

                    for (int m = 1; m < 27 ; m++) {
//                        o2_cl[j][m] = test[k][m];
                    }

                }
            }
        }



        for (int j = countClass2 + 1, p = 0; j < allIMg; j++, p++) {
            o3_cl[p][0] = nameArray[j];
        }
        for (int j = 0; j < o3_cl.length; j++) {
            for (int k = 0; k < test1.length; k++) {
                if (o3_cl[j][0] == test1[k][0]){

                    for (int m = 1; m < 27 ; m++) {
                      //  o3_cl[j][m] = test[k][m];
                    }

                }
            }
        }


        System.out.println();
        System.out.println("Porog posle sort");

        for (int j = 0; j < count; j++) {

            //  System.out.print(porog[0][j] + " ");

        }
        System.out.println();


        for (int j = 0; j < allIMg; j++) {
            System.out.print(nameArray[j] + "  ");
        }
        System.out.println();
        System.out.println("1klass");
        for (int j = 0; j < o1_cl.length; j++) {
            for (int k = 0; k <27; k++) {


             //   System.out.print(o1_cl[j][k] + "  ");
            }
            System.out.println();
        }
//        System.out.println();
//        System.out.println("2klass");
//        for (int j = 0; j < o2_cl.length; j++) {
//            System.out.print(o2_cl[j][0] + "  ");
//        }
//        System.out.println();
//        System.out.println("3klass");
//        for (int j = 0; j < o3_cl.length; j++) {
//            System.out.print(o3_cl[j][0] + "  ");
//        }

        System.out.println();
        // System.out.println("OTBET: " + porog[0][1]);

        double o1[][] = new double[5][5];
        double o2[][] = new double[5][5];
        double o3[][] = new double[5][5];

        o1 = setBuffer(o1_cl);
        o2 = setBuffer(o2_cl);
        o3 = setBuffer(o3_cl);

        printMatr(o1);


    }

    public double[][] setBuffer(double[][] buffer) {
        // x - количество элементов
        int x = buffer.length;
        double[][] mas = new double[x][26];
        mas = buffer;

        double result[] = new double[x];

        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < x; j++) {
                result[i] += mas[j][i];
            }
        }
        double sum = sum(result);
        int count = 0;

        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) {
                count++;
            }
        }

        double k = sum / count;
        int s = 0;
        //ошибка тут
        double matr[][] = new double[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (result[s] < k) {
                    matr[i][j] = 0;
                } else {
                    matr[i][j] = 1;
                }
                s++;

            }
        }


        return matr;
    }

    private double sum(double[] ar) {
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            sum += ar[i];

        }
        return sum;
    }

    private void printMatr(double matr[][]){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matr[i][j] + " ");

            }
            System.out.println();
        }
    }

    public void maxim(double[][] etalon, int maxMin, int minMin){

        while (minMin <maxMin ){
            for (int i = 0; i <30 ; i++) {
                for (int j = 0; j < 30; j++) {
                    for (int k = 0; k < 30; k++) {
                        if()
                    }
                }
            }
        }
    }


}
