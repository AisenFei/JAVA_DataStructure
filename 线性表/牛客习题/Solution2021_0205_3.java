package code_2021_0203;
//删除链表中重复结点
public class Solution2021_0205_3 {
    public ListNode deleteDuplication(ListNode pHead)
    {
        //标记头结点，伪头结点
        ListNode newHead = new ListNode(-1);
        //标记前结点，真实节点
        ListNode prev = newHead;
        //遍历结点，判断是否重复
        ListNode cur = pHead;
        //遍历链表
        while(cur != null){
            //如果碰到当前结点和下一个结点的值相同，则进入内部循环，继续向后遍历
            if(cur.next != null && cur.next.val == cur.val){
                while(cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                //注意：最后遍历完肯定还会存在一个重复并为删除结点，所以还需要再往后
                cur = cur.next;
            }else{
                prev.next = cur;
                prev = cur;
                cur = cur.next;
            }
        }
        prev.next = null;
        return newHead.next;
    }
}
