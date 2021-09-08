package top.mowangblog.algorithm.easy.day20210908;

import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * Algorithm-Daily-practice
 * containsDuplicate
 *
 * @author : Xuan Li
 * @date : 2021-09-08 13:26
 **/
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        //第一种 排序之后比较
        if(nums.length<2){
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
        //第二种 哈希
//        HashSet hashSet = new HashSet();
//        int length = nums.length;
//        for (int i = 0; i < length; i++) {
//            if(!hashSet.add(nums[i])){
//                return true;
//            }
//        }
//        return false;
    }
}
