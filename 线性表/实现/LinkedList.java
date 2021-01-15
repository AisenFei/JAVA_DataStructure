package code_2021_0113;

public class LinkedList {
    public Node head;//头结点
    public Node last;//尾结点
    public int size;

    //O(1)
    public boolean add(Integer e){
        //判断链表中没有节点，哪种判断都可以，等价的
        //if(size == 0)
        //if(head == null)
        //if(last == null)

        Node newNode = new Node(e);
        if(size == 0){
            this.head = this.last = newNode;
        }else{
            this.last.next = newNode;
            newNode.prev = this.last;
            this.last = newNode;
        }
        this.size++;
        return true;
    }

    //O(n)
    public void add(int index,Integer e){
        if(index < 0||index > size){
            throw new IndexOutOfBoundsException("下标越界："+index);
        }
        if(index == size){
            //尾插
            add(e);
        }else if(index == 0) {
            //头插
            Node newNode = new Node(e);//
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
            size++;
        }else{
            //其他情况
            //找到index-1所在的位置，进行结点的插入
            Node prev;
            if(index - 1 < size/2){
                prev = head;
                //从head处出发，找到index-1位置的结点
                for(int i = 0;i < index - 1;i++){
                    prev = prev.next;
                }
            }else{
                //从last处出发，找到index - 1位置的结点
                prev = last;
                for(int i = 0;i < size - index;i++){
                    prev = prev.prev;
                }
            }
            //prev指向index - 1位置的下标
            Node next = prev.next;
            Node newNode = new Node(e);

            newNode.prev = prev;
            newNode.next = next;
            prev.next = newNode;
            next.prev = newNode;

            size++;
        }
    }

    //O(n)
    public Integer remove(int index){
        if(index < 0||index >= size){
            throw new IndexOutOfBoundsException("下标越界："+index);
        }
        Integer v;
        if(index == 0){
            v = head.element;
            this.head = this.head.next;
            this.head.prev = null;
            size--;
            if(size == 0){
                last = null;
            }
        }else if(index == size - 1){
            v = last.element;
            this.last = this.last.prev;
            this.last.next = null;
            size--;
            if(size == 0){
                head = null;
            }
        }else{
            //找到index - 1所在的位置
            Node prev;
            if(index - 1 < size / 2){
                prev = head;
                for(int i = 0;i < index - 1;i++){
                    prev = prev.next;
                }
            }else{
                prev = last;
                for(int i = 0;i < size - index;i++){
                    prev = prev.prev;
                }
            }

            Node toRemove = prev.next;
            v = toRemove.element;
            prev.next = toRemove.next;
            toRemove.next.prev = prev;
            size--;
        }
        return v;
    }

    //O(n)
    public boolean remove(Integer e){
        Node prev = null;
        for(Node cur = head;cur !=null;prev = cur,cur = cur.next){
            if(cur.element.equals(e)){
                if(prev == null){
                    remove(0);
                    return true;
                }
            }else{
                prev.next.next.prev = prev;
                prev.next = prev.next.next;
                size--;
                return true;
            }
        }
        return false;
    }

    //O(n)
    public Integer get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("下标越界："+index);
        }
        Node cur = head;
        for(int i = 0;i < index;i++){
            cur = cur.next;
        }
        return cur.element;
    }

    //O(n)
    public Integer set(int index,Integer e){
        if(index < 0||index >= size){
            throw new IndexOutOfBoundsException("下标越界："+index);
        }

        Node cur = head;
        for(int i = 0;i < index;i++){
            cur = cur.next;
        }
        Integer v = cur.element;
        cur.element = e;
        return v;
    }

    //O(1)
    public int size(){
        return size;
    }

    //o(1)
    public void clear(){
        head = null;
        last = null;
        size = 0;
    }

    // O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    // O(n)
    public boolean contains(Integer e) {
        return indexOf(e) != -1;
    }

    // O(n)
    public int indexOf(Integer e) {
        int i = 0;
        for (Node cur = head; cur != null; cur = cur.next, i++) {
            if (cur.element.equals(e)) {
                return i;
            }
        }

        return -1;
    }

    // O(n)
    public int lastIndexOf(Integer e) {
        int i = size - 1;
        for (Node cur = last; cur != null; cur = cur.prev, i--) {
            if (cur.element.equals(e)) {
                return i;
            }
        }

        return -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.element);
            if (cur != last) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
