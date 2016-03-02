import api.Bag;
import api.Queue;

import java.util.Scanner;

/**
 * Created by lizhaoz on 2016/1/8.
 */

public class Stats {
    public static void main(String[] args) {
        Queue<Double> numbers=new Queue<Double>();
        Scanner in=new Scanner(System.in);
        Double d=in.nextDouble();
        while(d!=0){
            numbers.enqueue(d);
            d=in.nextDouble();
        }
        int N=numbers.size();
        System.out.println(numbers.toString());
    }
}
