package 剑指offer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * Created by MelloChan on 2017/11/5.
 */
public class No29 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        Solution29 solution29 = new Solution29();
        System.out.println(solution29.moreThanHalfNum(array));
    }
}

/**
 * 解决方案:通过记录重复出现的数字+次数
 * 关键在于一个数字出现的次数超过数组长度的一半 则至少有间隔为0的重复数字排序
 */
class Solution29 {
    public int moreThanHalfNum(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int length = array.length;
        int result = array[0];
        int times = 1;
        for (int i = 1; i < length; ++i) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else if (array[i] == result) {
                times++;
            } else {
                times--;
            }
        }
        if (!checkMoreThanHalfNum(array, length, result)) {
            return 0;
        }
        return result;
    }

    private boolean checkMoreThanHalfNum(int[] array, int length, int number) {
        int times = 0;
        for (int i = 0; i < length; ++i) {
            if (number == array[i]) {
                times++;
            }
        }
        boolean flag = true;
        if (times * 2 <= length) {
            flag = false;
        }
        return flag;
    }
}
