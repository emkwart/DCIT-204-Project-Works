import java.util.Arrays;
public class Searching {
    public static int linearSearch(int[] array, int target) {
        printArray(array);
        for (int i=0; i < array.length; i++){
            if (array[i] ==target){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int target) {
        Arrays.sort(array); // Sort the array before performing binary search
        printArray(array);
        int low = 0;
        int high = array.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
