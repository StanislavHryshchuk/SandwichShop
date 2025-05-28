import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderBuilder {
    public static Scanner scanner = new Scanner(System.in);

    public static Order createOrder() {
        List<Sandwich> sandwichList = new ArrayList<>();
        List<Drink> drinkList = new ArrayList<>();
        List<Chips> chipsList = new ArrayList<>();

        boolean running = true;
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
                    case 1 -> {
                        System.out.println("How many Sandwiches would you like to order?");
                        int count = Integer.parseInt(scanner.nextLine().trim());

                        for (int i = 1; i <= count; i++) {
                            System.out.println("Sandwich #" + i);
                            Sandwich sandwich = Sandwich.createSandwich();
                            sandwichList.add(sandwich);
                        }
                    }
                    case 2 -> {
                        System.out.println("How many Drinks would you like to order?");
                        int count = Integer.parseInt(scanner.nextLine().trim());

                        for (int i = 1; i <= count; i++) {
                            System.out.println("Drink #" + i);
                            Drink drink = createDrink();
                            drinkList.add(drink);
                        }
                    }
                    case 3 -> {
                        System.out.println("How many Chips would you like to order?");
                        int count = Integer.parseInt(scanner.nextLine().trim());

                        for (int i = 1; i <= count; i++) {
                            System.out.println("Chips #" + i);
                            Chips chips = createChips();
                            chipsList.add(chips);
                        }
                    }
                    case 4 -> {
                        System.out.println("Please select one of our Signature Sandwiches.");
                        SignatureSandwich.signatureSandwichList.forEach(System.out::println);
                        int userSignatureSandwich = Integer.parseInt(scanner.nextLine().trim());

                        switch (userSignatureSandwich){
                            case 1 -> sandwichList.add(bltSandwichOrder());
                            case 2 -> sandwichList.add(pcSteakSandwich());
                        }
                    }
                    case 5 -> {
                        System.out.println("Can I have a name for the order?");
                        String clientName = scanner.nextLine().trim().replaceAll("\\s{2,}", " ");

                        Order order = new Order(clientName, sandwichList, drinkList, chipsList);
                        System.out.println(order);

                        System.out.println("Please verify your Order. (yes/no)");
                        boolean userVerification = scanner.nextLine().trim().equalsIgnoreCase("yes");
                        if (userVerification){
                            return order;
                        }
                    }
                    case 0 -> {
                        running = false;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return null;
    }

    public static Drink createDrink(){
        while (true) {
            System.out.println("Available drinks: ");
            Drink.drinksList.forEach(System.out::println);

            String userDrinkName = scanner.nextLine().trim();
            System.out.println("Please select the size. (S, M, L)");

            String userDrinkSize = scanner.nextLine().trim().toUpperCase();
            if (Drink.drinksList.contains(userDrinkName)){
                return new Drink(userDrinkName,userDrinkSize);
            }else {
                System.out.println("Sorry we don't have this Drink in our menu. Please select from list");
            }
        }
    }

    public static Chips createChips(){
        while (true) {
            System.out.println("Available chips: ");
            Chips.chipsList.forEach(System.out::println);

            String userChipsName = scanner.nextLine().trim();

            if (Chips.chipsList.contains(userChipsName)){
                return new Chips(userChipsName);
            }else {
                System.out.println("Sorry we don't have this Chips in our menu. Please select from list");
            }
        }
    }

    public static Sandwich bltSandwichOrder(){
        Sandwich sandwich = SignatureSandwich.bltSandwich();
        System.out.println(sandwich);
        System.out.println("Would u like to customize it?");
        boolean customizeQuestion = scanner.nextLine().trim().equalsIgnoreCase("yes");

        if(customizeQuestion) {
           return SignatureSandwichCustomize.customizeMenu(sandwich);
        } else {
            return sandwich;
        }
    }

    public static Sandwich pcSteakSandwich(){
        Sandwich sandwich = SignatureSandwich.pcSteakSandwich();
        System.out.println(sandwich);
        System.out.println("Would u like to customize it?");
        boolean customizeQuestion = scanner.nextLine().trim().equalsIgnoreCase("yes");

        if(customizeQuestion) {
            return SignatureSandwichCustomize.customizeMenu(sandwich);
        } else {
            return sandwich;
        }
    }
}