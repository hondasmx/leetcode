public class RemoveDuplicatesFromSortedList_83 {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {

        var checked = head;
        while (checked != null) {
            if (checked.next == null) {
                break;
            }

            if (checked.next.val == checked.val) {
                checked.next = checked.next.next;
            } else {
                checked = checked.next;
            }

        }
        return head;
    }
}
