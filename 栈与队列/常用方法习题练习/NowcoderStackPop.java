package code_2021_0119;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//栈的压入、弹出序列
public class NowcoderStackPop {
    private Queue<Integer> intArrayToQueue(int[] array){
        Queue<Integer> queue = new LinkedList<>();

        for(int n : array){
            queue.add(n);
        }
        return queue;
    }
    public boolean IsPopOrder(int[] pushA,int[] popA){
        Queue<Integer> pushQueue = intArrayToQueue(pushA);
        Queue<Integer> popQueue = intArrayToQueue(popA);
        //实现准备的栈
        Deque<Integer> stack = new LinkedList<>();
        while(!popQueue.isEmpty()){
            int p = popQueue.remove();
            while(true){
                if(stack.isEmpty() || stack.peek() != p){
                    if(pushQueue.isEmpty()){
                        return false;
                    }

                    int q = pushQueue.remove();
                    stack.push(q);
                }else{
                    break;
                }
            }
            stack.pop();
        }
        return stack.isEmpty();
    }
}
