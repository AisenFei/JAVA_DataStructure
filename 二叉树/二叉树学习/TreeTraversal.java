package code_2021_0203;


public class TreeTraversal {
    //对root为根的树进行遍历
    //遍历的对象是树，不是结点
    //虽然形参看起来是结点，但实际上是以该结点为根的树
    public static void preTraversal(TreeNode root){
        if(root != null) {
            //1.首先处理根结点
            System.out.println(root.value);
            //2.按照前序的方式，递归处理该结点的左子树
            preTraversal(root.left);
            //3.按照前序的方式，递归处理该结点的右子树
            preTraversal(root.right);
        }else{
            System.out.println("该树为空");
        }
    }

    public static void inTraversal(TreeNode root){
        if(root != null){
            //1.中序遍历左子树
            inTraversal(root.left);
            //2.处理根
            System.out.println(root);
            //3.中序遍历右子树
            inTraversal(root.right);
        }else{
            System.out.println("该树为空");
        }
    }

    public static void postTraversal(TreeNode root){
        if(root != null){
            postTraversal(root.left);
            postTraversal(root.right);
            System.out.println(root);
        }else{
            System.out.println("该树为空");
        }
    }
}
