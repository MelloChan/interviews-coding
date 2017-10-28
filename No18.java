package 剑指offer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 * {8,8,7,9,3,#,#,#,#,4,7} {8,8,7}
 * Created by MelloChan on 2017/10/27.
 */
public class No18 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode('#');
        root1.right.right = new TreeNode('#');
        root1.left.left.left = new TreeNode('#');
        root1.left.left.right = new TreeNode('#');
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);
//        TreeNode root2=new TreeNode(8);
//        root2.left=new TreeNode(9);root2.right=new TreeNode(2);  false
        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(8);
        root2.right = new TreeNode(7);  //true
        System.out.println(new Solution18().hasSubtree(root1, root2));
    }
}

/**
 * 解决方案:递归
 * 注意点:空指针
 */
class Solution18 {
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean flag = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                flag = doesTree1HasTree2(root1, root2);
            }
            if (!flag) {
                flag = hasSubtree(root1.left, root2);
            }
            if (!flag) {
                flag = hasSubtree(root1.right, root2);
            }
        }

        return flag;
    }

    public boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);
    }
}
