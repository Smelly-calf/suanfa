package practice.array;

import structure.ListNode;

public class Solution {

    // 删除重复项
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++; // 注意：如果fast++在前面会导致访问nums[fast]越界
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }

    public int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast]; // 注意这里是先给slow赋值再进行slow++，这样可以保证 nums[0..slow-1] 是不包含值为 val 的元素的，
                slow++;                  // 最后的结果数组长度就是 slow。
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 1, 2, 3, 3};
        int newLen = s.removeDuplicates(nums);
        for (int i = 0; i < newLen; i++) {
            System.out.print(nums[i]);
        }
    }
}

