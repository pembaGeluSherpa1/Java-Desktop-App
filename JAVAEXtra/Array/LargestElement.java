package Array;

public class LargestElement {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8};
        LargestElement l = new LargestElement();
        l.findLargestArr(a);
        l.findSmallestArr(a);

        System.out.println("un-reversed array");

        for (int i : a) {
            System.out.print(i+" ");
        }

        System.out.println();
        System.out.println("Reversed array");

        l.arrayReverse(a);

        l.searchArray(a, 6);
    }

    void findLargestArr(int[] a){
        int largest = a[0];

        System.out.println();
        // for (int i : a) {
        //     if (largest<i) largest = i;
        // }

        int N = a.length;

        for(int i=0;i<N;i++){
            if (a[i]>largest) largest = a[i]; 
        }
        System.out.println("Largest Element in an array is "+largest);
    }

    void findSmallestArr(int[] a){
        int smallest = a[0];

        System.out.println();
        // for (int i : a) {
        //     if (largest<i) largest = i;
        // }

        int N = a.length;

        for(int i=0;i<N;i++){
            if (a[i]<smallest) smallest = a[i]; 
        }
        System.out.println("Smallest Element in an array is "+smallest);
    }

    void arrayReverse(int[] a){
        // Array reverse 
        int num = a.length-1;
        int[] b = new int[a.length];

        // for(int i = num; i>=0;i--){
        //     b[num-i] = a[i];
        // }

        // alternative solution 

        int idx =  0;
        for(int i = num; i >=0;i--){
            b[idx] = a[i];
            idx++;
        }

        for (int i : b) {
            System.out.print(i+" ");
        }
    }

    void searchArray(int[] a,int search){
        boolean x = false;
        for(int i:a){
            if(search == i){
                x=true;
                break;
            }
            }
            System.out.println(x);

        }
    }
