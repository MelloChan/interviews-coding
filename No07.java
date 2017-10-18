package 剑指offer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。
 * 队列中的元素为int类型。
 * Created by MelloChan on 2017/10/18.
 */
public class No07 {
    public static void main(String[] args) throws Exception {
        Solution07 solution07 = new Solution07();
        solution07.push(1);
        solution07.push(2);
        solution07.push(3);
        //PSH1","PSH2","PSH3","POP","POP","PSH4","POP","PSH5","POP","POP"]
        System.out.println(solution07.pop());
        System.out.println(solution07.pop());
        solution07.push(4);
        System.out.println(solution07.pop());
        solution07.push(5);
        System.out.println(solution07.pop());
        System.out.println(solution07.pop());
    }
}

/**
 * 解决方案:由栈[先进后出] 队列[先进先出]的特性很容易编写
 * 但注意空栈情况
 */
class Solution07 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() throws Exception {
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.size() == 0) {
            throw new Exception("error!");
        }
        return stack2.pop();
    }
}
