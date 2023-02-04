package leetcode.easy;

import leetcode.ListNode;

import java.util.ArrayList;

public class MiddleOfLinkedList_876 {

    public static void main(String[] args) {

    }

    public ListNode middleNode(ListNode head) {
        var result = new ArrayList<ListNode>();
        result.add(head);
        while (head.getNext() != null) {
            result.add(head.getNext());
            head = head.getNext();
        }
        return result.get(result.size() / 2 + result.size() % 2);
    }

}
