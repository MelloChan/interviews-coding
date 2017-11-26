package 剑指offer;

import java.util.Arrays;

/**
 * 扑克牌的顺子
 * Created by MelloChan on 2017/11/26.
 */
public class No46 {
    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(solution46.isContinuous(arr));
    }
}

/**
 * 解决方案:排序数组->记录0号个数->记录间隔
 */
class Solution46 {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 1) {
            return false;
        }
        Arrays.sort(numbers);
        int length = numbers.length;
        int numberOfZero = 0;
        int numberOfGap = 0;
        for (int i = 0; i < length && numbers[i] == 0; ++i) {
            ++numberOfZero;
        }

        int small = numberOfZero;
        int big = small + 1;
        while (big < length) {
            if (numbers[small] == numbers[big])
                return false;

            numberOfGap = numberOfGap + numbers[big] - numbers[small] - 1;
            small = big;
            ++big;
        }
        return numberOfGap <= numberOfZero;
    }
}