package top.mowangblog.algorithm.easy.day20210831;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围[−231,231− 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 * <p>
 * Algorithm-Daily-practice
 * Reverse Integer
 *
 * @author : Xuan Li
 * @date : 2021-08-31 20:14
 **/
public class Reverse {
    public int reverse(int x) {
        //字符串方式处理效率低
//        try {
//            String str = x+"";
//            if(x<0){
//                StringBuffer stringBuffer = new StringBuffer(str.substring(1));
//                String s = stringBuffer.reverse().toString();
//                s = "-" +s;
//                return Integer.parseInt(s);
//            }
//            StringBuffer stringBuffer = new StringBuffer(str);
//            String s = stringBuffer.reverse().toString();
//            return Integer.parseInt(s);
//        }catch (Exception e){
//            return 0;
//        }
        //进阶
        int result = 0;
        int num = 0;
        while (x != 0) {
            num = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            result = result * 10 + num;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Reverse().reverse(-123));
    }
}
