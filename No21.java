package 剑指offer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * Created by MelloChan on 2017/10/29.
 */
public class No21 {
    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        solution21.push(3);
        System.out.print(solution21.min());
        solution21.push(4);
        System.out.print(solution21.min());
        solution21.push(2);
        System.out.print(solution21.min());
        solution21.push(3);
        System.out.print(solution21.min());
        solution21.pop();
        System.out.print(solution21.min());
        solution21.pop();
        System.out.print(solution21.min());
    }/*
        {push 3 , min , push 4 , min , push 2 , min , push 3 , min , pop , min , pop , min  }
         -> 3 3 2 2 2 3
     */
}

/**
 * 解决思路:另外使用一个辅助栈
 */
class Solution21 {
    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int node) {
        data.push(node);
        if (min.size() == 0 || node < min.peek()) {
            min.push(node);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}
