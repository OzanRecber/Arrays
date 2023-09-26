package arrays;

import java.util.*;

public class MaxMinFinder {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of elements in the array: ");
		int n = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Element " + (i + 1) + ": ");
			arr[i] = scan.nextInt();
		}
		System.out.println("Created array: " + Arrays.toString(arr));

		int max = arr[0];
		int min = arr[0];

		for (int i : arr) {
			if (i > max) {
				max = i;
			}
			if (i < min) {
				min = i;
			}
		}
		System.out.println("The largest element of the array is: " + max);
		System.out.println("The smallest element of the array is: " + min);

		scan.close();
	}

}
