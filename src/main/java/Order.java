import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    public static Scanner scanner = new Scanner(System.in);

    private String name = LocalDateTime.now().toString();
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;
    private double orderPrice;

    public Order(){};

    public Order(String name, List<Sandwich> sandwiches, List<Drink> drinks, List<Chips> chips) {
        this.name = name;
        this.sandwiches = sandwiches;
        this.drinks = drinks;
        this.chips = chips;
        this.orderPrice = getPrice();
    }

    public Order createOrder() {
        List<Sandwich> sandwichList = new ArrayList<>();
        List<Drink> drinkList = new ArrayList<>();
        List<Chips> chipsList = new ArrayList<>();

        while (true) {
            System.out.println("""
            What would you like to add to your Order:
            1. Sandwich.
            2. Drink.
            3. Chips.
            4. Checkout""");

            try {
                int userChoice = Integer.parseInt(scanner.nextLine().trim());

                switch (userChoice) {
                    case 1 -> {
                        System.out.println("How many Sandwiches would you like to order?");
                        int count = Integer.parseInt(scanner.nextLine().trim());

                        for (int i = 1; i <= count; i++) {
                            System.out.println("Creating Sandwich #" + i);
                            Sandwich sandwich = new Sandwich().createSandwich();
                            sandwichList.add(sandwich);
                        }
                    }
                    case 2 -> {
                        System.out.println("How many Drinks would you like to order?");
                        int count = Integer.parseInt(scanner.nextLine().trim());

                        for (int i = 1; i <= count; i++) {
                            System.out.println("Drink #" + i);
                            Drink drink = new Drink().createDrink();
                            drinkList.add(drink);
                        }
                    }
                    case 3 -> {
                        System.out.println("How many Chips would you like to order?");
                        int count = Integer.parseInt(scanner.nextLine().trim());

                        for (int i = 1; i <= count; i++) {
                            System.out.println("Chips #" + i);
                            Chips chips = new Chips().createChips();
                            chipsList.add(chips);
                        }
                    }
                    case 4 -> {
                        System.out.println("Can I have a name for the order?");
                        String clientName = scanner.nextLine().trim().replaceAll("\\s{2,}", " ");
                        return new Order(clientName, sandwichList, drinkList, chipsList);
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public double getPrice(){
        double totalCost = 0.0;

        if(sandwiches != null){
            for(Sandwich sandwich : sandwiches){
                totalCost += sandwich.getPrice();
            }
        }
        if (drinks != null){
            for(Drink drink : drinks){
                totalCost += drink.getPrice();
            }
        }
        if (chips != null){
            for(Chips c: chips){
                totalCost += c.getPrice();
            }
        }
        return totalCost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== Order Summary ===\n");
        sb.append("Order for: ").append(name);

        if (sandwiches != null && !sandwiches.isEmpty()) {
            sb.append("\t\nSandwich:\n");
            for (Sandwich s : sandwiches) {
                sb.append(s).append("\n");
            }
        }
        if (drinks != null && !drinks.isEmpty()) {
            sb.append("Drinks:\n");
            for (Drink d : drinks) {
                sb.append("\t").append(d).append("\n");
            }
        }
        if (chips != null && !chips.isEmpty()){
            sb.append(("Chips:\n"));
            for (Chips c : chips){
                sb.append("\t").append(c).append("\n");
            }
        }
        sb.append("===================\n");
        sb.append(String.format("Total order cost: $%.2f", getPrice()));

        sb.append("\nThank you for your order!\n");
        return sb.toString();
    }
}
