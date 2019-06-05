package org.interview.preperation.array;

/**
 * O(n)
 * Find sub-array with max no.of ones
 */
public class FindSubArrayWithMaxOnes {
    public static void main(String... args) {
        int[] arr = new int[]{1,1,1,0,0,1,1,1};

        int from = 0;
        int to = 0;
        int total = 0;
        int maxTotal = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];

            if (arr[i] == 0) {
                total = 0;
            }

            if (maxTotal < total) {
                maxTotal = total;
                to = i;
                from = i - (total-1);
            }
        }

        System.out.println(from+ " " + to);
    }
}
