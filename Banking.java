import java.io.*;
import java.util.*;


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
    boolean userVerified = userVerify();

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
    boolean userVerify() {
        System.out.println("Enter your username: \n");
        inp_username = myScan.nextLine();
        System.out.println("Enter your password : \n");
        inp_password = myScan.nextLine();
        if (inp_username.equals(userName[0]) && inp_password.equals(password[0])
        || inp_username.equals(userName[1]) && inp_password.equals(password[1])
        || inp_username.equals(userName[2]) && inp_password.equals(password[2])
        || inp_username.equals(userName[3]) && inp_password.equals(password[3])
        || inp_username.equals(userName[4]) && inp_password.equals(password[4])){
        return true;
        } 
        else{
        return false;
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
        Banking b = new Banking();
        //infinite loop to keep the program running 
        while (true){
            b.userVerify();
        }
    }
}
