package code_2021_0203;
//相交链表的第一个公共结点
public class Solution2021_0205_1 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        //两个链表从头到第一个公共结点的距离未知
        //分别设为a,b那么a+b=b+a;
        //所以让两个引用分别从从头到尾遍历一遍
        //最后再交换表里，则长度相同，即可找到第一个公共结点
        while(p1 != p2){
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }
}
