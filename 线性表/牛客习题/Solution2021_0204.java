package code_2021_0203;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution2021_0204 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode prev = new ListNode(-1);
        ListNode cur = prev;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }
        if(list1 != null){
            cur.next = list1;
        }
        if(list2 != null){
            cur.next = list2;
        }
        return prev.next;
    }
}
