package 剑指offer;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入(前序遍历): 8 6 3 7 10 9 11
 * 输出(前序遍历): 8 10 11 9 6 7 3
 * Created by MelloChan on 2017/10/28.
 */
public class No19 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(6);
        root1.right = new TreeNode(10);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(7);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(11);
        print(root1);
        Solution19 solution19 = new Solution19();
        solution19.mirror(root1);
        System.out.println();
        print(root1);
    }

    /**
     * 打印二叉树(前序遍历)
     *
     * @param root
     */
    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        print(root.left);
        print(root.right);
    }
}

/**
 * 解决方案:关于二叉树的题大都可用递归来快速解决
 * 了解了镜像原理通过画图来理清变换步骤,就可知利用递归前序遍历即可解决问题.
 */
class Solution19 {
    public void mirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) {
            mirror(root.left);
        }
        if (root.right != null) {
            mirror(root.right);
        }
    }
}
