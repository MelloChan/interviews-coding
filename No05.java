package 剑指offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * Created by MelloChan on 2017/10/17.
 */
public class No05 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(12);
        ListNode l3 = new ListNode(31);
        ListNode l4 = new ListNode(21);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        System.out.println(new Solution05().printListFromTailToHead(l1));
    }
}

/**
 * 解决思路:利用栈[先进后出]
 */
class Solution05 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            arrayList.add(stack.pop().val);
        }
        return arrayList;
    }
}
