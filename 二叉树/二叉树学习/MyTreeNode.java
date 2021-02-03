package code_2021_0203;
//二叉树的链式表示
class TreeNode{
    int value;
    TreeNode left;//结点左孩子
    TreeNode right;//结点右孩子

    public TreeNode(int value){
        this.value = value;
    }
}

public class MyTreeNode {
    public static void main(String[] args) {
        //下面用代码分别表示二叉树的五种基本形态
        //1.空树
        TreeNode root = null;//一个结点都不存在的二叉树

        //2.只有根结点的二叉树
        root = new TreeNode(1);//只有一个值为1的根结点

        //3.只有左孩子(左子树)
        root.left = new TreeNode(2);

        //4.只有右孩子
        //root.right = new TreeNode(3);

        //5.两个孩子都有，即3和4
    }
}
