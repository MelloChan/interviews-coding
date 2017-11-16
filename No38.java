package 剑指offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 * Created by MelloChan on 2017/11/16.
 */
public class No38 {
    public static void main(String[] args) {
        Solution38 solution38=new Solution38();
        int[] array={1,2,2,2,2,3,4,5};
        System.out.println(solution38.getNumberOfK(array,2));
    }
}

/**
 * 解决方案:二分查找+递归
 * 利用已排序的条件 分别找出第一个k与最后的k的索引
 * 相减+1得出数量
 */
class Solution38 {
    public int getNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int first = getFirstK(array, k, 0, array.length - 1);
        int last = getLastK(array, k, 0, array.length - 1);
        int number = 0;
        if (first > -1 && last > -1) {
            number = last - first + 1;
        }
        return number;
    }

    public int getFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        int midDate = array[midIndex];

        if (midDate == k) {
            if ((midIndex > 0 && array[midIndex - 1] != k) || midIndex == 0) {
                return midIndex;
            } else {
                end = midIndex - 1;
            }
        } else if (midDate > k) {
            end = midIndex - 1;
        } else {
            start = midIndex + 1;
        }
        return getFirstK(array, k, start, end);

    }

    public int getLastK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        int midDate = array[midIndex];
        if (midDate == k) {
            if ((midIndex < array.length - 1 && array[midIndex + 1] != k) || midIndex == array.length - 1) {
                return midIndex;
            } else {
                start = midIndex + 1;
            }
        } else if (midDate > k) {
            end = midIndex - 1;
        } else {
            start = midIndex + 1;
        }

        return getLastK(array, k, start, end);
    }
}
