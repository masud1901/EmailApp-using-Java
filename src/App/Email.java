package App;

import java.util.Random;
import java.util.Scanner;

public class Email {
    public Scanner s = new Scanner(System.in); //  Global Scanner instance

    // Setting variables as private as we don't want to expose'
    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private String department;
    private String password;
    int mailCapacity = 500;
    private String alternativeEmail;

    //  constructor to receive first name and , last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("New Employee:" + firstName + " " + lastName);

//      Calling methods
        this.department = this.setDepartment();
        this.emailAddress = this.generateEmail();
        this.password = this.generatePassword();

    }


    //        Generate  email address from the names
    private String generateEmail() {
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + this.department.toLowerCase() + ".com";
    }

    private String setDepartment() {
        String[] departments = {"Sales", "Accounting", "HR", "None"};
        int choice;

        do {
            System.out.println("Department codes:");
            for (int i = 0; i < departments.length; i++) {
                System.out.println((i + 1) + " for " + departments[i]);
            }

            System.out.print("Enter Department Code: ");
            choice = s.nextInt();

            if (choice >= 1 && choice <= departments.length) {
                this.department = departments[choice - 1];
                return this.department;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        } while (true);
    }

    //    Generate Random password method
    private String generatePassword() {
        Random random = new Random();
        String capitalCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*()_+";
        String smallCharecters = "abcdefghijklmnopqrstuvwxyz";
        String values = capitalCharacters + numbers + specialCharacters + smallCharecters;


        StringBuilder passwordString = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            passwordString.append(values.charAt(random.nextInt(values.length())));
        }
        return passwordString.toString();
    }

    //    change password method
    public void changePassword() {
        System.out.println("Do you want to change your password? [y/n]");
        char choice = s.next().toLowerCase().charAt(0);

        switch (choice) {
            case 'y':
                System.out.print("Enter current password: ");
                String currentPassword = s.next();
                if (currentPassword.equals(this.password)) {
                    System.out.print("Enter new password: ");
                    this.password = s.next();
                    System.out.println("Password changed successfully!");
                } else {
                    System.out.println("Invalid password. Password not changed.");
                }
                break;
            case 'n':
                System.out.println("Password change canceled.");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

//    set mailbox capacity method

    public void changeMailboxCapacity() {
        System.out.println("Current capacity is " + this.mailCapacity + "mb");
        System.out.println("Enter new mailbox capacity:");
        this.mailCapacity = s.nextInt();
        System.out.println("Mailbox capacity is successfully changed to " + this.mailCapacity);
    }

    //    set alternative mail
    public void setAlternateEmail() {
        System.out.println("Enter alternative email");
        this.alternativeEmail = s.next();
        System.out.println("Alternative email is successfully changed to " + this.alternativeEmail);
    }

    //    Display user information method
    public void showInfo() {
        System.out.println("Name: " + this.firstName + " " + this.lastName);
        System.out.println("Department: " + this.department);
        System.out.println("Email: " + this.emailAddress);
        System.out.println("Password: " + this.password);
        System.out.println("Mail Capacity: " + this.mailCapacity);
        System.out.println("Alternate Email: " + this.alternativeEmail);
    }

}