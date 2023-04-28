package structure;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    // 构造ListNode
    public ListNode createLinkedList(int[] nums, int i, int len) {
        if (i == len) {
            return null;
        }
        ListNode firstNode = new ListNode(nums[i]);
        // 递归
        firstNode.next = createLinkedList(nums, i+1, len);
        return firstNode;
    }
}


