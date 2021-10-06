package top.mowangblog.algorithm.easy.day202110;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串t由字符串s随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 * <p>
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 * <p>
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 * <p>
 * Algorithm-Daily-practice
 * 389. 找不同
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/06 23:46
 **/
public class FindTheDifference {
    /**
     * @description: 使用排序
     * @author: Xuan Li
     * @date: 2021/10/6 23:51
     */
    public char findTheDifference(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        for (int i = 0; i < chart.length; i++) {
            if (i == chars.length || chars[i] != chart[i]) {
                return chart[i];
            }
        }
        return chars[0];
    }

    /**
     * @description: 求和
     * @author: Xuan Li
     * @date: 2021/10/6 23:55
     */
    public char findTheDifference2(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); i++) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }

    /**
     * @description: 位运算
     * @author: Xuan Li
     * @date: 2021/10/6 23:59
     */
    public char findTheDifference3(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            ret ^= t.charAt(i);
        }
        return ((char) ret);
    }
}
