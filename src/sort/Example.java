package sort;

import java.util.Comparator;
import java.util.Scanner;

/**
 * 使用于任意实现了Comparable接口
 * Created by lizhaoz on 2016/1/8.
 */

public class Example {
    private static Comparable[] aux;
    public static void sort(Comparable[] a){
        int N=a.length;
        for (int k = N/2; k >= 1; k--)
            sink(a, k, N);//构造
        while (N>1){
            exch(a,1,N--);
            sink(a,1,N);
        }

    }

    private static void sink(Comparable[] a, int k, int N) {
        while(2*k<=N)
        {
            int j=2*k;
            if (j<N&&less(a[j-1],a[j])) j++;
            if (!less(a[k-1],a[j-1]))break;
            exch(a,k,j);
            k=j;
        }
    }


    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    private static void exch(Comparable[] a,int i,int j){
        Comparable t=a[i-1];
        a[i-1]=a[j-1];
        a[j-1]=t;
    }
    private static void show(Comparable[] a){
        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i <a.length ; i++) {
            if(less(a[i],a[i-1])) return false;
        }
        return  true;
    }
    public static void main(String[] args) {
        Double[] numbers=new Double[10];
        Scanner in=new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            numbers[i]=in.nextDouble();
        }
        sort(numbers);
        show(numbers);
    }
}
