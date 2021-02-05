package code_2021_0203;

import java.util.HashSet;
import java.util.Set;
//链表中环的入口结点
public class Solution2021_0205_2 {
    //HashSet
    public ListNode EntryNodeOfLoop1(ListNode pHead){
        ListNode cur = pHead;
        //创建一个set
        Set<ListNode> set = new HashSet<>();
        //遍历链表
        while(cur != null){
            //如果set中包含了该结点，说明是环入口，返回
            if(set.contains(cur)){
                return cur;
            }else{//否则的话就添加到set中
                set.add(cur);
            }
            //如果最后cur == null说明没有环
            cur = cur.next;
        }
        return null;
    }

    //快慢指针法
    public ListNode EntryNodeOfLoop2(ListNode pHead)
    {
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(fast != null){
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next.next;
            }else{
                return null;
            }
            if(slow == fast){
                fast = pHead;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
