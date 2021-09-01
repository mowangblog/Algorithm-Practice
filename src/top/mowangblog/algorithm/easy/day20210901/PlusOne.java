package top.mowangblog.algorithm.easy.day20210901;

import sun.rmi.runtime.Log;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *
 * 提示：
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * Algorithm-Daily-practice
 * plusOne
 *
 * @author : Xuan Li
 * @date : 2021-09-01 10:43
 **/
public class PlusOne {
    public int[] plusOne(int[] digits) {
        //简洁代码
        int len = digits.length - 1;
        for (int i = len; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[len + 2];
        result[0] = 1;
        return result;
//        2
//        int len = digits.length;
//        if (digits[len - 1] < 9) {
//            digits[len - 1] += 1;
//            return digits;
//        }
//        digits[len - 1] += 1;
//        for (int i = 0; i < len; i++) {
//            if (len - i - 1 != 0 && digits[len - i - 1]  > 9) {
//                digits[len - i - 1] = 0;
//                digits[len - i - 2] += 1;
//            }
//        }
//        if (digits[0] == 10) {
//            int[] result = new int[len + 1];
//            result[0] = 1;
//            return result;
//        }
//        return digits;
    }

    public static void main(String[] args) {
        new PlusOne().plusOne(new int[]{9});
    }
}
