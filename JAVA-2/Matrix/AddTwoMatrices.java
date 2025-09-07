package Matrix;

import java.util.Scanner;

public class AddTwoMatrices {
    public static void main(String[] args) {
        System.out.println("Enter the 1st matrix:");
        System.out.println("Enter number of row");

        Scanner x = new Scanner(System.in);
        int m = x.nextInt(); // row for the 1st matrix and column for the 2nd matrix

        System.out.println("Enter a number of column");
        int n = x.nextInt(); // column for the 1st matrix and row for the 2nd matrix

        int[][] arr1 = new int[m][n]; 

        // inserting the value in the 1st matrix
        System.out.println("Insert the elements for the 1st matrix");
        for(int i = 0; i < m; i++){
            for(int j=0; j<n;j++){
                arr1[i][j] = x.nextInt();
            }
        }

        System.out.println("**************************");


        int[][] arr2 = new int[n][m];

        // inserting the value in the 2nd matrix
        System.out.println("Insert the elements for the 2nd matrix");
        for(int i = 0; i<n;i++){
            for(int j=0; j<m;j++){
                arr2[i][j] = x.nextInt();
            }
        }

        // display both the matrix
        

    }
}
