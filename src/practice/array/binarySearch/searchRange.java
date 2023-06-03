package practice.array.binarySearch;

public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        // 用两端闭区间解题
        int left = 0, right = nums.length - 1;
        int[] res = new int[2];
        int mid = 0;
        // 找左侧边界
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 锁定左区间
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        // left==right+1:考虑左侧边界在最右边
        if (left == nums.length) {
            res[0] = -1;
        } else if (nums[left] == target) {
            res[0] = left;
        } else {
            res[0] = -1;
        }

        left = 0;
        right = nums.length - 1;
        // 找右侧边界
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 锁定右区间
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        // right==left-1：考虑右侧边界比0还小
        if (right < 0) {
            res[1] = -1;
        } else if (nums[left - 1] == target) {
            res[1] = left - 1;
        } else {
            res[1] = -1;
        }
        return res;
    }
}
