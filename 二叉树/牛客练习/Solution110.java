package binaryTree;

public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int ans = leftHeight - rightHeight;
        if(!(ans == -1 || ans == 0 || ans == 1)){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int getHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(getHeight(node.left),getHeight(node.right))+1;
    }
}
