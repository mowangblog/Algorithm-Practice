package top.mowangblog.algorithm.easy.day202110;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串t由字符串s随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 *
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 *
 * 提示：
 *
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 *
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
            if(i==chars.length || chars[i] != chart[i] ){
                return chart[i];
            }
        }
        return chars[0];
    }
}
