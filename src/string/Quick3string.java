package string;


/**
 * 三向字符串快速排序
 * Created by lizhaoz on 2016/1/23.
 */

public class Quick3string {
    private static int charAt(String s,int d){
        if(d<s.length())return s.charAt(d);else return -1;
    }
    public static void sort(String[] a)
    {sort(a,0,a.length-1,0);}
    //a[lo...lt-1]<v=a[lt..gt]<a[gt+1..hi]
    private static void sort(String[] a, int lo, int hi,int d) {
        if (hi<=lo) return;
        int lt=lo,gt=hi;
        int v=charAt(a[lo],d);//以a[lo]的d个字符作为三向划分界限
        int i=lo+1;
        while (i<=gt){
            int t=charAt(a[i],d);
            if (t<v)exch(a,lt++,i++);
            else if (t>v)exch(a,gt--,i);
            else i++;//相等直接i++
        }
        //已经排列好顺序了
        sort(a,lo,lt-1,d);//把左边的排序
        if (v>=0)sort(a,lt,gt,d+1);//如果d为字符相同就d+1继续排序
        sort(a,gt+1,hi,d);
    }
    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
