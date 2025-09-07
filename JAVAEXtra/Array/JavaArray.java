package Array;

public class JavaArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println("Integer array");

        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i]+" ");
        // }

        for(int n:arr){
            System.out.print(n+" ");
        }
        
        System.out.println();
        System.out.println();

        JavaArray j = new JavaArray();
        j.sumOfIntArr(arr);
        j.multiOfArr(arr);

        // System.out.println("String Array");
        // String[] a = {"Apple","Pemba","Ram","Shyam"};
        // // for(int i=0;i<a.length;i++){
        // //     System.out.print(a[i]+" ");
        // // }
        // for(String n: a){
        //     System.out.print(n+" ");
        // }

        System.out.println();
        System.out.println();
        System.out.println("Double Array");
        double[] d = {12.32,3233.23,2323,232,23312,232};
        // for(int i=0;i<d.length;i++){
        //     System.out.print(d[i]+" ");
        // }
        for(double n:d){
            System.out.print(n+" ");
        }

        System.out.println();

        j.multiOfArr(d);
        j.sumOfIntArr(d);

        // System.out.println();
        // System.out.println();

        // int[] n = new int[5];
        // for(int num: n){
        //     System.out.println(num+5);
        // }
    }

    public void sumOfIntArr(int[] a){
        int sum = 0;
        // for(int i=0;i<a.length;i++){
        //     sum+=a[i];
        // }

        for(int n: a) sum+=n;
        System.out.println("Sum of array: "+sum);
    }

    public void multiOfArr(int[] a){
        int multi = 1;
        for (int i : a) multi*=i;
        System.out.println("Multiplication of an array: "+multi);
    }

    // Fof double

    public void sumOfIntArr(double[] a){
        double sum = 0;
        // for(int i=0;i<a.length;i++){
        //     sum+=a[i];
        // }

        for(double n: a) sum+=n;
        System.out.println("Sum of double array: "+sum);
    }

    public void multiOfArr(double[] a){
        double multi = 1;
        for (double i : a) multi*=i;
        System.out.println("Multiplication of double array: "+multi);
    }
}