package top.mowangblog.algorithm.easy.day202109;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Algorithm-Daily-practice
 * 94. 二叉树的中序遍历
 *
 * @author : Xuan Li
 * @date : 2021-09-23 10:20
 **/
public class InorderTraversal {
    /**
     * 解法2通过迭代
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    /**
     * 解法1递归
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> linkedList= new LinkedList<>();
        inorder(root,linkedList);
        return linkedList;
    }

    public void inorder(TreeNode root,List list){
        if(root == null){
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}

