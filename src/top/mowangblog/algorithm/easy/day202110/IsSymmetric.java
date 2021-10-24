package top.mowangblog.algorithm.easy.day202110;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * Algorithm-Daily-practice
 * 101. 对称二叉树
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/24 21:32
 **/
public class IsSymmetric {
    /**
     * @description: 递归实现
     * @author: Xuan Li
     * @date: 2021/10/24 21:56
    */
    public boolean isSymmetric(TreeNode root) {

        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == right) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val
                && check(left.left,right.right)
                && check(left.right,right.left);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

