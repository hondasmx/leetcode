package leetcode.easy;

import leetcode.ListNode;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        var current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }
}
