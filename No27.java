package 剑指offer;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * Created by MelloChan on 2017/11/4.
 */
public class No27 {
    public static void main(String[] args) {
        TreeNode pHead = new TreeNode(9);
        pHead.left = new TreeNode(7);
        pHead.right = new TreeNode(12);
        pHead.left.left = new TreeNode(5);
        pHead.left.right = new TreeNode(8);
        pHead.right.left = new TreeNode(10);
        pHead.right.right = new TreeNode(15);
        print(pHead);
        System.out.println();

        Solution27 solution27 = new Solution27();
        TreeNode p = solution27.convert(pHead);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.right;
        }

    }

    static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        print(root.left);
        System.out.print(root.val + " ");
        print(root.right);
    }
}

/**
 * 解决方案:中序遍历的特性 与 递归
 * root.left ->指向前一个结点 root.right ->指向后一个结点
 */
class Solution27 {
    public TreeNode convert(TreeNode pRootOfTree) {
        TreeNode pLastNodeInList = null;
        pLastNodeInList = convert(pRootOfTree, pLastNodeInList);
        while (pLastNodeInList != null && pLastNodeInList.left != null) {
            pLastNodeInList = pLastNodeInList.left;
        }//拿到的是双链表尾节点 需要得到头结点
        return pLastNodeInList;
    }

    /**
     * @param pRootOfTree 根结点
     * @param pLastNodeInList 链表尾结点
     */
    public TreeNode convert(TreeNode pRootOfTree, TreeNode pLastNodeInList) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode pCurrent = pRootOfTree;
        if (pCurrent.left != null) {
            pLastNodeInList = convert(pCurrent.left, pLastNodeInList);
        }//中序遍历 先遍历左结点
        pCurrent.left = pLastNodeInList;  //左结点指针 当前链表的尾结点
        if (pLastNodeInList != null) {
            pLastNodeInList.right = pCurrent;
        }//若尾结点不为空 将尾结点的右指针指向当前结点[当前树结点的值大于链表尾结点的值]
        pLastNodeInList = pCurrent;  //更新链表尾结点指针
        if (pCurrent.right != null) { //遍历右结点
            pLastNodeInList = convert(pCurrent.right, pLastNodeInList);
        }
        return pLastNodeInList;
    }
}
