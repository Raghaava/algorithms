package org.interview.preperation.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayHavingMoreOnesThanZeros {
    public static void main(String... args) {
        int[] arr = new int[]{-1, -1, 1, -1, 1, -1, 1};
        System.out.println(subArraySum(arr, 1));
    }

    private static int subArraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 1) {
                maxLength = i + 1;
            }
            map.putIfAbsent(sum, i);
            if (map.containsKey(sum - 1)) {
                maxLength = Math.max(maxLength, i - map.get(sum - 1));
            }
        }

        return maxLength;
    }
}
