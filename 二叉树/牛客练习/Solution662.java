package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

//二叉树最大宽度
public class Solution662 {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root,0,0));
        int curDp = 0,left = 0, ans = 0;
        while(!queue.isEmpty()){
            Node n = queue.remove();
            if(n.node != null){
                queue.add(new Node(n.node.left,n.dp+1,n.pos*2));
                queue.add(new Node(n.node.right,n.dp+1,n.pos*2+1));
                if(curDp != n.dp){
                    curDp = n.dp;
                    left = n.pos;
                }
                ans = Math.max(ans,n.pos - left + 1);
            }
        }
        return ans;
    }
}
class Node{
    TreeNode node;
    int dp,pos;
    public Node(TreeNode node,int dp,int pos){
        this.node = node;
        this.dp = dp;
        this.pos = pos;
    }
}
