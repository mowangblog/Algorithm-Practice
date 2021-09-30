package top.mowangblog.algorithm.easy.day202109;

import java.util.Arrays;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * Algorithm-Daily-practice
 * 349. 两个数组的交集
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021-09-30 23:38
 **/
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0, p2 = 0,k = 0;
        int[] result = new int[Math.min(nums1.length,nums2.length)];
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            }else if(nums1[p1] > nums2[p2]){
                p2++;
            }else{
                if(result[Math.max(k - 1, 0)] != nums1[p1] || k==0){
                    result[k++] = nums1[p1];
                }
                p1++;
                p2++;
            }
        }
        return Arrays.copyOfRange(result,0,k);
    }

    public static void main(String[] args) {
        new Intersection().intersection(new int[]{8,0,3},new int[]{0,0});
    }
}
