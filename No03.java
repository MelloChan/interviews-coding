package 剑指offer;

/**
 * 在一个二维数组中，
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * Created by MelloChan on 2017/10/17.
 */
public class No03 {
    public static void main(String[] args) {
        Solution03 solution = new Solution03();
        int target = 13;
//        int[][] array=new int[0][0];
        int[][] array = new int[][]{
                {1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}
        };
        System.out.println(solution.find(target, array));
    }
}

/**
 * 解决思路:从(0,max)开始比较值
 * == : 查找成功  value< : 忽略当前列 转接左边列
 * value > : 忽略当前行 转接下一行
 */
class Solution03 {
    public boolean find(int target, int[][] array) {
        boolean flag = false;
        if (array.length == 0) return flag;
        int columns = array[0].length, rows = array.length;
        int column = columns - 1, row = 0;
        while (column >= 0 && row < rows) {
            if (target == array[row][column]) {
                flag = true;
                break;
            } else if (target < array[row][column]) {
                column--;
            } else {
                row++;
            }
        }
        return flag;
    }
}