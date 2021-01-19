package code_2021_0119;

import java.util.Deque;
import java.util.LinkedList;

public class Solution20 {
    public boolean isValid(String s){
        Deque<Character> stack = new LinkedList<>();
        char[] charArray = s.toCharArray();
        for(char c : charArray){
            switch (c){
                case '{':
                case '[':
                case '(':
                    //因为没有break，所以，无论是哪个都会之下到下一行
                    stack.push(c);
                    break;
                default:{
                    //一定是右括号
                    if(stack.isEmpty()){
                        //右括号多了
                        return false;
                    }
                    //否则取出栈顶元素
                    char left = stack.pop();
                    //进行左右括号的比较
                    if(!compareBracket(left,c)){
                        //左括号和又括号不匹配
                        return false;
                    }
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            //左括号多了
            return false;
        }
    }

    private boolean compareBracket(char left,char right){
        if(left == '(' && right == ')'){
            return true;
        }
        if(left == '[' && right == ']'){
            return true;
        }
        if(left == '{' && right == '}'){
            return true;
        }

        //除了上面这三种情况以外的所有情况都是不匹配
        return false;
    }
}
