package practice.array;

import java.util.Arrays;

// 螺旋生成或螺旋遍历矩阵
public class SpiralMatrix {
    // 生成从1到n的平方的螺旋矩阵
    int[][] generateMatrix(int n) {
        // 上边界、右边界、下边界、左边界
        int upper_bound = 0, left_bound = 0, right_bound = n - 1, lower_bound = n - 1;
        // new二维数组存放螺旋矩阵
        int[][] matrix = new int[n][n];
        int num = 1;
        while (num <= n * n) {
            // 沿上边界从左到右遍历
            if (upper_bound <= lower_bound) {
                for (int j = left_bound; j <= right_bound; j++) {
                    matrix[upper_bound][j] = num++;
                }
                upper_bound++; // 上边界下移
            }
            // 沿右边界从上到下遍历
            if (left_bound <= right_bound) {
                for (int i = upper_bound; i <= lower_bound; i++) {
                    matrix[i][right_bound] = num++;
                }
                right_bound--; // 右边界左移
            }
            // 沿下边界从右到左遍历
            if (upper_bound <= lower_bound) {
                for (int j = right_bound; j >= left_bound; j--) {
                    matrix[lower_bound][j] = num++;
                }
                lower_bound--; // 下边界上移
            }
            // 沿左边界从下到上遍历
            if (left_bound <= right_bound) {
                for (int i = lower_bound; i >= upper_bound; i--) {
                    matrix[i][left_bound] = num++;
                }
                left_bound++; // 左边界右移
            }
            // 循环直到n方
        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrix m=new SpiralMatrix();
        int[][] res=m.generateMatrix(3);
        System.out.println(Arrays.deepToString(res));
    }
}
