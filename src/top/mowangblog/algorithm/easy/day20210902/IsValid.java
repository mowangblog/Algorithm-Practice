package top.mowangblog.algorithm.easy.day20210902;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Algorithm-Daily-practice
 * isValid
 *
 * @author : Xuan Li
 * @date : 2021-09-02 19:07
 **/
public class IsValid {
    public boolean isValid(String s) {
        //使用栈结构解决问题
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop == '(' && c != ')') {
                    return false;
                }
                if (pop == '[' && c != ']') {
                    return false;
                }
                if (pop == '{' && c != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
