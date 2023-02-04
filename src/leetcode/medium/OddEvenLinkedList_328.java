package leetcode.medium;

import leetcode.ListNode;

public class OddEvenLinkedList_328 {

    public static void main(String[] args) {

    }

    // 1, 2, 3, 4, 5
    //1,3,4,5 --- 2,

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
