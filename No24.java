package 剑指offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出true,否则输出false。假设输入的数组的任意两个数字都互不相同。
 * Created by MelloChan on 2017/10/31.
 */
public class No24 {
    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        int[] arr = {1, 4, 3, 6, 9, 8, 5};
//        int[] arr = {4, 8, 6, 12};
        System.out.println(solution24.verifySquenceOfBST(arr));
    }
}

/**
 * 解决方案:递归
 * 后序遍历-> 数组末位值为根
 * 由二叉搜索树性质 -> 从左到右 第一个大于根值的索引 其左边为左子树 其右边为右子树 [若右边有值小于根,则有误,非二叉搜索树]
 * 然后由该索引 分为左右子树递归
 */
class Solution24 {
    public boolean verifySquenceOfBST(int[] sequence) {
        return verifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean verifySquenceOfBST(int[] sequence, int start, int end) {
        if (sequence == null || start > end || start < 0 || end < 0) {
            return false;
        }
        if (start == end) {
            return true;
        }
        int root = sequence[end];
        int i = start;
        for (; i < end; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        int j = i;
        for (; j < end; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        boolean left = true;
        if (i > start) {
            left = verifySquenceOfBST(sequence, start, i - 1);
        }
        boolean right = true;
        if (i < end) {
            right = verifySquenceOfBST(sequence, i, end - 1);
        }
        return left && right;
    }
}
