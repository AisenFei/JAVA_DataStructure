package binaryTree;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

//构建二叉树
public class SolutionKY11 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            char[] charArr = sc.nextLine().toCharArray();
            List<Character> list = new ArrayList<>();
            for(char c : charArr){
                list.add(c);
            }
            TreeNode root = initTree(list);
            midTree(root);
        }
    }
    public static TreeNode initTree(List<Character> list){
        if(list.size() == 0)return null;
        char c = list.remove(0);
        if(c == '#'){
            return null;
        }
        TreeNode root = new TreeNode(c);
        root.left = initTree(list);
        root.right = initTree(list);
        return root;
    }
    public static void midTree(TreeNode root){
        if(root != null){
            midTree(root.left);
            System.out.print(root.value+" ");
            midTree(root.right);
        }
    }
}
