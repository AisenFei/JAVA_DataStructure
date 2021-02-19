package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLevelOrder {
    //层序遍历
    public static void levelOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            //这个node就是我们层序遍历时经过的结点
            System.out.println(node.value);
            if(node.left != null){
                //node 有左孩子
                queue.add(node.left);
            }
            if(node.right != null){
                //node 有右孩子
                queue.add(node.left);
            }
        }
    }

    //判断二叉树是否为完全二叉树
    public static boolean isCompleteTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(true){
            TreeNode node = queue.remove();
            if(node == null){
                //在遇到node == null之前，不可能出现queue.isEmpty()的情况
                break;
            }
            //不需要打印
            //直接把左右孩子拖入队列中（不管是不是null)
            queue.add(node.left);
            queue.add(node.right);
        }

        //检查队列中，是不是全部是null
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node != null){
                return false;
            }
        }
        return true;
    }
}
