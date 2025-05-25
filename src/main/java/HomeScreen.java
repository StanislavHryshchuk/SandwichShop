import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeScreen {
    private static Scanner scanner = new Scanner(System.in);

    public void display() {

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
                    break;

            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }



}



