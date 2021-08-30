package top.mowangblog.algorithm.day20210830;

import com.sun.deploy.util.StringUtils;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 *
 * 输入：x = -101
 * 输出：false
 *
 * 提示：
 *
 * Algorithm-Daily-practice
 * IsPalindrome
 *
 * @author : Xuan Li
 * @date : 2021-08-29 19:21
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        //基础解法
        if(x<0){
            return false;
        }
        String s = ""+x;
        StringBuffer stringBuffer = new StringBuffer(s);
        if (stringBuffer.reverse().toString().equals(s)){
            return true;
        }
        return false;
    }
    //进阶
//    public boolean isPalindrome(int x) {
//        if(x<0){
//            return false;
//        }
//        int a=0,b=0;
//        int c=x;
//        while(c!=0){
//            a=c%10;
//            b=b*10+a;
//            c=c/10;
//
//        }
//        return b==x;
//    }
}
