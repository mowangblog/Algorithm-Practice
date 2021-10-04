package top.mowangblog.algorithm.easy.day202110;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 * 示例1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例2：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * 进阶：
 *
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * Algorithm-Daily-practice
 * 169. 多数元素
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/04 23:36
 **/
public class MajorityElement {
    /**
     * @description: 哈希表
     * @author: Xuan Li
     * @date: 2021/10/4 23:46
    */
    public int majorityElement(int[] nums) {
        int resultCount = nums.length / 2;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer orDefault = hashMap.getOrDefault(nums[i], 0)+1;
            hashMap.put(nums[i],orDefault);
        }
        int max = 0,result = 0;
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if(entry.getValue() < resultCount){
                continue;
            }
           max = Math.max(max,entry.getValue());
           if(entry.getValue() == max){
               result = entry.getKey();
           }
        }
        return result;
    }

    public static void main(String[] args) {
        new MajorityElement().majorityElement(new int[]{3,2,3});
    }
}
