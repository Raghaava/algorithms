package org.interview.preperation.array;

public class SubArrayWithMinSum_Kadanes {
    public static void main(String... ars) {
        int[] arr = new int[]{2, 6, 8, 1, 4};
        System.out.println(findSubArrayWithMinSum(arr));
    }

    private static int findSubArrayWithMinSum(int[] arr) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum = Math.min(arr[i],sum+arr[i]);
            min = Math.min(min,sum);
        }

        return min;
    }
}

