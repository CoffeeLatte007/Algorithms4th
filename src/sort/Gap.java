package sort;

/**
 *

 有一个整形数组A，请设计一个复杂度为O(n)的算法，算出排序后相邻两数的最大差值。

 给定一个int数组A和A的大小n，请返回最大的差值。保证数组元素多于1个。
 测试样例：

 [1,2,5,4,6],5

 返回：2


 * Created by lizhaoz on 2016/1/10.
 */

public class Gap {
    //重点在O(n)上面，桶排序思想
    public int maxGap(int[] nums,int N) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //找出最大值和最小值
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(nums[i], len, min, max); // 算出桶号
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];//找出该桶的最小值
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];//找出该桶的最大值
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = 0;
        int i = 0;
        while (i <= len) {
            if (hasNum[i++]) { // 找到第一个不空的桶
                lastMax = maxs[i - 1];
                break;
            }
        }
        for (; i <= len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);//用该桶的最小值减去上一个桶的最大值得到差值最大
                lastMax = maxs[i];
            }
        }
        return res;
    }

    // 使用long类型是为了防止相乘时溢出
    public int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }
}
