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
     * @description: 动态规划，带一个记录
     * @author: Xuan Li
     * @date: 2021/9/28 18:09
    */
    public int dynamicFib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] ints = new int[n];
        return reFib(n, ints);
    }

    public int reFib(int n, int[] ints) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (ints[n] != 0) {
            return ints[n];
        }
        ints[n] = reFib(n - 1, ints) + reFib(n - 2, ints);
        return ints[n];
    }

    /**
     * @description: 普通递归
     * @author: Xuan Li
     * @date: 2021/9/28 17:59
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        return reFib(n);
    }

    public int reFib(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return reFib(n - 1) + reFib(n - 2);
    }
}
