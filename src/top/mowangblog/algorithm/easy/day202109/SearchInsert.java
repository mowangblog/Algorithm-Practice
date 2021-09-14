package top.mowangblog.algorithm.easy.day202109;

import java.util.Arrays;

/**
 * Algorithm-Daily-practice
 * searchInsert
 *
 * @author : Xuan Li
 * @date : 2021-09-14 09:10
 **/
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {

        //直接遍历
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }
}
