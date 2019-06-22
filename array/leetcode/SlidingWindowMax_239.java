package org.interview.preperation.array.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMax_239 {

  public static void main(String... args) {
    int[] arr = maxSlidingWindow(new int[]{1, -1, 1}, 1);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static int[] maxSlidingWindow(int[] arr, int k) {
    if (arr.length == 0 || k == 0) {
      return new int[0];
    }
    //Dequeue for window indexes
    Deque<Integer> deque = new ArrayDeque<>(k);
    int[] res = new int[arr.length - k + 1];
    int index = 0;
    for (int i = 0; i < arr.length; i++) {
      if (!deque.isEmpty() && i - deque.peekFirst() == k) {
        //out of window
        deque.removeFirst();
      }
      //Remove all elements which are less than current value
      while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
        deque.removeLast();
      }
      if (deque.size() < k) {
        deque.addLast(i);
      }
      if (i >= k - 1) {
        res[index++] = arr[deque.peekFirst()];
      }
    }
    return res;
  }
}

class Solution {

  public int[] maxSlidingWindow(int[] arr, int k) {
    if (arr.length == 0 || k == 0) {
      return new int[0];
    }
    int[] res = new int[arr.length - k + 1];

    for (int i = 0; i <= arr.length - k; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = i; j < i + k; j++) {
        max = Math.max(arr[j], max);
      }
      res[i] = max;
    }
    return res;
  }
}
