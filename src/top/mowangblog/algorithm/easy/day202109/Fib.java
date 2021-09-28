package top.mowangblog.algorithm.easy.day202109;

/**
 * Algorithm-Daily-practice
 * 509. 斐波那契数
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021-09-28 17:58
 **/
public class Fib {
    /**
     * @description: 动态规划 状态压缩 最优解
     * @author: Xuan Li
     * @date: 2021/9/28 18:27
     */
    public int dynamicFib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 2 || n == 1) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = curr + prev;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

    /**
     * @description: 动态规划   dp 数组
     * @author: Xuan Li
     * @date: 2021/9/28 18:27
     */
    public int dynamicFib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    /**
     * @description: 动态规划备忘录
     * @author: Xuan Li
     * @date: 2021/9/28 18:09
     */
//    public int dynamicFib(int n) {
//        if (n == 0) {
//            return 0;
//        }
//        int[] ints = new int[n];
//        return reFib(n, ints);
//    }
//
//    public int reFib(int n, int[] ints) {
//        if (n == 1 || n == 2) {
//            return 1;
//        }
//        if (ints[n] != 0) {
//            return ints[n];
//        }
//        ints[n] = reFib(n - 1, ints) + reFib(n - 2, ints);
//        return ints[n];
//    }

    /**
     * @description: 普通递归
     * @author: Xuan Li
     * @date: 2021/9/28 17:59
     */
//    public int fib(int n) {
//        if (n == 0) {
//            return 0;
//        }
//        return reFib(n);
//    }
//
//    public int reFib(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 1;
//        }
//        return reFib(n - 1) + reFib(n - 2);
//    }
}
