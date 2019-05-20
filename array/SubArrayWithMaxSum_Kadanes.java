package org.interview.preperation.array;

public class SubArrayWithMaxSum_Kadanes {
    public static void main(String args[]) {
        int[] arr = new int[]{-2, -5, 6, -2, -3, 1, 5, -6};

        System.out.println(findSubArrayWithMaxSum(arr, 0, arr.length - 1));
    }

    //O(nlogn)
    private static int findSubArrayWithMaxSum(int[] arr, int left, int right) {

        int ans = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] > 0) {
                sum += arr[i];
            }
            else {
                sum = 0;
            }

            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
