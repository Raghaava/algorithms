/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast,slow;
        fast = slow =dummy;
        
        //  dummy -> 1->2->3->4->5->null
        //                       f
        //    s
        //  s.next = s.next.next
        //  dummy.next
        
        for(int i=1;i<=n;i++)
        {
          fast = fast.next;
        }
        
        while(fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        
        //remove nth node.
        slow.next =slow.next.next;
        
        //return head.
        return dummy.next;
    }
}

/**
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        //Have 2 pointers.
        ListNode last = head;
        
        //Move last pointer to n+1th index.
        for(int i=2;i<=n+1;i++){
          last = last.next;
        }
        
        //remove first node
         if(last == null){
             return head.next;
         }
        
        //Start first pointer from head.
        ListNode first = head;
        
         //Move both pointers till last reaches tail.
           while(last.next != null){
              last = last.next;
              first = first.next;
           }        
        
        //Remove desired node.
        first.next = first.next.next;
        
        //return head.
        return head;
    }
}
 */

