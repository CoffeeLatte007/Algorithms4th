package string;

/**
 * 低位优先排序
 * 桶排序的次序
 * Created by lizhaoz on 2016/1/23.
 */

public class LSD {
    private LSD(){
    }
    private static void sort(String[] a,int w){
        //通过前W个字符将a[]排序
        int N=a.length;
        int R=256;//ascall字符256之内
        String[] aux=new String[N];
        for (int d = w-1; d >=0 ; d--) {
            //将第d个字符用键索引计数法排序
            int[] count=new int[R+1];//计算出现的频率
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d)+1]++;
            }
            for (int r = 0; r < R; r++) {//频率转换为索引
                count[r+1]=count[r]++;
            }
            for (int i=0;i<N;i++){//讲元素分类
                aux[count[a[i].charAt(d)]++]=a[i];
            }
            for (int i = 0; i <N; i++) {//回写
                a[i]=aux[i];
            }
        }
    }
}
