import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class filehandling {
    String name;

    public filehandling() {
        try {
            Scanner scn = new Scanner(System.in);
            System.out.println("Enter the file name: ");
            name = scn.nextLine();
            scn.close();

            File myObj = new File(name);

            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new filehandling();
    }
}
