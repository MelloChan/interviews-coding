package 剑指offer;

/**
 * O(1)时间删除链表结点
 * 给点单向链表的头指针和一个结点指针,定义一个方法在O(1)时间
 * 删除该节点
 * Created by MelloChan on 2017/10/22.
 */
public class No13 {
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

        Solution13 solution13 = new Solution13();
        solution13.deleteNode(null, l1);
        solution13.deleteNode(head, null);
        System.out.println(l1 + ":" + l1.val);
        solution13.deleteNode(head, l1);
        System.out.println(l5 + ":" + l5.val);
        solution13.deleteNode(head, l5);
    }
}

/**
 * 解决方案:正常O(n)时间复杂度是通过遍历找到要删除结点的上一个结点,然后将该结点指针指向删除结点指向的下一个结点
 * 优化方案:采用覆盖的方式.只需将删除结点的下一个结点的值与指针覆盖到要删除的结点即可,时间复杂度降为O(1)
 * 备注:O(1)的限制,无法确保指定删除的结点确实存在,这点需要调用者保证
 */
class Solution13 {
    public void deleteNode(ListNode pListHead, ListNode pToBeDeleted) {
        if (pListHead == null || pToBeDeleted == null) {
            System.out.println("头结点为null || 待删除结点为空");
            return;
        }
        if (pToBeDeleted.next != null) {
            ListNode pNext = pToBeDeleted.next;
            pToBeDeleted.val = pNext.val;
            pToBeDeleted.next = pNext.next;
            System.out.println(pToBeDeleted + ":" + pToBeDeleted.val);
            pNext = null;
        } else if (pListHead.next == pToBeDeleted) {
            System.out.println(pToBeDeleted + ":" + pToBeDeleted.val);
            pListHead.next = null;
            pToBeDeleted = null;
        } else {
            ListNode pNode = pListHead;
            while (pNode.next != pToBeDeleted) {
                pNode = pNode.next;
            }
            pNode.next = null;
            pToBeDeleted = null;
            System.out.println(pToBeDeleted + ":");
        }
    }
}
