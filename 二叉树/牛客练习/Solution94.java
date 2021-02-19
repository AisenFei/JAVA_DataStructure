package binaryTree;

import java.util.ArrayList;
import java.util.List;

//中序遍历
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root != null){
            List<Integer> leftList = inorderTraversal(root.left);
            list.addAll(leftList);
            list.add(root.value);
            List<Integer> rightList = inorderTraversal(root.right);
            list.addAll(rightList);
        }
        return list;
    }
}
