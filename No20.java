package 剑指offer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字         1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * Created by MelloChan on 2017/10/29.
 */
public class No20 {
    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12, 13}, {14, 15, 16, 17}
        };
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.printMatrix(array));
    }
}

/**
 * 解决方案:将顺时针的打印理解为一圈一圈的环绕
 * 矩阵左上角的行或列的2倍总是小于相应的行数或列表 同时也对应着需要遍历的圈数
 * 至于分步打印 左->右  上->下 右->左 下->上 理解得还不是很透彻...waiting
 */
class Solution20 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int columns = matrix[0].length;
        int rows = matrix.length;
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (matrix == null || columns <= 0 || rows <= 0) {
            return arrayList;
        }
        int start = 0;
        while (columns > 2 * start && rows > 2 * start) {
            printMatrixInCirle(matrix, start, arrayList);
            start++;
        }
        return arrayList;
    }

    /**
     * @param matrix
     * @param start     起始行列 从左上角开始,总是相等
     * @param arrayList
     * @return
     */
    public ArrayList<Integer> printMatrixInCirle(int[][] matrix, int start, ArrayList<Integer> arrayList) {
        int endX = matrix[0].length - 1 - start;//终止列
        int endY = matrix.length - 1 - start; //终止行
        for (int i = start; i <= endX; ++i) {
            arrayList.add(matrix[start][i]);
        }//打印从左到右

        if (start < endY) {
            for (int i = start + 1; i <= endY; ++i) {
                arrayList.add(matrix[i][endX]);
            }
        }//打印从上到下 显然终末行要大于起始行

        if (start < endY && start < endX) {
            for (int i = endX - 1; i >= start; --i) {
                arrayList.add(matrix[endY][i]);
            }
        }//打印从右到左 显然除了满足第二步打印的条件外还需满足终末列大于起始列

        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; --i) {
                arrayList.add(matrix[i][start]);
            }
        }//打印从下到上 显然至少要有三行两列,且起始列小于终止列
        return arrayList;
    }
}
