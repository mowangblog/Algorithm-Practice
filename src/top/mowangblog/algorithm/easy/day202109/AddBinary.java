package top.mowangblog.algorithm.easy.day202109;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字1和0。
 *
 * 示例1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * Algorithm-Daily-practice
 * 67. 二进制求和
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021-09-26 11:40
 **/
public class AddBinary implements Serializable {

    /**
     * @description: 不讲码德，使用内置api
     * @author: Xuan Li
     * @date: 2021/9/26 11:49
    */
    public String addBinary(String a, String b) {
        return new BigInteger(a,2).add(new BigInteger(b,2)).toString(2);
    }
}
