package top.mowangblog.algorithm.easy.day202110;

import java.util.LinkedList;
import java.util.Queue;

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
    int i = 0;
    public boolean isSymmetric2(TreeNode root) {

        return check2(root,root);
    }
    private boolean check2(TreeNode root1,TreeNode root2) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1.left);
        queue.offer(root2.right);
        while (!queue.isEmpty()){
            root1 = queue.poll();
            root2 = queue.poll();
            if(root1 == null && root2 == null){
                continue;
            }
            if((root1 == null || root2 == null) || root1.val != root2.val){
                return false;
            }
            queue.offer(root1.left);
            queue.offer(root2.right);

            queue.offer(root1.right);
            queue.offer(root2.left);
        }
        return true;
    }

    /**
     * @description: 递归实现
     * @author: Xuan Li
     * @date: 2021/10/24 21:56
    */
    public boolean isSymmetric(TreeNode root) {

        return check(root.left, root.right);
    }


    private boolean check(TreeNode left, TreeNode right) {
        System.out.println(++i);
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

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(4);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode6;
        treeNode3.left = treeNode7;
        treeNode3.right = treeNode5;

        new IsSymmetric().isSymmetric(treeNode1);
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

