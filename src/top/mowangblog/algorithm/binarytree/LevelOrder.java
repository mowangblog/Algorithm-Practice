package top.mowangblog.algorithm.binarytree;

import jdk.nashorn.internal.objects.annotations.Where;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Algorithm-Practice
 *
 * @author : Xuan Li<mowangblog@qq.com>
 * @website : https://mowangblog.top
 * @date : 2022/04/08 17:44
 **/
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //边界条件判断
        if (root == null) {
            return new ArrayList<>();
        }
        //队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (queue.size() > 0){
            //BFS打印，levelNum表示的是每层的结点数
            int levelNum = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                //出队
                TreeNode node = queue.poll();
                subList.add(node.val);
                //左右子节点如果不为空就加入到队列中
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(subList);
        }
        return res;
    }
}
