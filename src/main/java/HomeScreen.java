import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeScreen {
    private static Scanner scanner = new Scanner(System.in);

    public void homeScreen() {

        System.out.println("\n*** Home Screen ***");

        System.out.println("""
                1. New Order
                2. Exit""");
        try {
            int userChoice = Integer.parseInt(scanner.nextLine());

            switch (userChoice) {
                case 1:
//                    addOreder();
                    break;
                case 2:
                    break;

            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addOrder() {
        System.out.println("""
                What you would like to add to your Order:
                1. Sandwich
                2. Drink
                3. Chips
                4. Checkout""");
        try {
            int userChoice = Integer.parseInt(scanner.nextLine().trim());

            switch (userChoice) {
                case 1: //addSandwich();

                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }


    public Bread breadPrompt() {
        // Bread Prompts
        System.out.println("What Bread size you would like? (4', 8', 12')");
        int userBreadSize = Integer.parseInt(scanner.nextLine().trim());
        BreadSize size = BreadSize.fromInput(userBreadSize);


        System.out.println("What type of bread you would like? (White, Wheat, Rye, Wrap)");
        String userBreadName = scanner.nextLine().trim().replaceAll("\\s{2,}", " ");

        System.out.println("You chose: " + size + " " + userBreadName + "\nPrice: $" + size.getPrice());
        System.out.println("Would you like it Toasted? (yes/no)");


        Bread bread = new Bread(userBreadName,size.getLabel(),size.getPrice());

        toppingPrompt(size);
        return bread;
    }

    public List<Topping> toppingPrompt(BreadSize size) {

        //Topping prompt
        List<Topping> toppings = new ArrayList<>();

        System.out.println("What topping you would like to add first:\n1. Meat Toppings.\n2. Cheese Toppings.\n3. Regular Toppings.");

        int userToppingSelect = Integer.parseInt(scanner.nextLine().trim());
        boolean selectionProcess = true;

        while (selectionProcess) {
            switch (userToppingSelect) {
                case 1 -> meatTopping(toppings,size);
                case 2 -> cheeseTopping(toppings,size);
                case 3 -> regularTopping(toppings);
                default -> System.out.println("Wrong input please try again");
            }
        }
        return toppings;
    }


    public void meatTopping(List<Topping> toppings, BreadSize size) {
        while (true) {
            System.out.println("Please select a meat topping (type 'DONE' to go back):");
            MeatTopping.meatToppings.forEach(System.out::println);

            String userMeatTopping = scanner.nextLine().trim().toLowerCase();

            if (userMeatTopping.equals("done")) break;

            if (MeatTopping.meatToppings.contains(userMeatTopping)) {
                System.out.println("Would you like to make it Extra? (yes/no)");
                boolean isExtra = scanner.nextLine().trim().replaceAll("\\s+", "").equalsIgnoreCase("yes");

                Topping meatTopping = new MeatTopping(userMeatTopping, size, isExtra);
                toppings.add(meatTopping);

                System.out.printf("Added: %s$%.2f\n",
                        (isExtra ? "extra " + userMeatTopping + " " : userMeatTopping + " "),
                        meatTopping.getPrice());
            } else {
                System.out.println("Sorry, we don't have this topping. Try again.");
            }

        }


    }
    public void cheeseTopping (List<Topping> toppings, BreadSize size){
        while (true) {
            System.out.println("Please select a Cheese topping (type 'DONE' to go back):");
            CheeseTopping.namesOfCheese.forEach(System.out::println);

            String userCheeseTopping = scanner.nextLine().trim().toLowerCase();

            if(userCheeseTopping.equalsIgnoreCase("done")) break;

            if(CheeseTopping.namesOfCheese.contains(userCheeseTopping)){
                System.out.println("Would you like to make it Extra? (yes/no)");
                boolean isExtra = scanner.nextLine().trim().replaceAll("\\s+", "").equalsIgnoreCase("yes");

                Topping cheeseTopping = new CheeseTopping(userCheeseTopping, size, isExtra);
                toppings.add(cheeseTopping);

                System.out.printf("Added: %s %s $%.2f\n", isExtra ? "extra" : "", userCheeseTopping, cheeseTopping.getPrice());
            }
        }
    }

    public void regularTopping(List<Topping> toppings){
        while (true) {
            System.out.println("Please select a Regular topping (type 'DONE' to go back):");
           RegularTopping.regularToppings.forEach(System.out::println);

            String userRegularTopping = scanner.nextLine().trim().toLowerCase();

            if(userRegularTopping.equalsIgnoreCase("done")) break;

            if(RegularTopping.regularToppings.contains(userRegularTopping)){
                Topping regularTopping = new RegularTopping(userRegularTopping);
                toppings.add(regularTopping);

                System.out.printf("Added: %s", userRegularTopping);
            }
        }
    }

    public static void main(String[] args) {

    }



}



