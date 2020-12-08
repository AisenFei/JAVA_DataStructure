package Jian;

import java.util.Stack;

//剑指Offer09.用两个栈实现队列
public class Offer09 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public Offer09() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack1.isEmpty()){
            return -1;
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int num = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return num;
    }
}
