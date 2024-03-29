package App;

import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User info
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        // Creating object for Email class
        Email emailOne = new Email(firstName, lastName);
        int choice;

        do {
            System.out.println("\n******\nEnter your choice\n1. Show Info\n2. Change Password\n3. Change Mailbox Capacity\n4. Set Alternate Email\n5.Store Data in File\n6.Display Data from File\n7.Exit");
            System.out.print("Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline character

            switch (choice) {
                case 1 -> emailOne.showInfo();
                case 2 -> emailOne.changePassword();
                case 3 -> emailOne.changeMailboxCapacity();
                case 4 -> emailOne.setAlternateEmail();
                case 5 -> emailOne.storeInFile();
                case 6 -> emailOne.readFile();
                case 7 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
