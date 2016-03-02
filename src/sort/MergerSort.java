package sort;

import java.util.Scanner;

/**
 * 自上向下的归并排序 分治思想的体现
 * Created by lizhaoz on 2016/1/8.
 */

public class MergerSort {
    //归并所需要的辅助数组
    private static Comparable[] aux;
    public static void sort(Comparable[] a){
       aux=new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        //排序a[lo..hi]
        if (hi<=lo) return;
        //得到中间界限
        int mid=lo+(hi-lo)/2;
        sort(a,lo,mid);//排序左半部分
        sort(a,mid+1,hi);//排序右半部分
        merge(a,lo,mid,hi);//合并两边
    }

    public static void merge(Comparable[] a,int lo,int mid,int hi){
        //归并a[lo..mid]和a[mid+1..hi]
        int i=lo,j=mid+1;
        //将所有元素复制到辅助数组
        for (int k = lo; k <=hi ; k++) {
            aux[k]=a[k];
        }
        for (int k = lo; k <=hi ; k++) {
            if (i>mid) a[k]=aux[j++];//如果前半段用完，后半段剩下的直接填充
            else if (j>hi) a[k]=aux[i++];//如果后半段用完，前半段剩下的填充
            else if(less(aux[j],aux[i])) a[k]=aux[j++]; //j小于i的话
            else a[k]=aux[i++];//i小于J的话
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
