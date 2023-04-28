package practice.array;


// 构造前缀和类
class NumArray {
    // 前缀和数组
    private final int[] preSum;

    /* 输入一个数组，构造前缀和 */
    public NumArray(int[] nums) {
        /* 我一开始的版本：preSum[0]=nums[0]，sumRange里面要做判断，left是否从0开始
        preSum = new int[nums.length];
        // 计算 nums 的累加和
        for (int i = 0; i < preSum.length; i++) {
            if (i == 0) {
                preSum[i] = nums[i];
            } else {
                preSum[i] = preSum[i - 1] + nums[i];
            }

        }
        */

        // 以下是拉不拉东的版本：
        // preSum[0] = 0，便于计算累加和
        preSum = new int[nums.length + 1];
        // 计算 nums 的累加和：preSum[i]存储的是nums[0..i-1]的和
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    /* 查询闭区间 [left, right] 的累加和 */
    public int sumRange(int left, int right) {
        /* 我的版本：需要判断left是否从0开始
        if (left == 0) {
            return preSum[right];
        }
        return preSum[right] - preSum[left - 1];
         */

        // 简化版本：求nums[left..right]的前缀和（包含left和right两点），
        // nums[left..right]的和是nums[0..right]的和减去nums[0..left-1]的前缀和
        // 即preSum[right+1]-preSum[left]
        return preSum[right + 1] - preSum[left];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray a = new NumArray(nums);
        int preSum = a.sumRange(0, 2);
        System.out.println(preSum);
        preSum = a.sumRange(2, 5);
        System.out.println(preSum);
        preSum = a.sumRange(0, 5);
        System.out.println(preSum);
    }
}

// 二维矩阵的前缀和数组
class NumMatrix {
    // 定义：preSum[i][j] 记录 matrix 中子矩阵 [0, 0, i-1, j-1] 的元素和
    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if (m == 0 || n == 0) return;
        // 构造前缀和矩阵：preSum的 0 行和0 列都是0
        preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 计算每个矩阵 [0, 0, i, j] 的元素和：preSum左边前缀和 + preSum上边前缀和 + matrix[i-1][j-1] - preSum左上角的前缀和
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] + matrix[i - 1][j - 1] - preSum[i-1][j-1];
            }
        }
    }

    // 计算子矩阵 [x1, y1, x2, y2] 的元素和
    public int sumRegion(int x1, int y1, int x2, int y2) {
        // 目标矩阵之和由四个相邻矩阵运算获得
        return preSum[x2+1][y2+1] - preSum[x1][y2+1] - preSum[x2+1][y1] + preSum[x1][y1];
    }
}
