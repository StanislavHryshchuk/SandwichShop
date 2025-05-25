
import java.util.Scanner;

public class HomeScreen {
    private static Scanner scanner = new Scanner(System.in);

    public void display() {
        boolean running = true;
        while (running){
            System.out.println("\n*** Home Screen ***");

            System.out.println("""
                1. New Order
                2. Exit""");
            try {
                int userChoice = Integer.parseInt(scanner.nextLine());

                switch (userChoice) {
                    case 1:
                        System.out.println(Order.createOrder());
                        break;
                    case 2:
                        System.out.println("Thank you! Bye.");
                        break;

                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}