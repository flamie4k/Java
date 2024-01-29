import java.io.*;
import java.util.*;
//Idk why but myScan.Close() doesn't work so can't fix the resource leak. 

public class Banking {
    //Can't add new users atm
    String[] userName = {"flamie", "pam", "meow", "haggu"};
    String[] password = {"flamie", "pam", "meow", "haggu"};
    String inp_username;
    String inp_password;
    String Name;
    int phoneNo;
    String address;
    float balance;
    double accNo;

    Scanner myScan = new Scanner(System.in);
    String filePath = "bankingDetails.txt";
    File file = new File(filePath);

    Banking() {
        if (file.exists()) {
            System.out.println("Welcome to Meowmeow banking service.");
        } else {
            System.out.println("File not located. Creating new file...\n");
            try {
                FileWriter myWriter = new FileWriter("bankingDetails.txt");
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }
    void createProfile() {
        System.out.println("Enter your name : ");
        Name = myScan.nextLine();
        System.out.println("Enter your phone no : ");
        phoneNo = myScan.nextInt();
        myScan.nextLine();
        System.out.println("Enter your Address : ");
        address = myScan.nextLine();
    }
    double accNoGenerator(){
    accNo = Math.random()*Math.random()*1.82;
    return accNo;
    }
    public static void main(String[] args) {
        String filePath = "bankingDetails.txt";
        Banking b = new Banking();
        Scanner myScan = new Scanner(System.in);
        //infinite loop to keep the program running 
        while (true){
        System.out.println("Enter your username: \n");
        b.inp_username = myScan.nextLine();
        System.out.println("Enter your password : \n");
        b.inp_password = myScan.nextLine();
        if (b.inp_username.equals(b.userName[0]) && b.inp_password.equals(b.password[0]) //User verification
        || b.inp_username.equals(b.userName[1]) && b.inp_password.equals(b.password[1])
        || b.inp_username.equals(b.userName[2]) && b.inp_password.equals(b.password[2])
        || b.inp_username.equals(b.userName[3]) && b.inp_password.equals(b.password[3])
        || b.inp_username.equals(b.userName[4]) && b.inp_password.equals(b.password[4])){
            System.out.println("\nYou have entered correct credentials. Creating a new account : \n");
            b.createProfile();
            b.accNoGenerator();
            System.out.println("\nYour account number is : " + b.accNo +"\n");
        }
        System.out.println("\nSaving your data in the file : \n");
            try{
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write(b.Name);
            myWriter.write(b.phoneNo);
            myWriter.write(b.address);
            myWriter.write(String.valueOf(b.accNo)); //type conversion (Double -> String)
            myWriter.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
