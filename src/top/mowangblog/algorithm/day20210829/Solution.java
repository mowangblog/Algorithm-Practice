package top.mowangblog.algorithm.day20210829;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        //最简单的方法循环遍历复杂度较高
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }
    //实际提交时不用main方法，用来测试
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums= new int[]{2, 7, 11, 15};
        for (int i : solution.twoSum(nums, 9)) {
            System.out.println(i);
        }
    }

    //进阶解法哈希表
    /*class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<nums.length;i++){
                if(map.containsKey(target-nums[i])){
                    return new int[]{i,map.get(target-nums[i])};
                }else{
                    map.put(nums[i],i);
                }
            }
            return null;
        }
    }*/
}
