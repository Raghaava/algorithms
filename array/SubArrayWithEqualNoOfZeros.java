package org.interview.preperation.array;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithEqualNoOfZeros {

  public static void main(String args[]) {
    int[] arr = new int[]{1,1,1,1,1,0,0};
    System.out.println(maxLen(arr));
  }

  /***
   *
   *   0   1  0   1
   *   -1  1  0  1
   *
   */
  static int maxLen(int[] arr) {
    int maxLen = 0;
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      int val = arr[i] == 0 ? -1 : 1;
      sum += val;
      map.putIfAbsent(sum, i);
      if (sum == 0) {
        maxLen = Math.max(maxLen, i+1);
      } else {
        if(map.containsKey(sum))
        {
          maxLen = Math.max(maxLen, i - map.get(sum));
        }
      }
    }
    return maxLen;
  }
}
