package top.mowangblog.algorithm.easy.day202109;

/**
 * Algorithm-Daily-practice
 * 322. 零钱兑换
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021-09-30 00:55
 **/
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] arr = new int[amount + 1];
        return dfs(coins, amount, arr);
    }

    private int dfs(int[] coins, int amount, int[] arr) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (arr[amount] != 0) {
            return arr[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dfs(coins, amount - coin, arr);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, 1 + subProblem);
            arr[amount] = res == Integer.MAX_VALUE ? -1 : res;
        }
        return arr[amount];
    }
}
