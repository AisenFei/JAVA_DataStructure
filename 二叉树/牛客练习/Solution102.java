package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//层序遍历，返回List<List<Integer>>
public class Solution102 {
    static class NL{
        TreeNode node;
        int level;
        NL(TreeNode node,int level){
            this.node = node;
            this.level = level;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        Queue<NL> queue = new LinkedList<>();
        queue.add(new NL(root,0));

        while(!queue.isEmpty()){
            NL nl = queue.remove();
            TreeNode node = nl.node;
            int level = nl.level;

            if(level == list.size()){
                list.add(new ArrayList<>());
            }
            List<Integer> innerList = list.get(level);
            innerList.add(node.value);

            if(node.left != null){
                queue.add(new NL(node.left,level+1));
            }
            if(node.right != null){
                queue.add(new NL(node.right,level+1));
            }
        }
        return list;
    }
}
