package Jian;

import java.util.Stack;

/**
 * 剑指Offer06.从尾到头打印链表
 */
public class Offer06 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        int size = stack.size();
        int[] array = new int[size];
        for(int i = 0;i < size;i++){
            array[i] = stack.pop().val;
        }
        return array;
    }
}
