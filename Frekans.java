package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Frekans {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of elements in the array: ");
		int n = scan.nextInt();
		int[] arr = new int[n];
		int count = 1;
		int startIndex = 0;

		for (int i = 0; i < arr.length; i++) {
			System.out.print("Element: " + (i + 1) + ": ");
			arr[i] = scan.nextInt();
		}
		int[] frequencies = new int[arr.length];

		System.out.println("Created array: " + Arrays.toString(arr));

		System.out.println("Number of repetitions");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i != j && arr[i] == arr[j]) {
					count++;
				}
			}
			if (isFind(frequencies, arr[i])) {
				frequencies[startIndex++] = arr[i];
				System.out.println("Number " + arr[i] + " repeated " + count + " times");
			}
			count = 1;
		}
		scan.close();

	}

	private static boolean isFind(int[] frequencies, int value) {
		for (int i : frequencies) {
			if (i == value) {
				return false;
			}
		}
		return true;
	}

}
