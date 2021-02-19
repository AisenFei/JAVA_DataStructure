package binaryTree;

//对称二叉树
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirrorTree(root.left,root.right);
    }
    //判断子树是否为镜像对称的
    public static boolean isMirrorTree(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        return left.value == right.value && isMirrorTree(left.left,right.right) && isMirrorTree(left.right,right.left);
    }
}
