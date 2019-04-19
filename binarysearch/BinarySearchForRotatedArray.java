import java.io.IOException;

/*
Search an element in a sorted and rotated array

we rotate an ascending order sorted array at some pivot unknown to you beforehand.
So for instance, 1 2 3 4 5 might become 3 4 5 1 2.
Devise a way to find an element in the rotated array in O(log n) time.
 */
public class BinarySearchForRotatedArray {
    public static void main(String args[]) throws IOException {
        int arr[] = {5, 6, 7, 8, 9, 11, 12, 13, 1, 2, 3};
        for (int i = arr.length - 1; i >= 0; i--) {
            int result = binarySearch(arr, 0, arr.length - 1, arr[i]);
            System.out.println(result);
        }
    }

    private static int binarySearch(int[] arr, int low, int high, int key) {

        if (low > high) {
            return -1;
        }
        //avoid over flow for large numbers
        int mid = (low + high) >>> 1;

        if (arr[mid] == key) {
            return mid;
        }

        //Left side array is sorted
        if (arr[low] < arr[mid]) {
            if (arr[low] <= key && arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        } else {
            //right side array is sorted
            if (arr[mid + 1] <= key && arr[high] >= key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return binarySearch(arr, low, high, key);
    }
}
