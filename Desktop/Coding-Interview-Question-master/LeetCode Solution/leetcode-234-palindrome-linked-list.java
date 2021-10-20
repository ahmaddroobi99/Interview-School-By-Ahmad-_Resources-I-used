/*
  Illustrated video explanation: https://youtu.be/zzm_aJiKgKQ
*/
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        
        // find middle of the given linked list && p1 will point to middle node
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        // reversing first half
        ListNode tmp = null;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != p1) {
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        // odd number of elements, need left move p1 one step
        if (p2 != null && p2.next == null) p1 = p1.next;
        
        while(p1 != null) {
            if (p1.val != prev.val) return false;
            p1 = p1.next;
            prev = prev.next;
        }
        return true;
    }
}
	
