package org.interview.preperation.array;

public class BitsFlip {
    public static void main(String... args) {
        int[] arr = new int[]{1, 0, 0, 1, 0, 1, 0};
        System.out.println(findMaxOnes(arr));
        System.out.println(findMaxOnesKadanesAlgo(arr));
    }

    private static int findMaxOnesKadanesAlgo(int[] arr) {
        int totalMax = 0;
        int currentMax = 0;
        int countOfOnes = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                countOfOnes++;
            }

            int val = arr[i] == 0 ? 1 : -1;
            currentMax = Math.max(val, currentMax + val);
            totalMax = Math.max(totalMax, currentMax);
        }
        return countOfOnes + totalMax;
    }

    private static int findMaxOnes(int[] arr) {
        int maxResult = 0;
        int from = 0;
        int to = 0;
        for (int i = 0; i < arr.length; i++) {
            int netResult = arr[i] == 1 ? -1 : 1;
            if (maxResult < netResult) {
                from = to = i;
                maxResult = netResult;
            }
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == 0) {
                    netResult++;
                } else {
                    netResult--;
                }
                if (maxResult < netResult) {
                    from = i;
                    to = j;
                    maxResult = netResult;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i >= from && i <= to) {
                continue;
            }
            if (arr[i] == 1) {
                maxResult++;
            }
        }
        return maxResult;
    }
}
