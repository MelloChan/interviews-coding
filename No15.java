package 剑指offer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * Created by MelloChan on 2017/10/25.
 */
public class No15 {
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
        Solution15 solution15=new Solution15();
        System.out.println(solution15.findKthToTail(head, 3).val);
        System.out.println(solution15.findKthToTail(null,3));
        System.out.println(solution15.findKthToTail(head,0));
        System.out.println(solution15.findKthToTail(head,7));
    }
}

/**
 * 解决方案:一种是先遍历记录节点数,第二次遍历得到目标节点(倒数第k个,则前数为第 n-k+1个,n为节点数),但这需要遍历两次
 * 而使用双指针则一次遍历即可,首指针先走k-1步,然后两个指针同时遍历链表,直到首指针指向尾部
 * 注:需要注意头指针为空以及k<=0的情况,以及输入的k值与链表的总节点值不符的情况[防备空指针]
 */
class Solution15 {
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode first = head, second = head;
        for (int i = 0; i < k - 1; i++) {
            if (first.next != null) {
                first = first.next;
            } else {
                return null;
            }
        }
        while (first.next != null) {
            second = second.next;
            first = first.next;
        }
        return second;
    }
}
