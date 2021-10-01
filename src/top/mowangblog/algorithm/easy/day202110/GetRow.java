package top.mowangblog.algorithm.easy.day202110;

import java.util.ArrayList;
import java.util.List;

/**
 *
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
 * 119. 杨辉三角 II
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021-10-01 23:42
 **/
@SuppressWarnings("all")
public class GetRow {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            ArrayList<Integer> integers = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j == 0 || i == j){
                    integers.add(1);
                }else {
                    integers.add(result.get(i - 1).get(j-1) + result.get(i - 1).get(j));
                }
            }
            result.add(integers);
        }
        return result.get(rowIndex);
    }

    public static void main(String[] args) {
        GetRow getRow = new GetRow();
        List<Integer> row = getRow.getRow(3);
        System.out.println(row);

    }
}
