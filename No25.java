package 剑指offer;

import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * Created by MelloChan on 2017/11/1.
 */
public class No25 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(3);root.right=new TreeNode(4);
        root.left.left=new TreeNode(5);root.left.right=new TreeNode(6);
        root.right.left=new TreeNode(7);root.right.right=new TreeNode(8);
        Solution25 solution25=new Solution25();
        System.out.println(solution25.findPath(root,10));
    }
}

/**
 * 解决方案:递归
 */
class Solution25 {
    private ArrayList<ArrayList<Integer>> allPath = new ArrayList<>();
    private ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null) {
            return allPath;
        }
        path.add(root.val);
        target -= root.val;
        boolean flag = (root.left == null && root.right == null);
        if (target == 0 && flag) {
            allPath.add(new ArrayList<>(path));
        }
        findPath(root.left,target);
        findPath(root.right,target);
        path.remove(path.size()-1);
        return allPath;
    }
}