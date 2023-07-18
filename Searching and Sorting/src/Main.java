import java.util.Scanner;

import javax.swing.JFrame;

public class Main {


    public static void main(String[] args) {

        MainGUI gui = new MainGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(300, 400);
        gui.setVisible(true);


        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println("1. Searching");
        System.out.println("2. Sorting");
        System.out.println("Enter number:");

        int choice = scanner.nextInt();

        while (true) {
            if (choice == 1) {
                performSearching(scanner);
            } else if (choice == 2) {
                performSorting(scanner);
            } else {
                System.out.println("Invalid choice!");
            }

            System.out.println("Do you want to continue? (Y/N)");
            String continueChoice = scanner.next();

            if (!continueChoice.equalsIgnoreCase("Y")) {
                break;
            }

            System.out.println("What would you like to do?");
            System.out.println("1. Searching");
            System.out.println("2. Sorting");
            System.out.println("Enter number:");

            choice = scanner.nextInt();
        }
    }

    // Rest of the code remains the same
    // ...

    public static void performSearching(Scanner scanner) {
        System.out.println("Choose a searching method:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");

        int method = getSearchMethod(scanner);

        System.out.println("Enter the size of the array:");
        int size = scanner.nextInt();

        int[] array = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Enter the target value:");
        int target = scanner.nextInt();

        int index;

        if (method == 1) {
            long startTime = System.nanoTime();
            index = Searching.linearSearch(array, target);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("Linear search time complexity: O(n)");
            System.out.println("Execution time: " + duration + " nanoseconds");
        } else if (method == 2) {
            long startTime = System.nanoTime();
            index = Searching.binarySearch(array, target);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("Binary search time complexity: O(log n)");
            System.out.println("Execution time: " + duration + " nanoseconds");
        } else {
            System.out.println("Invalid method!");
            return;
        }

        if (index == -1) {
            System.out.println("Target value not found in the array.");
        } else {
            System.out.println("Target value found at index: " + index);
        }
    }

    public static void performSorting(Scanner scanner) {
        System.out.println("Choose a sorting method:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Merge Sort");
        System.out.println("5. Quick Sort");
        System.out.println("6. Heap Sort");
        System.out.println("7. Radix Sort");

        int method = getSortMethod(scanner);

        System.out.println("Enter the size of the array:");
        int size = scanner.nextInt();

        int[] array = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        switch (method) {
            case 1 -> {
                long startTime = System.nanoTime();
                Sorting.bubbleSort(array);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                System.out.println("Bubble sort time complexity: O(n^2)");
                System.out.println("Execution time: " + duration + " nanoseconds");
            }
            case 2 -> {
                long startTime = System.nanoTime();
                Sorting.selectionSort(array);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                System.out.println("Selection sort time complexity: O(n^2)");
                System.out.println("Execution time: " + duration + " nanoseconds");
            }
            case 3 -> {
                long startTime = System.nanoTime();
                Sorting.insertionSort(array);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                System.out.println("Insertion sort time complexity: O(n^2)");
                System.out.println("Execution time: " + duration + " nanoseconds");
            }
            case 4 -> {
                long startTime = System.nanoTime();
                Sorting.mergeSort(array);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                System.out.println("Merge sort time complexity: O(n log n)");
                System.out.println("Execution time: " + duration + " nanoseconds");
            }
            case 5 -> {
                long startTime = System.nanoTime();
                Sorting.quickSort(array);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                System.out.println("Quick sort time complexity: O(n log n)");
                System.out.println("Execution time: " + duration + " nanoseconds");
            }
            case 6 -> {
                long startTime = System.nanoTime();
                Sorting.heapSort(array);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                System.out.println("Heap sort time complexity: O(n log n)");
                System.out.println("Execution time: " + duration + " nanoseconds");
            }
            case 7 -> {
                long startTime = System.nanoTime();
                Sorting.radixSort(array);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                System.out.println("Radix sort time complexity: O(k * n)");
                System.out.println("Execution time: " + duration + " nanoseconds");
            }
            default -> {
                System.out.println("Invalid method!");
                return;
            }
        }

        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int getSearchMethod(Scanner scanner) {
        int method = scanner.nextInt();
        if (method < 1 || method > 2) {
            System.out.println("Invalid method!");
            return getSearchMethod(scanner);
        }
        return method;
    }

    public static int getSortMethod(Scanner scanner) {
        int method = scanner.nextInt();
        if (method < 1 || method > 7) {
            System.out.println("Invalid method!");
            return getSortMethod(scanner);
        }
        return method;
    }
}
