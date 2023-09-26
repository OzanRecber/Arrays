package arrays;

import java.util.*;

public class NurseryApp {
	// Student registration will be created for 3-year-olds, 4-year-olds and 5-year-olds in a nursery.
	// Students outside these age groups will not be able to register.
	// Classes of 8 people will be created for each age group.
	// If one of the groups is full, no further registrations will be possible for that group.

	private static final int NUM_AGE_GROUPS = 3; // Toplam yaş grupları sayısı
	private static final int MAX_STUDENTS_PER_GROUP = 8; // Her yaş grubu için maksimum öğrenci sayısı

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        // Create an array of ArrayLists to represent age groups.
        List<String>[] groups = new ArrayList[NUM_AGE_GROUPS];
        for (int i = 0; i < NUM_AGE_GROUPS; i++) {
            groups[i] = new ArrayList<String>();
        }

        while (true) {
            System.out.print("Enter the full name (exit to quit): ");
            String name = scanner.nextLine();

            if (name.equals("exit")) {
                System.out.println("Exiting the system!");
                break;
            }

            System.out.print("Enter the age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character

            if (isValidAge(age)) {
                int index = age - 3; // Index of the age group array (0 for 3-year-olds, 1 for 4-year-olds, 2 for 5-year-olds)
                List<String> ageGroupList = groups[index];

                if (ageGroupList.size() < MAX_STUDENTS_PER_GROUP) {
                    ageGroupList.add(name);
                    System.out.println("Successfully added.");
                } else {
                    System.out.println(age + " age group is full.");
                }
            } else {
                System.out.println("We do not have a class for this age group!");
            }
        }

        // List students in each age group
        for (int i = 0; i < NUM_AGE_GROUPS; i++) {
            System.out.println((i + 3) + "-year-olds group: " + groups[i]);
        }

        scanner.close();
    }

    // A helper method to validate a valid age group
    private static boolean isValidAge(int age) {
        return age >= 3 && age <= 5;
    }
}