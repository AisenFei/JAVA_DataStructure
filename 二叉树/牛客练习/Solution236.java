package binaryTree;

//二叉树最近公祖先
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p == root || q == root) return root;
        boolean pInLeft = search(root.left,p);
        boolean qInLeft = search(root.left,q);
        if(pInLeft && qInLeft){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(!pInLeft && !qInLeft){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
    public static boolean search(TreeNode root,TreeNode node){
        if(root == null) return false;
        if(root.value == node.value) return true;
        if(search(root.left,node)){
            return true;
        }
        return search(root.right,node);
    }
}
