package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Money userAccount = new Money(10.0);
        CoffeMachine machine = new CoffeMachine();
        machine.addCoffe(new Coffe("Espresso", 2.5, 5));
        machine.addCoffe(new Coffe("Latte", 3.0, 0));
        machine.addCoffe(new Coffe("Cappuccino", 3.5, 2));

        try (Scanner scanner = new Scanner(System.in)) {
            try {
                System.out.println("Welcome to the Coffe Machine!");
                System.out.println("Your balance: $" + userAccount.getBalance());

                System.out.print("Enter coffe name: ");
                String coffeName = scanner.nextLine();

                Coffe selectedCoffe = machine.selectCoffe(coffeName);

                System.out.println("Selected: " + selectedCoffe.getName() + " ($" + selectedCoffe.getPrice() + ")");
                System.out.print("Proceed to pay? (yes/no): ");
                String pay = scanner.nextLine();
                if (!pay.equalsIgnoreCase("yes")) {
                    System.out.println("Payment cancelled.");
                    return;
                }

                Coffe servedCoffe = machine.prepareCoffe(selectedCoffe, userAccount);
                System.out.println("✅ Enjoy your " + servedCoffe.getName() + "!");
                System.out.println("Remaining balance: $" + userAccount.getBalance());
            } catch (CoffeMachineException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}