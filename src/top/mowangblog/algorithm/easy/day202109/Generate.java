package top.mowangblog.algorithm.easy.day202109;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数numRows，生成「杨辉三角」的前numRows行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 示例 1:
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例2:
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 * 提示:
 *
 * 1 <= numRows <= 30
 *
 * Algorithm-Daily-practice
 * generate
 *
 * @author : Xuan Li
 * @date : 2021-09-15 20:11
 **/
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> integers = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j == 0 || i == j){
                    integers.add(1);
                }else {
                    integers.add(lists.get(i - 1).get(j-1) + lists.get(i - 1).get(j));
                }
            }
            lists.add(integers);
        }
        return lists;
    }
}
