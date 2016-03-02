package chapter2;

import api.Stack;

import java.util.Scanner;

/**
 * (1+((2+3)*(4*5)))测试
 * Created by lizhaoz on 2016/1/8.
 */

public class DijkstraEvalute {
    public static void main(String[] args) {
        Stack<String> ops=new Stack<String>();
        Stack<Double> vals=new Stack<Double>();
        Scanner in=new Scanner(System.in);
        String s=in.next();
        char[] c=s.toCharArray();
        for (int i = 0; i <c.length ; i++) {
            if (String.valueOf(c[i]).equals("("));
            else if (String.valueOf(c[i]).equals("+")) ops.push("+");
            else if (String.valueOf(c[i]).equals("-")) ops.push("-");
            else if (String.valueOf(c[i]).equals("*")) ops.push("*");
            else if (String.valueOf(c[i]).equals("/")) ops.push("/");
            else if (String.valueOf(c[i]).equals("sqrt")) ops.push("sqrt");
            else if (String.valueOf(c[i]).equals(")")){
                //如果为右括号，弹出运算符和两个操作数，计算结果再次压入值栈
                String op=ops.pop();
                double v=vals.pop();
                if(op.equals("+")) v=vals.pop()+v;
                else if(op.equals("-")) v=vals.pop()-v;
                else if(op.equals("*")) v=vals.pop()*v;
                else if(op.equals("/")) v=vals.pop()/v;
                else if(op.equals("sqrt")) v=Math.sqrt(v);
                vals.push(v);
            }
            else vals.push(Double.parseDouble(String.valueOf(c[i])));
        }
        System.out.println(vals.pop());
    }
}
