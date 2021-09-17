package top.mowangblog.algorithm.easy.day202109;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 *
 * 提示：
 *
 * 1 <= s.length <= 2 * 105
 * 字符串 s 由 ASCII 字符组成
 *
 * Algorithm-Daily-practice
 * isPalindrome
 *
 * @author : Xuan Li
 * @date : 2021-09-17 14:21
 **/
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        //双指针
        int p1 = 0;
        int p2 = s.length() - 1;
        while(p1 < p2){
            if(!Character.isLetterOrDigit(s.charAt(p1))){
                p1++;
            }else if(!Character.isLetterOrDigit(s.charAt(p2))){
                p2--;
            }else if(Character.toLowerCase(s.charAt(p1)) == Character.toLowerCase(s.charAt(p2))){
                p1++;
                p2--;
            }else{
                return false;
            }
        }
        return true;
        //翻转判断
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if (Character.isLetterOrDigit(s.charAt(i))) {
//                stringBuilder.append(s.charAt(i));
//            }
//        }
//        String s1 = stringBuilder.toString().toLowerCase();
//        String s2 = stringBuilder.reverse().toString().toLowerCase();
//        return s1.equals(s2);
    }


    public static void main(String[] args) {
        new IsPalindrome().isPalindrome("A man, a plan, a canal: Panama");
    }
}
