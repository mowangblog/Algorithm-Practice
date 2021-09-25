package top.mowangblog.algorithm.easy.day202109;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * 示例 1：
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 示例 5：
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 *
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
