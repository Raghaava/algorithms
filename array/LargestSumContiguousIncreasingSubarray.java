package org.interview.preperation.array;

public class LargestSumContiguousIncreasingSubarray {

  public static void main(String args[]) {
    int[] arr = new int[]{38, 7, 8, 10, 12};
    System.out.println(largestSum(arr));
  }

  private static int largestSum(int[] arr) {
    int maxSum = 0;
    int sum = 0;
    int prev = -1;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (prev > arr[i]) {
        sum = arr[i];
      }
      maxSum = Math.max(sum, maxSum);
      prev = arr[i];
    }
    return maxSum;
  }
}
