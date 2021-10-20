/*
  Contributed by: Md. A. Barik
  Video Explanation: https://youtu.be/UfAoCstdoWI
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode start = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                start = head;
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }
                break;
            }
        }
        return start;       
    }
}
