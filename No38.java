package 剑指offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 * Created by MelloChan on 2017/11/16.
 */
public class No38 {
    public static void main(String[] args) {
        Solution38 solution38 = new Solution38();
        int[] array = {1, 2, 2, 2, 2, 3, 4, 5};
        System.out.println(solution38.getNumberOfK(array, 0));
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

    /**
     * 查找k在数组中第一次出现的所以
     *
     * @param array
     * @param k
     * @param start
     * @param end
     * @return
     */
    public int getFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        int midDate = array[midIndex];

        if (midDate == k) {// 中值即为k
            if ((midIndex > 0 && array[midIndex - 1] != k) || midIndex == 0) {
                return midIndex; //若中值的前一个值不为k或当前中值为 0 索引,则当前索引为第一个k值所在索引
            } else {
                end = midIndex - 1; //否则向数组前半段 继续查找第一个k值索引
            }
        } else if (midDate > k) {
            end = midIndex - 1; //若中值 > k 证明后半段不存在k值 更新k所在索引的可能终末索引
        } else {
            start = midIndex + 1; //若中值 < k 证明前半段不存在k值 更新k所在索引的可能初始索引
        }
        return getFirstK(array, k, start, end);
    }

    /**
     * 查找k在数组中最后一次出现的索引
     *
     * @param array
     * @param k
     * @param start
     * @param end
     * @return
     */
    public int getLastK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        int midDate = array[midIndex];
        if (midDate == k) {
            if ((midIndex < array.length - 1 && array[midIndex + 1] != k) || midIndex == array.length - 1) {
                return midIndex;//中值为k, 若中值索引的后一位不等于k或当然中值索引为末索引 则表明查找到k在数组中最后一次出现的索引
            } else {
                start = midIndex + 1; //否则继续往后查找
            }
        } else if (midDate > k) {
            end = midIndex - 1; //中值 > k  更新k可能范围的末索引
        } else {
            start = midIndex + 1; //中值 < k 更新k可能范围的初始索引
        }
        return getLastK(array, k, start, end);
    }
}
