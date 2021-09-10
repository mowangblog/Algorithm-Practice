package top.mowangblog.algorithm.easy.day202109;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * 说明：
 *
 *  输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 *  我们可以不考虑输出结果的顺序。
 *  进阶：
 *
 *  如果给定的数组已经排好序呢？你将如何优化你的算法？
 *  如果nums1的大小比nums2小很多，哪种方法更优？
 *  如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * Algorithm-Daily-practice
 * intersect
 *
 * @author : Xuan Li
 * @date : 2021-09-10 10:25
 **/
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        //排序+双指针
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int num1Len = nums1.length;
        int num2Len = nums2.length;
        int p1=0,p2=0;
        int[] ints = new int[Math.min(num1Len,num2Len)];
        int index = 0;
        while (p1 < num1Len && p2 <num2Len){
            if(nums1[p1] < nums2[p2]){
                //排完序小的这个数不可能和另一个数组任何一个数相等，所以可以直接下标后移忽略
                 p1++;
            }else if(nums1[p1] > nums2[p2]){
                //同理
                 p2++;
            }else{
                //如果相等则计入结果数组中，同时两个数组下标后移
                 ints[index++] = nums1[p1];
                 p1++;
                 p2++;
            }
        }
        //有多少返回多少
        return Arrays.copyOfRange(ints,0,index);

        //哈希表
//        if (nums1.length > nums2.length) {
//            //如果num1长度更长就换成num2，先读入更短的长度降低复杂度
//            return intersect(nums2, nums1);
//        }
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for (int i : nums1) {
//            //每添加一次value加1
//           int num = map.getOrDefault(i,0) + 1;
//           map.put(i,num);
//        }
//        int[] result = new int[nums1.length];
//        int index = 0;
//        for (int num : nums2) {
//            //看num2中有没有和num1交集，获得num1中这个数的数量
//            int count = map.getOrDefault(num, 0);
//            if (count > 0) {
//                //有则把数放入结果中并把map中数字数量-1
//                result[index++] = num;
//                count--;
//                if (count > 0) {
//                    //如果map中这个数数量还有，则把-1的之后得数重新赋值回去
//                    map.put(num, count);
//                } else {
//                    //没有了就移除
//                    map.remove(num);
//                }
//            }
//        };
//        //返回结果的数组,存入多少返回多少
//        return Arrays.copyOfRange(result,0,index);
    }
    public static void main(String[] args) {

    }
}
