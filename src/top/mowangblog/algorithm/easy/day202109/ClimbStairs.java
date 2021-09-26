package top.mowangblog.algorithm.easy.day202109;

/**
 * Algorithm-Daily-practice
 * 70. 爬楼梯
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021-09-26 11:29
 **/
public class ClimbStairs {
    /**
     * @description: 递归方法，会超时
     * @author: Xuan Li
     * @date: 2021/9/26 16:33
    */
    public int climbStairs(int n) {
        return climb(n);
    }
    public int climb(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return climb(n-1)+climb(n-2);
    }
}
