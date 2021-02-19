package binaryTree;

import java.util.ArrayList;
import java.util.List;
//二叉树的后序遍历
public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root != null){
            List<Integer> leftList = postorderTraversal(root.left);
            list.addAll(leftList);
            List<Integer> rightList = postorderTraversal(root.right);
            list.addAll(rightList);
            list.add(root.value);
        }
        return list;
    }
}
