package binaryTree;

public class SomeMethod {
    //求第K层节点个数
    public static int sumKlevelNodeSize(TreeNode root,int k){

        if(root == null){
            //1.root代表空树
            return 0;
        }else if(k == 1){
            //2.root 不是空树，但k == 1
            return 1;
        }else{
            //3.其他情况
            int leftSubTreeK_1 = sumKlevelNodeSize(root.left,k-1);
            int rightSubTreeK_1 = sumKlevelNodeSize(root.right,k-1);
            return leftSubTreeK_1+rightSubTreeK_1;
        }

    }

    //求二叉树的高度
    public static int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }else if(root.left == null && root.right == null){
            return 1;
        }else{
            int leftSubTreeHeight = getHeight(root.left);
            int rightSubTreeHeight = getHeight(root.right);
            return Math.max(leftSubTreeHeight,rightSubTreeHeight)+1;
        }
    }

    //查看二叉树中是否包含元素V
    public static boolean contains(TreeNode root,int v){
        if(root == null){
            return false;
        }
        if(root.value == v){
            return true;
        }
        if(contains(root.left,v)){
            return true;
        }
        return contains(root.right,v);
    }

}
