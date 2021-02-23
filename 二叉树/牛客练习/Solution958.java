package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
//二叉树的完全检验
public class Solution958 {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node != null){
                queue.add(node.left);
                queue.add(node.right);
            }else{
                flag = true;
                break;
            }
        }
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node != null){
                return false;
            }
        }
        return true;
    }
}
