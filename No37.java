package 剑指offer;


/**
 * 输入两个链表，找出它们的第一个公共结点。
 * Created by MelloChan on 2017/11/27.
 */
public class No37 {
    public static void main(String[] args) {
        ListNode p1=new ListNode(1);
        ListNode p2=new ListNode(2);
        ListNode p3=new ListNode(10);
        p1.next=new ListNode(4);p1.next.next=new ListNode(6);p1.next.next.next=p3;
        p2.next=new ListNode(5);p2.next.next=new ListNode(7);p2.next.next.next=new ListNode(8);
        p2.next.next.next.next=p3;
        p3.next=new ListNode(9);
        p3.next.next=new ListNode(10);

        Solution37 solution37=new Solution37();
        System.out.println(solution37.findFirstCommonNode(p1,p2).val);
    }
}

/**
 * 解决方案:先后获取两个链表的长度,让较长链表先遍历到与较短链表相同的起点
 * 之后遍历找出相同结点
 * 时间复杂度 O(m+n)
 *
 */
class Solution37 {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        int p1 = getListNodeLength(pHead1);
        int p2 = getListNodeLength(pHead2);
        int p3 = p1 - p2;
        ListNode pNodeLong = pHead1;
        ListNode pNodeShort = pHead2;
        if (p2 > p1) {
            pNodeLong = pHead2;
            pNodeShort = pHead1;
            p3 = p2 - p1;
        }
        for (int i = 0; i < p3; i++) {
            pNodeLong = pNodeLong.next;
        }
        while (pNodeLong != null && pNodeShort != null && pNodeLong != pNodeShort) {
            pNodeShort = pNodeShort.next;
            pNodeLong = pNodeLong.next;
        }
        return pNodeShort;
    }

    private int getListNodeLength(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            ++length;
        }
        return length;
    }
}
