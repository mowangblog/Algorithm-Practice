package top.mowangblog.algorithm.easy.day202109;

/**
 * Algorithm-Daily-practice
 * 100. 相同的树
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021-09-24 22:52
 **/
public class IsSameTree {
    //深搜
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
