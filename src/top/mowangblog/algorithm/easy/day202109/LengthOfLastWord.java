package top.mowangblog.algorithm.easy.day202109;

/**
 * Algorithm-Daily-practice
 * lengthOfLastWord
 *
 * @author : Xuan Li
 * @date : 2021-09-11 12:06
 **/
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        //执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
        //内存消耗：36.1 MB, 在所有 Java 提交中击败了99.46%的用户
        //偷懒方法
        s = s.trim();
        return s.substring(s.lastIndexOf(" ")+1,s.length()).length();
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello World"));
    }
}
