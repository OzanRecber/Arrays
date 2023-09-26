package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ClosestNumbers {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the number of elements in the array: ");
		int n = scan.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			System.out.print("Element " + (i + 1) + ": ");
			arr[i] = scan.nextInt();
		}
		
		// Sort array
        Arrays.sort(arr);
        System.out.println("Created array: " + Arrays.toString(arr));

		// Get the number entered by the user
		System.out.print("Enter the number to be checked: ");
		int number = scan.nextInt();

		// Find the closest small and large numbers
		int closestSmaller = Integer.MIN_VALUE;
		int closestLarger = Integer.MAX_VALUE;

		for (int i : arr) {
			if (i == number) {
				closestSmaller = i;
				closestLarger = i;
				break;
			}
			if (i < number) {
				closestSmaller = i;
			} else {
				closestLarger = i;
				break;
			}
		}

		System.out.println("The number that is smaller than and closest to the entered number: " + closestSmaller);
		System.out.println("The number that is greater than and closest to the entered number: " + closestLarger);
	}
}