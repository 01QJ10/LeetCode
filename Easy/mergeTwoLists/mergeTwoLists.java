import java.util.*;

class Solution {
	//Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
 
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p = list1;
        ListNode q = list2;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(p != null && q != null) {
            if(p.val <= q.val) {
               curr.next = p;
               p = p.next;
            }
            else {
                curr.next = q;
                q = q.next;
            }
            curr = curr.next;
        }
        while(p == null && q != null) {
            curr.next = q;
            curr = curr.next;
            q = q.next;
        }
        while(q == null && p != null) {
            curr.next = p;
            curr = curr.next;
            p = p.next;
        }
        return dummy.next;
    }
}