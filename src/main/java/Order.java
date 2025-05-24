import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    public static Scanner scanner = new Scanner(System.in);

    private String name = LocalDateTime.now().toString();
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Sauce> sauces;

    public Order(String name, List<Sandwich> sandwiches, List<Drink> drinks, List<Sauce> sauces) {
        this.name = name;
        this.sandwiches = sandwiches;
        this.drinks = drinks;
        this.sauces = sauces;
    }

    public static Order createOrder(){

        List<Sandwich> sandwichList = new ArrayList<>();
        List<Drink> drinkList = new ArrayList<>();
        List<Chips> chipsList = new ArrayList<>();


        System.out.println("""
            What you would like to add to your Order:
            1. Sandwich
            2. Drink
            3. Chips
            4. Checkout""");
        try {
            int userChoice = Integer.parseInt(scanner.nextLine().trim());

            switch (userChoice) {
                case 1:
                    System.out.println("How many Sandwiches you would like to order?");
                    int userSandwichQuantity = Integer.parseInt(scanner.nextLine().trim());

                    for (int i = 1; i <= userSandwichQuantity; i++) {
                        System.out.println("Creating Sandwich #" + i);
                        Sandwich sandwich = new Sandwich().createSandwich();
                        sandwichList.add(sandwich);
                    }
                    break;
                case 2:
                    System.out.println("How many Drinks you would like to order?");
                    int userDrinkQuantity = Integer.parseInt(scanner.nextLine().trim());

                    for (int i = 1; i <= userDrinkQuantity; i++) {
                        Drink.drinks.forEach(System.out::println);
                        System.out.println("Drink #" + i);

                        Drink drink = new Drink().createDrink();
                        drinkList.add(drink);
                    }
                    break;
                case 3:
                    System.out.println("Would you like to add Chips?");
                    int userChipsQuantity = Integer.parseInt(scanner.nextLine().trim());

                    break;
            }

        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return new Order()
    }
}
