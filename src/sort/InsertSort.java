package sort;

import java.util.Scanner;

/**
 * 插入排序
 * 对于一些已经有序的来说比较快，同样适合小规模数组
 * Created by lizhaoz on 2016/1/8.
 */

public class InsertSort {
    public static void sort(Comparable[] a){
        int N=a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j >0&&less(a[j],a[j-1]) ; j--) {
                exch(a,j,j-1);
            }
        }
    }
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    private static void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
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
