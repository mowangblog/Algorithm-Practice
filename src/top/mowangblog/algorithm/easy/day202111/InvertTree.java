package top.mowangblog.algorithm.easy.day202111;

/**
 * Algorithm-Daily-practice
 *
 * @author : Xuan Li<mowangblog@qq.com>
 * @website : https://mowangblog.top
 * @date : 2021/11/22 23:32
 **/
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode treeLeft = invertTree(root.left);
        TreeNode treeRight = invertTree(root.right);
        root.left = treeRight;
        root.right = treeLeft;
        return root;
    }
}
