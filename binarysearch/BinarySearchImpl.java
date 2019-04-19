package algorithms.binarysearch;

public class BinarySearchImpl {
    public static void main(String args[]) {
        //sorted array
        int[] arr = new int[]{9, 16, 22, 55, 78, 93, 103};
        boolean result1 = binarySearch(arr, 79);
        boolean result2 = binarySearchRec(arr, 0, arr.length - 1, 79);
        System.out.println(result1 == result2);
    }

    private static boolean binarySearch(int[] arr, int key) {
        //these variables help us to fix the boundaries
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            //avoid over flow for large numbers
            int mid = (low + high) >> 1;

            if (arr[mid] == key) {
                return true;
            }

            if (arr[mid] < key) {
                low = mid + 1;
            } else if (arr[mid] > key) {
                high = mid - 1;
            }
        }
        return false;
    }

    private static boolean binarySearchRec(int[] arr, int low, int high, int key) {
        if (low > high) {
            return false;
        }

        int mid = (low + high) >> 1;

        if (arr[mid] == key) {
            return true;
        }

        if (arr[mid] < key) {
            low = mid + 1;
        } else if (arr[mid] > key) {
            high = mid - 1;
        }
        return binarySearchRec(arr, low, high, key);
    }
}
