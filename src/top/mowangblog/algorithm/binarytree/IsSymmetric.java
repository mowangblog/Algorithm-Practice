package top.mowangblog.algorithm.binarytree;

/**
 * Algorithm-Practice
 *
 * @author : Xuan Li<mowangblog@qq.com>
 * @website : https://mowangblog.top
 * @date : 2022/04/11 18:07
 **/
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }
        return (t1.val == t2.val)
                && isMirror(t1.left,t2.right)
                && isMirror(t1.right,t2.left);
    }

}
