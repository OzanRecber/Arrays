package arrays;

import java.util.*;

public class RepeatingEvenNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of elements in the array: ");
		int n = scan.nextInt();
		int[] arr = new int[n];

		// Ask the user to create the array
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Element " + (i + 1) + ": ");
			arr[i] = scan.nextInt();
		}

		// Sort array
		Arrays.sort(arr);
		System.out.println("Created array: " + Arrays.toString(arr));

		// Find repeating even numbers
		int[] duplicate = new int[arr.length];
		int startIndex = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] % 2 == 0 && arr[i] == arr[j]) {
					if (!isFind(duplicate, arr[i])) {
						duplicate[startIndex++] = arr[i];
					}
					break; // Get out of control again
				}
			}
		}

		// Print repeating even numbers to the screen
		System.out.print("Repeating even numbers: ");
		for (int value : duplicate) {
			if (value != 0) {
				System.out.print(value + " ");
			}
		}
		scan.close();
	}
	private static boolean isFind(int[] arr, int value) {
		for (int i : arr) {
			if (i == value)
				return true;
		}
		return false;
	}
}