package 剑指offer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * Created by MelloChan on 2017/10/30.
 */
public class No22 {
    public static void main(String[] args) {
        int[] pushA1 = new int[]{1, 2, 3, 4, 5};
        Solution22 solution22 = new Solution22();
        int[] popA1 = new int[]{4, 5, 3, 2, 1};
        System.out.println(solution22.isPopOrder(pushA1, popA1));
        int[] popA2 = new int[]{4, 3, 5, 1, 2};
        System.out.println(solution22.isPopOrder(pushA1, popA2));
        int[] pushA2 = new int[]{1};
        int[] popA3 = new int[]{0};
        System.out.println(solution22.isPopOrder(pushA2, popA3));
        int[] pushA3 = null;
        int[] popA4 = null;
        System.out.println(solution22.isPopOrder(pushA3, popA4));
    }/* output:
    true false false false
    */
}

/**
 * 解决方案:利用一个辅助栈
 * {1,2,3,4,5}
 * {4,5,3,2,1} -> true
 * {4,3,5,1,2} -> false
 */
class Solution22 {
    public boolean isPopOrder(int[] pushA, int[] popA) {
        boolean isPopOrder = false;
        if (pushA == null || popA == null || pushA.length <= 0 || popA.length <= 0) {
            return isPopOrder;
        }
        int pushLength = pushA.length;
        int popLength = popA.length;
        int nextPush = 0;
        int nextPop = 0;
        Stack<Integer> stackData = new Stack<>();
        while (nextPop < popLength) { //压入弹出的次数与循环次数相关
            while (stackData.isEmpty() || stackData.peek() != popA[nextPop]) {//栈初始为空 || 栈顶不为弹出数组当前值
                if (nextPush >= pushLength) { // true-> 此时数组以被全部压入栈中
                    break;
                }
                stackData.push(pushA[nextPush++]); // 包括弹出数组的当前值,依次压入压入数组的值
            }
            if (stackData.peek() != popA[nextPop]) { // true -> 栈顶的值不为弹出数组当前值 不存在这样的弹出序列
                break;
            }
            stackData.pop();
            nextPop++; //更新弹出索引
        }
        if (nextPop == popLength) { //true -> 完全遍历了弹出数组
            isPopOrder = true;
        }
        return isPopOrder;
    }
}