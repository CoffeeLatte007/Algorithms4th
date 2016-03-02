package sort;

import java.util.Scanner;

/**
 * 三向切分快速排序
 * Created by lizhaoz on 2016/1/8.
 */

public class QuickSort3way {
    public static void sort(Comparable[] a){
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi<=lo) return;
        int lt=lo,i=lo+1,gt=hi;
        Comparable v=a[lo];
        //i到gt之间是未知的
        while (i<=gt){
            //比较v和a[i]的值
            int cmp=a[i].compareTo(v);
            //如果a[i]小于V,把他移到左边,i++，因为此时的i是lt的值
            if (cmp<0) exch(a,lt++,i++);
            //如果a[i]大于V,把他移到右边，此时不会加i,交换过来的i不知道大小
            else if (cmp>0) exch(a,i,gt--);
            //如果a[i]等于v，不变位置
            else i++;
        }//a[lo..lt-1]<v=a[lt..gt]<a[gt+1..hi]成立,大量相等的就不会进入递归了，适用于大量重复元素的递归
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
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
