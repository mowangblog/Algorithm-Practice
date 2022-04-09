package top.mowangblog.algorithm.binarytree;

/**
 * Algorithm-Practice
 *
 * @author : Xuan Li<mowangblog@qq.com>
 * @website : https://mowangblog.top
 * @date : 2022/04/09 15:36
 **/
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        return Math.max(maxDepth(left),maxDepth(right))+1;
    }
}
