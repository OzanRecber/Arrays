package arrays;

import java.util.*;

public class Average {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int n;
        do {
            System.out.print("Enter the number of elements of the array (must be positive): ");
            n = scan.nextInt();
        } while (n <= 0);

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = scan.nextInt();
        }
        
        System.out.println("Created array: " + Arrays.toString(arr));
        System.out.println("Average: " + average(arr));
    }

    private static double average(int[] arr) {
        double sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum / arr.length;
    }
}