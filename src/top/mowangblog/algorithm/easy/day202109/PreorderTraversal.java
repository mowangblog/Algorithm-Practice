package top.mowangblog.algorithm.easy.day202109;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Algorithm-Daily-practice
 * 144. 二叉树的前序遍历
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021-09-25 20:09
 **/
public class PreorderTraversal {
    /**
     * @description: 迭代
     * @author: Xuan Li
     * @date: 2021/9/25 20:12
    */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        while (root != null || !treeNodes.isEmpty()){
            while (root != null){
                list.add(root.val);
                treeNodes.add(root);
                root = root.left;
            }
            root = treeNodes.removeLast();
            root = root.right;
        }
        return list;
    }

    /**
     * @description: 递归
     * @author: Xuan Li
     * @date: 2021/9/25 20:12
    */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root,list);
        return list;
    }

    public void preorder(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        preorder(root.left,list);
        preorder(root.right,list);
    }
}
