package ui;
import builders.OrderBuilder;
import filemanager.ReceiptFileManager;
import modele.Order;
import java.util.Scanner;

public class HomeScreen {
    private static Scanner scanner = new Scanner(System.in);

    public void display() {
        boolean running = true;
        // ui.Main Loop
        while (running){
            System.out.println("\n*** Home Screen ***");

            System.out.println("""
                1. New Order
                2. Exit""");
            try {
                int userChoice = Integer.parseInt(scanner.nextLine());

                switch (userChoice) {
                    case 1:
                        OrderBuilder.orderMenu();
                        break;
                    case 2:
                        System.out.println("Thank you! Bye.");
                        running = false;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}