package Fabonic;

import java.util.Scanner;

public class FabonicSeries {
    public static void main(String[] args) {
        System.out.println("Enter a n-th number to get fabonic upto it: ");
        Scanner a = new Scanner(System.in);
        int num = a.nextInt();
        for (int i = 0; i<=num;i++ ) {
        int fact = fabonicSeries(i);
        System.out.print(fact+", ");
        }
    }

    public static int fabonicSeries(int num){
        if(num == 0 || num == 1) return 1;
        return fabonicSeries(num-1)+fabonicSeries(num-2);
    }
}
