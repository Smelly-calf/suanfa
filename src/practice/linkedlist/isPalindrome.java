package practice.linkedlist;

import structure.ListNode;

// 是否回文串
class IsPalindrome {
    ListNode left;

    boolean traverse(ListNode right) {
        if (right == null) return true;
        boolean res = traverse(right.next);
        // 后序遍历代码
        if (!res) {
            return res;
        }
        res = right.val == left.val;
        left = left.next;
        return res;
    }

    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    public static void main(String[] args) {
        IsPalindrome s = new IsPalindrome();
        int[] nums = {1,2,4,3,2,1};
        ListNode l = new ListNode(-1);
        ListNode head = l.createLinkedList(nums,0,nums.length);
        System.out.println(s.isPalindrome(head));
    }
}
