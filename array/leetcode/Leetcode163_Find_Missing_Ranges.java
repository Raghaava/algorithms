package org.interview.preperation.array.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted array and a boundaries, find the missing ranges.
 *
 * [0,1,3,65,76]
 *
 * lower boundary = 0 higher boundary = 99
 */
public class Leetcode163_Find_Missing_Ranges {

  public static void main(String... args) {
    int[] nums = new int[]{Integer.MIN_VALUE, 0, 1, 3, 65, 76, 99, Integer.MAX_VALUE,
        Integer.MAX_VALUE};
    int lower_boundary = 0;
    int higher_boundary = Integer.MAX_VALUE;

    List<String> missing_ranges = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == Integer.MIN_VALUE) {
        lower_boundary = Integer.MIN_VALUE + 1;
        continue;
      }

      // We compare lower_boundary with current_value-1 not current value
      // because our intention is finding missing ranges.
      if (lower_boundary < nums[i] - 1) {
        missing_ranges.add(lower_boundary + "->" + (nums[i] - 1));
      } else if (lower_boundary == nums[i] - 1) {
        // only single value is missing not range.
        missing_ranges.add(String.valueOf(lower_boundary));
      }
      if (nums[i] == Integer.MAX_VALUE) {
        lower_boundary = Integer.MAX_VALUE;
        break;
      }
      // this is smart.
      lower_boundary = nums[i] + 1;
    }
    if (lower_boundary < higher_boundary) {
      missing_ranges.add(lower_boundary + "->" + higher_boundary);
    }
    // ?
    if (lower_boundary == higher_boundary && lower_boundary != Integer.MAX_VALUE) {
      missing_ranges.add(String.valueOf(lower_boundary));
    }
    missing_ranges.forEach(System.out::println);
  }
}
