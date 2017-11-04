package 剑指offer;

/**
 * 输入一个复杂链表
 * （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * Created by MelloChan on 2017/11/2.
 */
public class No26 {
    public static void main(String[] args) {
        RandomListNode pHead = new RandomListNode('A');
        pHead.next = new RandomListNode('B');
        pHead.next.next = new RandomListNode('C');
        pHead.next.next.next = new RandomListNode('D');
        pHead.next.next.next.next = new RandomListNode('E');
        pHead.random = pHead.next.next;
        pHead.next.random = pHead.next.next.next.next;
        pHead.next.next.next.random = pHead.next;
        RandomListNode node=new Solution26().clone(pHead);
        while (node!=null){
            System.out.print(node.label+"->");
            node=node.next;
        }

    }
}

/**
 * 解决方案:拆分问题 化繁为简
 */
class Solution26 {
    public RandomListNode clone(RandomListNode pHead) {
        cloneNodes(pHead);
        connectRandomNodes(pHead);
        return reconnectNodes(pHead);
    }

    /**
     * copy原始链表并将之链接在一起
     * A->B->C->D->E  clone :  A->A1->B->B1->C->C1->D->D1->E->E1
     *
     * @param pHead
     */
    public void cloneNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode cloneNode = new RandomListNode(pNode.label);
            cloneNode.next = pNode.next;
            pNode.next = cloneNode;
            pNode = cloneNode.next;
        }
    }

    /**
     * copy原始链表组装新链表后,可知copy后的结点中随机指针指向的是被copy结点的随机指针指向的下一个结点
     * 由此拼接新链表
     *
     * @param pHead
     */
    public void connectRandomNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode cloneNode = pNode.next;
            if (pNode.random != null) {
                cloneNode.random = pNode.random.next;
            }
            pNode = cloneNode.next;
        }
    }

    /**
     * 将整个链表拆分为原始链表与复制后的链表
     * 奇输结点为原始链表结点
     * 偶数结点为copy的链表结点
     *
     * @param pHead
     * @return
     */
    public RandomListNode reconnectNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        RandomListNode cloneHead = null;
        RandomListNode cloneNode = null;
        if (pNode != null) {
            cloneHead = pNode.next;
            cloneNode = pNode.next;
            pNode.next = cloneNode.next;
            pNode = pNode.next;
        }
        while (pNode != null) {
            cloneNode.next = pNode.next;
            cloneNode = cloneNode.next;
            pNode.next = cloneNode.next;
            pNode = pNode.next;
        }
        return cloneHead;
    }
}