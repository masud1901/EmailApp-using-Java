package App;

import java.util.Random;
import java.util.Scanner;

public class Email {
    public Scanner s = new Scanner(System.in); //  Global Scanner instance

    // Setting variables as private as we don't want to expose'
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private String password;
    int mailCapacity = 500;
    private String alternativeEmail;

//  constructor to receive first name and , last name

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("New Employee:" + firstName + " " + lastName);

    }


    //        Generate  email address from the names
    private String generate_email() {
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + this.department.toLowerCase() + ".com";
    }

    private String setDepartment() {
        System.out.println("Department codes \n1 for Sales \n2 for Accounting \n0 for None.");

        boolean flag = false;
        do {
            System.out.println("Enter Department Code");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    this.department = "Sales";
                    flag = true;
                    break;
                case 2:
                    this.department = "Accounting";
                    flag = true;
                    break;
                case 0:
                    this.department = "None";
                    flag = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (!flag);
        return null;


    }


    //    Generate Random password method
    private String generate_password(int length) {
        Random random = new Random();
        String Capital_characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String special_characters = "!@#$%^&*()_+";
        String Small_characters = "abcdefghijklmnopqrstuvwxyz";
        String values = Capital_characters + numbers + special_characters + Small_characters;


        String password = null;
        for (int i = 0; i < length; i++) {
            password = password + values.charAt(random.nextInt(values.length()));
        }

        return password;
    }

    //    change password method
    public void set_password() {
        boolean flag = false;
        do {
            System.out.println("Do you want to change your password! [y/n]");
            char choice = s.next().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                flag = true;
                System.out.println("Enter new password");
                String temp = s.next();
                if (temp.equals(this.password)) {
                    System.out.println("Enter new password");
                    this.password = s.next();
                    System.out.println("Password changed!");
                } else {
                    System.out.println("Invalid password");
                }
            } else if (choice == 'N' || choice == 'n') {
                flag = true;
                System.out.println("Password changed option cancelled");
            } else {
                System.out.println("Enter Valid Choice");
            }
        } while (!flag);
    }
}