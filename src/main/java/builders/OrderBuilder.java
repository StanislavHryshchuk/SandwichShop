package builders;
import modele.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderBuilder {
    public static Scanner scanner = new Scanner(System.in);

    // Entry point to create a complete order
    public static Order createOrder() {
        List<Sandwich> sandwichList = new ArrayList<>();
        List<Drink> drinkList = new ArrayList<>();
        List<Chips> chipsList = new ArrayList<>();
        Order finalOrder = null;

        boolean running = true;
        // Order Builder Loop
        while (running) {
            System.out.println("""
                    What would you like to add to your Order:
                    1. Sandwich.
                    2. Drink.
                    3. Chips.
                    4. Signature Sandwiches.
                    5. Checkout
                    0. Cancel Order""");

            try {
                int userChoice = Integer.parseInt(scanner.nextLine().trim());

                switch (userChoice) {
                    case 1 -> sandwichList.addAll(SandwichBuilder.createSandwiches()); // Add custom sandwiches
                    case 2 -> drinkList.addAll(createDrinkList());                     // Add drinks
                    case 3 -> chipsList.addAll(createChipsList());                     // Add chips
                    case 4 -> signatureSandwichSelection(sandwichList);                   // Add signature sandwich
                    case 5 -> {                                                           // Checkout
                            finalOrder = checkOut(sandwichList, drinkList, chipsList);
                            if (finalOrder != null){
                                running = false;
                            }
                    }
                    case 0 -> {
                        System.out.println("Order Canceled");
                        running = false;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return finalOrder;
    }
    // Create a list of drinks
    public static List<Drink> createDrinkList() {

        List<Drink> drinkList = new ArrayList<>();

        System.out.println("How many Drinks would you like to order?");
        int count = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 1; i <= count; i++) {
            System.out.println("Drink #" + i);

            System.out.println("Available drinks: ");
            Drink.drinksList.forEach(System.out::println);

            String userDrinkName = scanner.nextLine().trim();
            System.out.println("Please select the size. (S, M, L)");

            String userDrinkSize = scanner.nextLine().trim();

            if (Drink.drinksList.contains(userDrinkName)) {
                Drink drink = new Drink(userDrinkName, userDrinkSize);
                drinkList.add(drink);
            } else {
                System.out.println("Sorry we don't have this Drink in our menu. Please select from list");
            }
        }
        return drinkList;
    }
    // Create a list of Chips
    public static List<Chips> createChipsList() {

        List<Chips> chipsList = new ArrayList<>();

        System.out.println("How many Chips would you like to order?");
        int count = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 1; i <= count; i++) {
            System.out.println("Chips #" + i);

            System.out.println("Available chips:");
            Chips.chipsList.forEach(System.out::println);

            String userChipsName = scanner.nextLine().trim();

            if (Chips.chipsList.contains(userChipsName)) {
                Chips chip = new Chips(userChipsName);
                chipsList.add(chip);
            } else {
                System.out.println("Sorry we don't have this Chips in our menu. Please select from list");
            }
        }
        return chipsList;
    }
    // Select a signature sandwich
    public static void signatureSandwichSelection(List<Sandwich>sandwichList){
        System.out.println("Please select one of our Signature Sandwiches.");
        SignatureSandwich.signatureSandwichList.forEach(System.out::println);
        int userSignatureSandwich = Integer.parseInt(scanner.nextLine().trim());

        switch (userSignatureSandwich) {
            case 1 -> sandwichList.add(bltSandwichOrder());
            case 2 -> sandwichList.add(pcSteakSandwich());
            default -> System.out.println("Invalid input. Please choose a valid option.");
        }
    }
    // BLT signature sandwich customization
    public static Sandwich bltSandwichOrder() {
        Sandwich sandwich = SignatureSandwich.bltSandwich();
        System.out.println(sandwich);
        System.out.println("Would you like to customize it?");
        boolean customizeQuestion = scanner.nextLine().trim().equalsIgnoreCase("yes");

        if (customizeQuestion) {
            return SignatureSandwichCustomize.customizeMenu(sandwich);
        } else {
            return sandwich;
        }
    }
    // Philly Cheese Steak signature sandwich customization
    public static Sandwich pcSteakSandwich() {
        Sandwich sandwich = SignatureSandwich.pcSteakSandwich();
        System.out.println(sandwich);
        System.out.println("Would you like to customize it?");
        boolean customizeQuestion = scanner.nextLine().trim().equalsIgnoreCase("yes");

        if (customizeQuestion) {
            return SignatureSandwichCustomize.customizeMenu(sandwich);
        } else {
            return sandwich;
        }
    }
    // Finalize order after confirmation
    public static Order checkOut(List<Sandwich> sandwichList, List<Drink> drinkList, List<Chips> chipsList) {
        System.out.println("Can I have a name for the order?");
        String clientName = scanner.nextLine().trim().replaceAll("\\s{2,}", " ");

        Order order = new Order(clientName, sandwichList, drinkList, chipsList);
        System.out.println(order);

        System.out.println("Please verify your Order. (yes/no)");
        boolean userVerification = scanner.nextLine().trim().equalsIgnoreCase("yes");
        if (userVerification) {
            return order;
        } else {
            System.out.println("Going back to Menu");
            return null;
        }
    }
}