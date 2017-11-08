package 剑指offer;

/**
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * (子向量的长度至少是1)
 * Created by MelloChan on 2017/11/7.
 */
public class No31 {
    public static void main(String[] args) {
        int[] array = {6, -3, -2, 7, -15, 1, 2, 2};
        Solution31 solution31 = new Solution31();
        System.out.println(solution31.findGreatestSumOfSubArray(array));
    }
}

/**
 * 解决方案:累加值
 * curSum记录累加值,greatestSum记录最优值[最大]
 */
class Solution31 {
    public int findGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int curSum = 0;
        int greatestSum = 0x80000000; //最小负数
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (curSum <= 0)   //记录初始值 负数则从下一个正数开始累加
                curSum = array[i];
            else   //否则累加值
                curSum += array[i];
            if (curSum > greatestSum)  //当前累加值大于当前记录最大值 则更新最优
                greatestSum = curSum;
        }
        return greatestSum;
    }
}
