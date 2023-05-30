import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int temp = 0;

        while (p != null || q != null) {
            int x = 0;
            int y = 0;
            if(p != null) {x = p.val;}
            if(q != null) {y = q.val;}
            int sum = temp + x + y;
            temp = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            
            if (p != null) {p = p.next;}
            if (q != null) {q = q.next;}
        }
        
        if (temp > 0) {
            curr.next = new ListNode(temp);
        }
        
        return dummy.next;
    }
}