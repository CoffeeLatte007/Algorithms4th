package sort;

import java.util.Scanner;

/**
 * 希尔排序——唯一无法准确描述其对于乱序的数组的性能特征的排序方法
 * 插入排序是步长为1的排序
 * 希尔排序改进了插入排序，交换不相邻的元素对数组局部排序
 * Created by lizhaoz on 2016/1/8.
 */

public class ShellSort {
    public static void sort(Comparable[] a){
        int N=a.length;
        int h=1;
        while (h<N/3) h=3*h+1;
        while(h>=1){
        for (int i = h; i < N; i++) {
            //将a[i]插到a[i-h],a[i-2*h]
            for (int j = i; j >=h&&less(a[j],a[j-h]) ; j-=h) {
                exch(a,j,j-1);
            }
        }
            h=h/3;
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
