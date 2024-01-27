import java.util.Scanner;

public class Spring_2021_QN1 {
    int[] userInput;
    int[] even;
    int[] odd;

    Spring_2021_QN1() {
        userInput = new int[10];
        even = new int[10];
        odd = new int[10];
        Scanner myScan = new Scanner(System.in); // Created Scanner Object
        System.out.println("Enter 10 numbers : ");
        for (int x = 0; x < 10; x++) {
            userInput[x] = myScan.nextInt();
        }
        myScan.close(); // closing Scanner Object
        int evenIndex = 0;
        int oddIndex = 0;
        for (int number : userInput) {
            if (number % 2 == 0) {
                even[evenIndex++] = number;
            } else {
                odd[oddIndex++] = number; // Increment oddIndex here
            }
        }
        System.out.println("Even and odd numbers from the input you entered are as follows : \n\n");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(even[i] + " ");
        }
        System.out.println("\n");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(odd[i] + " ");
        }
    }

    public static void main(String[] args) {
        new Spring_2021_QN1();
    }
}
