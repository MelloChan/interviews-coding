package 剑指offer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * Created by MelloChan on 2017/10/22.
 */
public class No14 {
    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] array2 = new int[]{1, 2, 3, 4, 5, 6, 7};
        new Solution14().reOrderArray(array1);
        new Solution14().reOrderArray(array2,array2.length);
        for (int i : array1) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i:array2) {
            System.out.print(i+" ");
        }
    }
}

class Solution14 {
    /**
     * 不能保证顺序 o(n)时间复杂度 o(1)空间复杂度
     *
     * @param array
     * @param length
     */
    public void reOrderArray(int[] array, int length) {
        if (array == null || length == 0) {
            return;
        }
        int first = 0, second = array.length - 1;
        while (first < second) {
            //找到偶数
            while ((first < second) && ((array[first] & 1) != 0)) {
                first++;
            }
            //找到奇数
            while ((first < second) && ((array[second] & 1) != 1)) {
                second--;
            }
            if (first < second) {
                array[first] ^= array[second];
                array[second] ^= array[first];
                array[first] ^= array[second];
            }
        }
    }

    /**
     * 保证顺序 o(n)时间复杂度与o(n)空间复杂度
     *
     * @param array
     */
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        // count 记录奇数个数
        int begin = 0, count = 0, length = array.length;
        int[] newArray = new int[length]; // 用来存储新的奇偶数组[按照顺序]
        for (int anArray : array) {
            if ((anArray & 1) == 1) {
                count++;
            }
        }
        for (int anArray : array) {
            if ((anArray & 1) == 1) {
                newArray[begin++] = anArray;
            } else {
                newArray[count++] = anArray;
            }
        }
        //copy数据到原数组
        System.arraycopy(newArray, 0, array, 0, length);
    }
}
