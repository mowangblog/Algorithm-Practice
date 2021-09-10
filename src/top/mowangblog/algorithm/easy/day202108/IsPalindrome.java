package top.mowangblog.algorithm.easy.day202108;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * 示例2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 * <p>
 * 输入：x = -101
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * Algorithm-Daily-practice
 * IsPalindrome
 *
 * @author : Xuan Li
 * @date : 2021-08-30 12:11
 */
public class IsPalindrome {
    public static void main(String[] args) {
        new IsPalindrome().isPalindrome(121);
    }

    public boolean isPalindrome(int x) {
        //进阶
        if (x < 0) {
            return false;
        }
        int result = 0;
        int num = 0;
        int original = x;
        while (x != 0) {
            num = x % 10;
            result = 10 * result + num;
            x /= 10;
        }
        return result == original;
        //基础解法
//        if(x<0){
//            return false;
//        }
//        String s = ""+x;
//        StringBuffer stringBuffer = new StringBuffer(s);
//        if (stringBuffer.reverse().toString().equals(s)){
//            return true;
//        }
//        return false;
    }
}
