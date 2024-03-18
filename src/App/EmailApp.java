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
            System.out.println("\n******\nEnter your choice\n1. Show Info\n2. Change Password\n3. Change Mailbox Capacity\n4. Set Alternate Email\n5. Exit");
            System.out.print("Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline character

            switch (choice) {
                case 1:
                    emailOne.showInfo();
                    break;
                case 2:
                    emailOne.changePassword();
                    break;
                case 3:
                    emailOne.changeMailboxCapacity();
                    break;
                case 4:
                    emailOne.setAlternateEmail();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }
}
