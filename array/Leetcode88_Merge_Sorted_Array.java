package org.interview.preperation.array.leetcode;

public class Leetcode88_Merge_Sorted_Array {

  public static void main(String args[]) {
    int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
    int[] nums2 = new int[]{2, 5, 6};
    int[] arr = merge(nums1, 3, nums2, 3);
    for(int i=0;i<arr.length;i++)
    System.out.println(arr[i]);
  }

  static int[] merge(int[] nums1, int m, int[] nums2, int n) {
    int[] res = new int[m + n];

    int i = 0;
    int j = 0;

    int index = 0;
    while (j < n && i < m) {
      if (nums1[i] <= nums2[j]) {
        res[index++] = nums1[i++];
      } else {
        res[index++] = nums2[j++];
      }
    }

    while (j < n) {
      res[index++] = nums2[j++];
    }

    while (i < m) {
      res[index++] = nums1[i++];
    }

   return res;
  }
}
