public class Sorting {
    public static void bubbleSort(int[] array){
        int n = (array.length);
        for (int i=0; i < n-1; i++){
            for ( int j=0; j < n-i-1; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] array){
        int n = (array.length);
        for (int i=0; i < n-1; i++){
            int minI = i;
            for(int j=i+1; j < n; j++){
                if (array[j] < array[minI]){
                    minI = j;
                }
            }
            swapIndex(array[minI], array[i]);
        }
    }
    private static void swapIndex(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }

    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            // Move elements greater than key to one position ahead
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            // Place the key in its correct position
            array[j + 1] = key;
        }
    }
    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

            // Split the array into left and right sub-arrays
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

            // Recursively sort the left and right sub-arrays
        mergeSort(left);
        mergeSort(right);

            // Merge the sorted left and right sub-arrays
        merge(array, left, right);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0; // Index for left sub-array
        int j = 0; // Index for right sub-array
        int k = 0; // Index for merged array

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

            // Copy remaining elements from left sub-array, if any
        while (i < left.length) {
            array[k++] = left[i++];
        }

            // Copy remaining elements from right sub-array, if any
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    public static void quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int low = 0;
        int high = array.length - 1;
        quickSort(array, low, high);
    }
    public static void quickSort(int[] array, int low, int high){
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    public static void heapSort(int[] array) {
        MaxHeap(array);

        for (int i = array.length - 1; i >= 1; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    private static void MaxHeap(int[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(array, i, largest);
            heapify(array, n, largest);
        }
    }

    public static void radixSort(int[] array) {
        int max = findMax(array);
        int digitPosition = 1;

        while (max / digitPosition > 0) {
            countSort(array, digitPosition);
            digitPosition *= 10;
        }
    }
    private static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    private static void countSort(int[] array, int digitPosition) {
        int n = array.length;
        int[] count = new int[10];
        int[] output = new int[n];

        for (int j : array) {
            int index = (j / digitPosition) % 10;
            count[index]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int index = (array[i] / digitPosition) % 10;
            output[count[index] - 1] = array[i];
            count[index]--;
        }

        System.arraycopy(output, 0, array, 0, n);
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
