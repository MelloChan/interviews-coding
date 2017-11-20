package 剑指offer;

import java.util.ArrayList;


/**
 * 输入一个递增排序的数组和一个数字S，
 * 在数组中查找两个数，是的他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * Created by MelloChan on 2017/11/19.
 */
public class No41 {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 11, 15};
        Solution41 solution41 = new Solution41();
        System.out.println(solution41.findNumbersWithSum(array, 15));
        System.out.println(solution41.findNumbersWithSum(array, 7));
    }
}

/**
 * 解决方案:双指针
 * 设置首尾双指针 相加 若小于sum 则首首指针++,大于sum 则尾指针--
 */
class Solution41 {
    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        if (array == null || array.length <= 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int first = 0, second = array.length - 1, s;
        while (first < second) {
            s = array[first] + array[second];
            if (s < sum) {
                ++first;
            } else if (s > sum) {
                --second;
            } else {
                arrayList.add(array[first]);
                arrayList.add(array[second]);
                break;
            }
        }
        return arrayList;
    }
}