package sort;

import java.util.Scanner;

/**
 * 选择排序思想:
 * 首先找到数组中最小的那个元素，其次，将它和数组的第一个元素交换的位置（如果第一个元素就是最小元素那么它就和自己交换）
 * 再次，在剩下的元素中找到最小的元素，将它和数组的第二个元素交换位置。如此往复，直到将整个数组排序。
 * 运行时间和输入无关
 * 数据移动最少
 * Created by lizhaoz on 2016/1/8.
 */

public class SelectionSort {
    public static void sort(Comparable[] a){
        //升序排列
        int N=a.length;
        for (int i = 0; i <N ; i++) {
            int min=i;
            for (int j = i+1; j < N; j++) {
                //判断a[j]和a[min]谁小
                if (less(a[j],a[min])) min=j;
            }
            //这次循环出来之后就是min就是最小的位置了，和i交换
            exch(a,i,min);
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
