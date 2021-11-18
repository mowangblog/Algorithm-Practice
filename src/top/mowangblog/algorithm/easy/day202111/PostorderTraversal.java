package top.mowangblog.algorithm.easy.day202111;

import java.util.ArrayList;
import java.util.List;

/**
 * Algorithm-Daily-practice
 *
 * @author : Xuan Li<mowangblog@qq.com>
 * @website : https://mowangblog.top
 * @date : 2021/11/18 23:15
 **/
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> arrayList = new ArrayList<>();
        postorder(root,arrayList);
        return arrayList;
    }

    public void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postorder(root.left,list);
        postorder(root.right,list);
        list.add(root.val);
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