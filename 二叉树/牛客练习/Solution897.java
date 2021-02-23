package binaryTree;
//递增顺序查找树
public class Solution897 {
    public static TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inOrder(root);
        return ans.right;
    }
    public static void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        root.left = null;
        cur.right = root;
        cur = root;
        inOrder(root.right);
    }
}
