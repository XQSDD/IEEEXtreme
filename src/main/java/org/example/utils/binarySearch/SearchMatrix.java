package org.example.utils.binarySearch;

/**
 * @author pc
 * @description 搜索二维矩阵
 * 编写一个高效的算法来判断  m x n  矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * @create 2023/10/27 22:12
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 思路：将2维数组转为1维数组 进行二分搜索
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            // 获取2维数组对应值
            int val = matrix[mid/col][mid%col];
            if (val < target) {
                left = mid;
            } else if (val > target) {
                right = mid;
            } else {
                return true;
            }
        }
        if (matrix[left/col][left%col] == target || matrix[right/col][right%col] == target) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix.searchMatrix(matrix, 3));
    }
}
