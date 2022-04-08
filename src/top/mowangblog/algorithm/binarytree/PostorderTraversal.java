package top.mowangblog.algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Algorithm-Practice
 *
 * @author : Xuan Li<mowangblog@qq.com>
 * @website : https://mowangblog.top
 * @date : 2022/04/08 17:33
 **/
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> arrayList = new ArrayList<>();
        preOrder(root,arrayList);
        return arrayList;
    }

    public void preOrder(TreeNode tree,List<Integer> arrayList) {
        if(tree == null){
            return;
        }
        preOrder(tree.left,arrayList);
        preOrder(tree.right,arrayList);
        arrayList.add(tree.val);
    }
}
