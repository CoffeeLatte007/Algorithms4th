package string;

/**
 * 暴力算法子字符串查找
 * Created by lizhaoz on 2016/1/28.
 */

public class VoliteString {
    /**
     * 暴力算法的第一种实现
     * @param pat
     * @param txt
     * @return
     */
    public static int search1(String pat,String txt){
        int M=pat.length();
        int N=txt.length();
        for (int i = 0; i < N-M; i++) {
            int j;
            for ( j = 0; j < M; j++) {
                if (txt.charAt(i+j)!=pat.charAt(j))
                    break;
            }
            if (j==M)return i;//找到匹配
        }
        return N;
    }

    /**
     * 暴力算法的第二种实现主要是i的意义不同
     * @param pat
     * @param txt
     * @return
     */
    public static int search2(String pat,String txt){
        int j,M=pat.length();
        int i,N=txt.length();
        for (i = 0,j=0; i <N&&j<M ; i++) {
            if (txt.charAt(i)==pat.charAt(j)) j++;
            else {i-=j;j=0;}
        }
        if (j==M)return i-M;//找到匹配
        else return N;//没找到匹配
    }
}
