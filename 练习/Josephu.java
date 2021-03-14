package code_2021_0314;

class Node{
    int num;
    Node next;
    Node(int num){
        this.num = num;
    }
}

class CircleSingleLinkedList{
    //创建一个first节点
    Node head;
    Node tail;
    //添加节点
    public void addNode(int num){
        if(head == null){
            head = new Node(num);
            tail = head;
            tail.next = head;
        }else{
            Node node = new Node(num);
            tail.next = node;
            tail = node;
            node.next = head;
        }
    }

    //遍历当前环形链表
    public void showNode(){
        //判断链表是否为空
        if(head == null){
            System.out.println("链表为空");
            return;
        }
        Node cur = head;
        while(true){
            System.out.println(cur.num);
            if(cur.next ==  head){
                break;
            }
            cur = cur.next;
        }
    }
}
public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList c = new CircleSingleLinkedList();
        c.addNode(1);
        c.addNode(2);
        c.addNode(3);
        c.addNode(4);
        c.addNode(5);
        c.showNode();
    }
}
