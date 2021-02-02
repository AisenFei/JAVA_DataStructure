package code_2021_0127;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayList;
class ListNode{
    int val;
    ListNode next = null;
    ListNode(int val){
        this.val = val;
    }
}
//从尾到头打印链表
public class Solution2021_0202_1 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Deque<Integer> stack = new LinkedList<>();
        while(listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}