package top.mowangblog.algorithm.binarytree;

/**
 * Algorithm-Practice
 *
 * @author : Xuan Li<mowangblog@qq.com>
 * @website : https://mowangblog.top
 * @date : 2022/04/14 20:42
 **/
public class BuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len=inorder.length;
        if(len==0)return null;
        return dfs(inorder,postorder,0,len-1,0,len-1);
    }

    TreeNode dfs(int[] inorder, int[] postorder,int head1,int tail1, int head2,int tail2){
        if(head2>tail2)return null;

        int val=postorder[tail2];
        TreeNode root=new TreeNode(val);
        if(head2==tail2)return root;

        int mid=0;  //拆分点mid的位置是相对的，因为h1!=h2
        while(inorder[head1+mid]!=val)mid++;

        root.left=dfs(inorder, postorder, head1, head1+mid-1, head2, head2+mid-1);
        root.right=dfs(inorder, postorder, head1+mid+1, tail1, head2+mid, tail2-1);

        return root;
    }
}
