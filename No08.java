package 剑指offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * Created by MelloChan on 2017/10/18.
 */
public class No08 {
    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 5, 1, 2};
//        int[] array=new int[]{3,3,4,5,6,8,1,2};
//        int[] array=null;
        int min = new Solution08().minNumberInRotateArray(array);
        System.out.println("min:" + min);
    }
}

/**
 * 解决方案:遍历方法过于低效,使用双指针+二分法
 * first 初始指向最左索引 second 初始指向最右索引
 * mid 中间值索引
 */
class Solution08 {
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int first = 0, second = array.length - 1;
        while (array[first] >= array[second]) {
            if (second - first == 1) {
                break;
            }
            int mid = (first + second) / 2;
            if (array[first] <= array[mid]) {
                first = mid;
            }
            if (array[second] >= array[mid]) {
                second = mid;
            }
        }
        return array[second];
    }
}
