package Matrix;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        System.out.println("Enter the row for 1st matrix");
        int a = num.nextInt();
        System.out.println("Enter the column for 1st matrix");
        int b = num.nextInt();

        System.out.println("**************************************");

        System.out.println("Enter the row for 2nd matrix");
        int c = num.nextInt();
        System.out.println("Enter the column for 1st matrix");
        int d = num.nextInt();

        System.out.println("***************************************");

        System.out.println("Now insert the numbers in the 1st matrix");
        int[][] first = new int[a][b];

        for(int i=0;i<=a;i++){
            for(int j=0;j<=b;j++){
                first[i][j] = num.nextInt();
            }
        }

        System.out.println("***************************************");

        System.out.println("Now insert the numbers in the 2nd matrix");
        int[][] second = new int[a][b];
    }
}
