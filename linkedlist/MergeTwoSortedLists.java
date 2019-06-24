package org.interview.preperation.linkedlist;

public class MergeTwoSortedLists {

  public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null) {
        return l2;
      }
      if (l2 == null) {
        return l1;
      }

      ListNode root = null;
      ListNode current = null;

      while (l1 != null && l2 != null) {
        ListNode temp = null;
        if (l1.val <= l2.val) {
          temp = new ListNode(l1.val);
          l1 = l1.next;
        } else {
          temp = new ListNode(l2.val);
          l2 = l2.next;
        }

        if (root == null) {
          root = temp;
        } else {
          current.next = temp;
        }
        current = temp;
      }

      while (l1 != null) {
        current.next = new ListNode(l1.val);
        current = current.next;
        l1 = l1.next;
      }
      while (l2 != null) {
        current.next = new ListNode(l2.val);
        current = current.next;
        l2 = l2.next;
      }

      return root;
    }
  }
}
