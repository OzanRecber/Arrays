package arrays;

import java.util.*;

public class Lotto {

	public static void main(String[] args) {
		int[] userNumbers = new int[6];
		int[] randomNumbers = new int[6];

		Scanner scan = new Scanner(System.in);
		Random random = new Random();

		System.out.println("Please enter 6 numbers between 1 and 49:");
		for (int i = 0; i < userNumbers.length; i++) {
			while (true) {
				System.out.print("Number " + (i + 1) + ": ");
				int userInput = scan.nextInt();

				if (userInput >= 1 && userInput <= 49) {
					boolean exists = false;

					for (int j = 0; j < i; j++) {
						if (userNumbers[j] == userInput) {
							exists = true;
							break;
						}
					}

					if (!exists) {
						userNumbers[i] = userInput;
						break;
					} else {
						System.out.println("You have already entered this number. Please enter a different number.");
					}
				} else {
					System.out.println("Invalid number. Please enter a number between 1 and 49.");
				}
			}
		}
		scan.close();

		for (int i = 0; i < randomNumbers.length; i++) {
			int randomNumber;
			while (true) {
				randomNumber = random.nextInt(49) + 1;
				boolean exists = false;

				for (int j = 0; j < i; j++) {
					if (randomNumbers[j] == randomNumber) {
						exists = true;
						break;
					}
				}

				if (!exists) {
					randomNumbers[i] = randomNumber;
					break;
				}
			}
		}

		Arrays.sort(userNumbers);
		Arrays.sort(randomNumbers);

		int matchingNumberCount = 0;

		for (int userNumber : userNumbers) {
			for (int randomNumber : randomNumbers) {
				if (userNumber == randomNumber) {
					matchingNumberCount++;
					break;
				}
			}
		}

		System.out.println("User Numbers: " + Arrays.toString(userNumbers));
		System.out.println("Random Numbers: " + Arrays.toString(randomNumbers));
		System.out.println("Matching Numbers: " + matchingNumberCount);
	}

}
