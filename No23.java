package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 层序遍历
 * Created by MelloChan on 2017/10/31.
 */
public class No23 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);root.right.right=new TreeNode(7);
        Solution23 solution23=new Solution23();
        System.out.println(solution23.printFromTopToBottom(root));
    }
}

/**
 * 解决思路:利用队列先进先出的特性
 * 层序遍历特点在于 自上而下 自左到右
 * 将根结点放入队列,pNode等于当前队头元素
 * 将不为空的左右结点依次放入队列
 * 重复
 */
class Solution23 {
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) {
            return arrayList;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (queue.size()>0){
            TreeNode pNode=queue.poll();
            arrayList.add(pNode.val);
            if(pNode.left!=null){
                queue.add(pNode.left);
            }
            if(pNode.right!=null){
                queue.add(pNode.right);
            }
        }
        return arrayList;
    }

}
