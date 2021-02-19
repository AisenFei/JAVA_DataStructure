package binaryTree;

import java.util.ArrayList;
import java.util.List;

//二叉树的前序遍历
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root != null){
            list.add(root.value);
            List<Integer> leftList = preorderTraversal(root.left);
            list.addAll(leftList);
            List<Integer> rightList = preorderTraversal(root.right);
            list.addAll(rightList);
        }
        return list;
    }
}
