package 剑指offer;

/**
 * 反转链表,并输出反转后的链表尾节点
 * Created by MelloChan on 2017/10/25.
 */
public class No16 {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(12);
        ListNode l3 = new ListNode(31);
        ListNode l4 = new ListNode(21);
        ListNode l5 = new ListNode(55);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Solution16 solution16=new Solution16();
        System.out.println(solution16.reverseList(head).val);
    }
}

/**
 * 解决方案:需要保存的有当前链表节点,链表前一个节点以及返回的链表尾节点
 */
class Solution16 {
    ListNode reverseList(ListNode head) {
        ListNode reverseNode = null,
                node = head, prev = null;
        while (node != null) {
            ListNode next = node.next;
            if (next == null) {
                reverseNode = node; //当前节点的下一个节点为null,则已经遍历到了尾部,保存尾部节点
            }
            node.next=prev;  //反转 将当前节点的指针指向前一个节点
            prev = node;    //重置前一个节点
            node = next;    //重置当前节点
        }
        return reverseNode;
    }
}