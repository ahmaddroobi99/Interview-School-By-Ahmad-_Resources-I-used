/*
  Illustrated video explanation: https://youtu.be/uasZhwzhoc8
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        // find last node of linked list A
        ListNode endA = headA;
        while (endA.next != null) {
            endA = endA.next;
        }
        // link first node (head) of second link list to the end node of first linked list
        endA.next = headB;

        ListNode start = null; // if there's no cycle this will stay null
        // Floyd's Algorithm
        ListNode slow = headA, fast = headA;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // found a cycle
                // reset start pointer to beginning to the joined linked list
                start = headA;
                while (slow != start) {
                    slow = slow.next;
                    start = start.next;
                }
                break;
            }
        }
        // remove the linked end of first linked list to the first node of second linked list
        // so we maintain here the constraint that we can't modify given linked lists
        endA.next = null;
        return start;
    }
}
/*
  Time complexity: O(n)
  Space complexity: O(1)
*/
