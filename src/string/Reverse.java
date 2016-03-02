package string;

/**
 *

 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。

 给定一个原字符串A和他的长度，请返回逆序后的字符串。
 测试样例：

 "dog loves pig",13

 返回："pig loves dog"


 * Created by lizhaoz on 2016/1/28.
 */

public class Reverse {
    public String reverseSentence(String A, int n) {
        int lo=0,hi=0;
        char[] cs=A.toCharArray();
        reversestring(cs, 0, n - 1);
        for (int i = 0; i < n; i++) {
            if (cs[i]==' ')
            {
                reversestring(cs,lo,hi-1);
                hi++;
                lo=hi;
            }
            else{
                hi++;
            }
        }
        reversestring(cs,lo,hi-1);
        return String.valueOf(cs);
    }

    private void reversestring(char[] cs, int lo, int hi) {

        while (hi>lo){
            char c=cs[lo];
            cs[lo]=cs[hi];
            cs[hi]=c;
            lo++;hi--;
        }
    }
}
