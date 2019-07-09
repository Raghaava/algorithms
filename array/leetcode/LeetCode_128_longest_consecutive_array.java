package org.interview.preperation.array.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * [100,2,10,3,1,4,8] -> 4 longest consecutive array is [1,2,3,4]
 */
public class LeetCode_128_longest_consecutive_array {

  public static void main(String... args) {
    int[] arr = new int[]{100, 2, 10, 3, 1, 4, 8, 5};
    findLongestConsecutiveArray(arr);
    System.out.println(findLongestConsecutiveArray2(arr));
    arr = new int[]{100, 2, 10, 3, 1, 4, 8, 5};
    System.out.println(findLongestConsecutiveArray3(arr));
  }

  //O(n3)
  private static int findLongestConsecutiveArray(int[] nums) {
    int current_num = 0;
    int current_streak = 0;
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      current_num = nums[i];
      current_streak = 1;
      while (lookupVal(nums, current_num + 1)) {
        current_num = current_num + 1;
        current_streak = current_streak + 1;
      }
      res = Math.max(res, current_streak);
    }

    System.out.println(res);
    return res;
  }

  private static boolean lookupVal(int[] nums, int n) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == n) {
        return true;
      }
    }
    return false;
  }

  /***************************************************Sol-2**************************************/

  private static int findLongestConsecutiveArray2(int[] nums) {
    int current_streak = 1;
    int res = 0;
    //O(nlogn)
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] + 1 == nums[i]) {
        current_streak++;
      } else {
        current_streak = 1;
      }
      res = Math.max(res, current_streak);
    }

    return res;
  }

  /***************************************************Sol-3**************************************/
  private static int findLongestConsecutiveArray3(int[] nums) {
    int current_streak = 0;
    int current_num = 0;
    int res = 0;
    //extra space O(n) - > for faster lookups
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      set.add(nums[i]);
    }

    //O(n)
    for (int i = 0; i < nums.length; i++) {
      current_streak = 1;
      current_num = nums[i];
      //optimization
      if (set.contains(nums[i] - 1)) {
        continue;
      }
      //This is not equal to o(n)
      while (set.contains(current_num + 1)) {
        current_num = current_num + 1;
        current_streak++;
      }
      res = Math.max(res, current_streak);
    }

    return res;
  }
}
