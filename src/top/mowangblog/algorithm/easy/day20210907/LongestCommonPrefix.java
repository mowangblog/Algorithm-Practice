package top.mowangblog.algorithm.easy.day20210907;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串""。
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 提示：
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * Algorithm-Daily-practice
 * longestCommonPrefix
 *
 * @author : Xuan Li
 * @date : 2021-09-07 13:42
 **/
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            prefix = longestCommonPrefix(prefix,strs[i]);
            if(prefix.length() == 0){
                break;
            }
        }
        return prefix;

//        if (strs == null || strs.length == 0) {
//            return "";
//        }
//        StringBuilder stringBuilder = new StringBuilder();
//        String result = "";
//        Arrays.sort(strs, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.length() - o1.length();
//            }
//        });
//        String str = strs[strs.length - 1];
//        for (int i = 0; i < str.length(); i++) {
//            stringBuilder.append(str.charAt(i));
//            for (int j = 0; j < strs.length; j++) {
//                if (strs[j].indexOf(stringBuilder.toString()) != 0) {
//                    return result;
//                }
//            }
//            result = stringBuilder.toString();
//        }
//        return result;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        Long startTime = System.currentTimeMillis();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        Long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}
