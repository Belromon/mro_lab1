public class Code {



    int b = 0;
    int[][] codeNapr = new int[400][8];
    public int count = 0, codeCount=0;
    public   int[][] codeNaprAll = new int[400][8];

    public int[][] func(double[][] imgMatr, double[][] infMatr, double minMin, double maxMin) {
        int a = 0;

        double vector;
        double[][] coordMatr = new double[200][2];
        while (minMin < maxMin) {


            for (int j = 0; j < 30; j++) {
                for (int k = 0; k < 30; k++) {
                    if (infMatr[j][k] == minMin) {

                        for (int i = j - 2; i < j + 3; i++) {
                            for (int o = k - 2; o < k + 3; o++) {

                                infMatr[i][o] = -1;
                            }
                        }

                        coordMatr[a][0] = j;
                        coordMatr[a][1] = k;
                        a++;
                    }
                }
            }
            minMin++;
        }

        for (int j = 0; j < a; j++) {
            for (int k = 0; k < a; k++) {
                if (j != k) {
                    int buff;
                    double c1 = coordMatr[k][1] - coordMatr[j][1];
                    double c2 = coordMatr[k][0] - coordMatr[j][0];
                    double c3 = Math.pow(c2, 2) + Math.pow(c1, 2);
                    double chislitel = 180 * Math.abs(c1);
                    double znam = Math.PI * Math.pow(c3, 0.5);
                    vector = chislitel / znam;

                    if (coordMatr[k][0] > coordMatr[j][0]) {
                        if (vector == 0) buff = 2;
                        else
                            buff = (int) ((360 - vector) / 45);
                    } else {
                        if (vector == 0) buff = 6;
                        else
                            buff = (int) (vector / 45);
                    }
                    //System.out.println(buff);
                    codeNapr[b][buff]++;
                }
            }
            b++;
        }


//        for (int i = 0; i < b; i++) {
//            for (int j = 0; j < 8; j++) {
//                System.out.print(codeNapr[i][j]);
//            }
//            System.out.println();
//        }
        return codeNapr;
    }

    public void allCN() {


        boolean flag = true;
        for (int i = 0; i < b; i++) {


            for (int k = 0; k <= count; k++) {
                for (int j = 0; j < 8; j++) {
                    if (codeNaprAll[k][j] == codeNapr[i][j]) codeCount++;
                }
                if (codeCount == 8)  flag = false;
                codeCount=0;
            }


            if (flag == true) {
                for (int j = 0; j < 8; j++) {
                    codeNaprAll[count][j] = codeNapr[i][j];

                }
                count++;
            }
            else
            {
                flag=true;
            }

        }
        for (int i = 0; i <count ; i++) {
            for (int j = 0; j <8 ; j++) {
                System.out.print(codeNaprAll[i][j]);
            }
            System.out.println();
        }
    }
}

