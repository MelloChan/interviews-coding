package 剑指offer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 * Created by MelloChan on 2017/10/25.
 */
public class No17 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(8);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(6);
        ListNode l8 = new ListNode(7);
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;

        ListNode node = new Solution17().merge(l1, l5);
        while (node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
    }
}

/**
 * 解决思路:递归.
 * 1->3->5->8  2->4->6->7
 * 代码很简单,但要注意空链表情况
 */
class Solution17 {
    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode mergeList = null;
        if (list1.val < list2.val) {
            mergeList = list1;
            mergeList.next = merge(list1.next, list2);
        } else {
            mergeList = list2;
            mergeList.next = merge(list1, list2.next);
        }
        return mergeList;
    }
}
