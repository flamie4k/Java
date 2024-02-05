import java.util.Scanner;

public class missingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize an array representing numbers from 1 to 9
        int[] numbersArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println("Enter a series of numbers (1-9) separated by spaces:");
        String userInput = scanner.nextLine();

        // Split user input into an array of strings
        String[] inputArray = userInput.split("\\s+");

        // Initialize an array to track missing numbers
        boolean[] missingNumbers = new boolean[10];

        // Mark existing numbers in the inputArray
        for (String input : inputArray) {
            int number = Integer.parseInt(input);
            missingNumbers[number] = true;
        }

        // Find and print missing numbers
        System.out.println("Missing numbers:");
        for (int i = 1; i <= 9; i++) {
            if (!missingNumbers[i]) {
                System.out.print(i + " ");
            }
        }

        scanner.close();
    }
}

