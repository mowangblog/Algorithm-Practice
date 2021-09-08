package top.mowangblog.algorithm.easy.day20210908;

/**
 * Algorithm-Daily-practice
 * maxSubArray
 *
 * @author : Xuan Li
 * @date : 2021-09-08 13:40
 **/
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        //动态规划
        int pre = 0,maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            //如果加上前面的数反而更小，那就应该抛弃之前的数
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
        //第二种
//        int res = nums[0];
//        int sum = 0;
//        for (int num : nums) {
//            if (sum > 0)
//                sum += num;
//            else
//                sum = num;
//            res = Math.max(res, sum);
//        }
//        return res;
        //第三种
//        int length = nums.length;
//        if (length == 1) {
//            return nums[0];
//        }
//        int max = -10000;
//        int cont = 0;
//        for (int i = 0; i < length; i++) {
//            cont += nums[i];
//            max = Math.max(cont, max);
//            if (cont < 0) {
//                cont = 0;
//            }
//        }
//        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2, 1,1}));
    }
}
