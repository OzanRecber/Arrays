package arrays;

import java.util.*;

public class SortingNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Size of the array: ");
		int n = scan.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter the elements of the array");
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Element " + (i + 1) + ": ");
			arr[i] = scan.nextInt();
		}
		Arrays.sort(arr);
		System.out.print("Numbers sorted from smallest to largest: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		scan.close();
	}

}
