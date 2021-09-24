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
     * 解法2迭代
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        //使用Linkedlist模拟栈
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                //添加当前节点的左子节点包括当前节点
                stack.add(root);
                root = root.left;
            }
            //根据先进后出的特性，现在出栈的是最左的节点
            root = stack.removeLast();
            //添加到结果中
            result.add(root.val);
            //然后遍历出栈节点的右子节点，同样会先入栈所有的左子节点
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
        //优先遍历左子节点
        inorder(root.left,list);
        //添加当前节点的值
        list.add(root.val);
        //遍历右子节点
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

