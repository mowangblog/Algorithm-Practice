package top.mowangblog.algorithm.easy.day202110;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入：[3,2,3]
 * 输出：3
 * 示例2：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * 进阶：
 * <p>
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * <p>
 * Algorithm-Daily-practice
 * 169. 多数元素
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/04 23:36
 **/
@SuppressWarnings("all")
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
            Integer orDefault = hashMap.getOrDefault(nums[i], 0) + 1;
            hashMap.put(nums[i], orDefault);
        }
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }

    /**
     * @description: 排序 如果将数组 nums 中的所有元素按照单调递增或单调递减的顺序排序，
     * 那么下标为 n/2的元素（下标从 0 开始）一定是众数。
     * @author: Xuan Li
     * @date: 2021/10/5 0:07
    */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * @description: Boyer-Moore 投票算法
     * @author: Xuan Li
     * @date: 2021/10/5 0:08
    */
    public int majorityElement3(int[] nums) {
        int count = 0;
        int result = 0;
        for (int num : nums) {
            if(count == 0){
                result = num;
            }
            count += (num == result)?1:-1;
        }
        return result;
    }

    public static void main(String[] args) {
        new MajorityElement().majorityElement2(new int[]{3, 3, 4});
    }
}
