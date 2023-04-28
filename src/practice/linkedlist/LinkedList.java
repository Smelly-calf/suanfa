package practice.linkedlist;

import structure.ListNode;

public class LinkedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                // nums[slow] = nums[fast];
                slow.next = fast; // 这两步赋值跟数组有区别，数组和链表这里还是有很大区别
                // slow++;
                slow = slow.next;
            }
            // fast++
            fast = fast.next;
        }
        // 断开与后面重复元素的连接
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {

    }
}
