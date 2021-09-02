package top.mowangblog.algorithm.easy.day20210902;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
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
