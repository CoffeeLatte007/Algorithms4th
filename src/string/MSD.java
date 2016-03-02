package string;

import sort.InsertSort;

/**
 * 高位优先字符串排序
 * Created by lizhaoz on 2016/1/23.
 */

public class MSD {
    private static int R=256;//基数
    private static final int M=15;//小数组的切换阀值
    private static String[] aux;//数据分类的辅助数组
    private static int charAt(String s,int d){
        if(d<s.length())return s.charAt(d);else return -1;
    }
    public static void sort(String[] a){
        int N=a.length;
        aux=new String[N];
        sort(a,0,N-1,0);//从0开始到N-1 排序第d位
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        //以第d个字符为键将a[lo]到a[hi]排序
        if (hi<=lo+M){
            //这是快速排序的代码
        }
        int[] count=new int[R+2];
        //统计频率
        for (int i = lo; i <=hi ; i++) {//在这里第0位没有用，第1位是长度为d的数量也就是已经比完的数量，后面是长度为
            count[charAt(a[i],d)+2]++;
        }
        for (int r = 0; r <R+1 ; r++) {//将频率转换为索引 这里的首位是长度为d的子数组的起始索引
            count[r+1]+=count[r];
        }
        for (int i = lo; i <=hi ; i++) {
            aux[count[charAt(a[i],d)+1]++]=a[i];
        }
        for (int i = lo; i <=hi ; i++) {//回写
            a[i]=aux[i-lo];
        }
        //递归的以每个字符为键排序
        for (int r = 0; r < R; r++) {//上一个结束的位置也就是自己的开头，所以Hi的时候是下一个的开头减去1才是自己末尾
            sort(a,lo+count[r],lo+count[r+1]-1,d+1);
        }
    }
}
