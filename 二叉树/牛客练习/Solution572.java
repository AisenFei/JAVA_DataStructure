package binaryTree;

//一棵树是否包含另一颗树
public class Solution572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return search(s,t);
    }

    //查找树中包含的根结点位置，并进行对比
    public static boolean search(TreeNode root,TreeNode t){
        if(root == null){
            return false;
        }
        if(root.value == t.value){
            if(isSameTree(root,t)){
                return true;
            }
        }
        if(search(root.left,t)){
            return true;
        }
        return search(root.right,t);
    }

    //对比俩颗子树是否相同
    public static boolean isSameTree(TreeNode q,TreeNode p){
        if(q == null && p == null){
            return true;
        }
        if(q == null || p == null){
            return false;
        }
        return q.value == p.value && isSameTree(q.left,p.left) && isSameTree(q.right,p.right);
    }
}
