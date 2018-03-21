//import java.util.Scanner;
//
//public class Spectr  {
//    private static final int SIZE = 1;
//
//    private String startPoint;
//    private  Double[][] Buffer = new Double[16][8];
//    private String[] nameArray = new String[50];
//
//    private String[][] data = new String[SIZE][1];
//    private Double[][] fourTable = new Double[1][50];
//    private Double[][] rast = new Double[1][50];
//
//    public String choseStartPoint(){
//        System.out.println("Enter start point");
//        Scanner sc = new Scanner(System.in);
//        if(sc.hasNext()){
//            startPoint = sc.nextLine();
//        }
//        // System.out.println(startPoint);
//        return startPoint;
//
//    }
//
//    public void createFourTable() {
//        boolean flag = true;
//        int i = 0;
//        int resultString = 0;
//        while (flag) {
//            if (startPoint.equals(data[i][0])) {
//                resultString = i;
//                flag = false;
//            } else {
//                i++;
//            }
//        }
//        for (int k = 1; k <7 ; k++) {
//            Buffer[0][k] =   Double.valueOf(data[resultString][k]);
//
//
//        }
//
//        nameArray[0] = data[resultString][0];
//
//        int i_min = resultString;
//
//
//        //System.out.println(resultString);
//        int k = 15;
//        for (int x = 0; x < 14; x++) {
//
//            for (int j = 0; j < k; j++) {
//                if(i_min == j){
//                    for (int l = j; l < k; l++) {
//                        for (int m = 0; m <7; m++) {
//
//                            data[l][m] = data[l+1][m];
//
//
//                        }
//                    }
//                    j=k;//прерывание цикла(пасхалочка2)
//                }
//            }
//            k--;
//
////***********Rastoianie************//
//
//            for (int j = 0; j < k; j++) {
//                fourTable[0][j] =
//                        Math.sqrt(Math.pow((Double.valueOf(Buffer[0][1]) - Double.valueOf(data[j][1])), 2) +
//                                Math.pow((Double.valueOf(Buffer[0][2]) - Double.valueOf(data[j][2])), 2) +
//                                Math.pow((Double.valueOf(Buffer[0][3]) - Double.valueOf(data[j][3])), 2) +
//                                Math.pow((Double.valueOf(Buffer[0][4]) - Double.valueOf(data[j][4])), 2) +
//                                Math.pow((Double.valueOf(Buffer[0][5]) - Double.valueOf(data[j][5])), 2) +
//                                Math.pow((Double.valueOf(Buffer[0][6]) - Double.valueOf(data[j][6])), 2));
//            }
//
////****************min****************//
//            double min;
//
//            if (fourTable[0][0] != 0) {
//                min = fourTable[0][0];
//                i_min = 0;
//            } else {
//                min = fourTable[0][1];
//                i_min = 1;
//            }
//
//
//            for (int j = 0; j < k; j++) {
//                if ((fourTable[0][j] < min) && (fourTable[0][j] != 0)) {
//                    min = fourTable[0][j];
//                    i_min = j;
//                }
//            }
//            rast[0][x] = min;
//
//            //***********novi element**********//
//            for (int j = 1; j < 7; j++) {
//                double xx=Double.valueOf(Buffer[0][j]);
//                double yy = Double.valueOf(data[i_min][j]);
//                Buffer[0][j] = (( xx+yy ) / 2);
//            }
//            nameArray[x+1] = data[i_min][0];
//        }
//        System.out.println("Rasstoyania");
//        for (int j = 0; j <15; j++) {
//            System.out.print(rast[0][j] + " ");
//        }
//
//        int b = 0;
//        for (int j = 1; j < 14; j++) {
//            if(rast[0][j-1]<rast[0][j]){
//
//                namePorog[b] = nameArray[j];
//                porog[0][b] = (rast[0][j] - rast[0][j-1]);
//                b++;
//            }
//
//        }
//
//        int count=1;
//        if(b!=0)count = b-1;
//        System.out.println();
//        System.out.println("Porog do sort");
//        for (int j = 0; j <count ; j++) {
//            System.out.print(count + " " + porog[0][j] + " ");
//        }
//
//        for (int l = 0; l < 49; l++) {
//            porog1[0][l] = porog[0][l];
//        }
//
//
//        String[] o1_cl = new String[15];
//        String[] o2_cl = new String[15];
//        String[] o3_cl = new String[15];
//        int numClass  = 0;
//        System.out.println("ENter class");
//        Scanner sc = new Scanner(System.in);
//        if(sc.hasNextInt()){
//            numClass = sc.nextInt();
//        }
//        int countName=0;
//        for (int j = 1; j < count; j++) {
//
//            if(porog[0][j-1] < porog[0][j]){
//                double buff = 0;
//                String buffName;
//                if(countName==0)
//                    for (int l = 0; l < j; l++) {
//                        o1_cl[l]=nameArray[l];
//                        countName=1;
//                    }
//                buffName=namePorog[j-1];
//                namePorog[j-1]=namePorog[j];
//                namePorog[j]=buffName;
//
//                buff = porog[0][j-1];
//                porog[0][j-1] = porog[0][j];
//                porog[0][j] = buff;
//                j = 0;
//
//
//            }
//        }
//
//        int countClass1 = 0;
//        for (int l = 0; l <49 ; l++) {
//            if(namePorog[0] == nameArray[l]){
//                countClass1 = l;
//            }
//        }
//        int countClass2 = 0;
//        int countBuff = 0;
//        for (int l = 0; l <49 ; l++) {
//            if(namePorog[1] == nameArray[l]){
//                countClass2 = l;
//            }
//        }
//        if(countClass1 > countClass2){
//            countBuff = countClass1;
//            countClass1 = countClass2;
//            countClass2 = countBuff;
//        }
//
//        for (int j = 0; j <=countClass1 ; j++) {
//            o1_cl[j] = nameArray[j];
//        }
//        for (int j = countClass1+1, p=0; j <=countClass2 ; j++,p++) {
//            o2_cl[p] = nameArray[j];
//        }
//
//        for (int j = countClass2+1, p = 0; j <15; j++, p++) {
//            o3_cl[p] = nameArray[j];
//        }
//
//
//        System.out.println();
//        System.out.println("Porog posle sort");
//
//        for (int j = 0; j < count; j++) {
//
//            System.out.print(porog[0][j] + " ");
//
//        }
//        System.out.println();
//
//
//        for (int j = 0; j < 15; j++) {
//            System.out.print(nameArray[j] + "  ");
//        }
//        System.out.println();
//        System.out.println("1klass");
//        for (int j = 0; j < 15; j++) {
//            System.out.print(o1_cl[j] + "  ");
//        }
//        System.out.println();
//        System.out.println("2klass");
//        for (int j = 0; j < 15; j++) {
//            System.out.print(o2_cl[j] + "  ");
//        }
//        System.out.println();
//        System.out.println("3klass");
//        for (int j = 0; j < 15; j++) {
//            System.out.print(o3_cl[j] + "  ");
//        }
//
//        System.out.println();
//        System.out.println("OTBET: " + porog[0][1] );
//    }
//}
