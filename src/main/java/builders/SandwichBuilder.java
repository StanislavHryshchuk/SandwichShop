package builders;
import enums.BreadSize;
import modele.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SandwichBuilder {
    private static Scanner scanner = new Scanner(System.in);

    // Prompt user for bread type and size
    public static Bread breadPrompt() {
        // Bread Prompts
        System.out.println("What Bread size you would like? (4', 8', 12')");
        int userBreadSize = Integer.parseInt(scanner.nextLine().trim());
        BreadSize size = BreadSize.fromInput(userBreadSize);

        System.out.println("What type of bread you would like?");
        Bread.breadNames.forEach(System.out::println);
        String userBreadName = scanner.nextLine().trim().replaceAll("\\s{2,}", " ");

        System.out.println("You chose: " + userBreadName + " " + size.getLabel() +  "\nPrice: $" + size.getPrice());

        return new Bread(userBreadName,size);
    }

    // Prompt user to choose multiple toppings (meat, cheese, regular)
    public static List<Topping> toppingPromptMenu(BreadSize size) {

        //Topping Prompts
        List<Topping> toppingList = new ArrayList<>();

        boolean selectionProcess = true;

        while (selectionProcess) {

            System.out.println("""
                    What topping you would like to add:
                    1. Meat Toppings.
                    2. Cheese Toppings.
                    3. Regular Toppings.
                    4. Back""");
            try {
                int userToppingSelect = Integer.parseInt(scanner.nextLine().trim());
                switch (userToppingSelect) {
                    case 1 -> toppingList.addAll(meatTopping(size));
                    case 2 -> toppingList.addAll(cheeseTopping(size));
                    case 3 -> toppingList.addAll(regularTopping());
                    case 4 -> {
                        System.out.println("Done selecting Toppings");
                        selectionProcess = false;
                    }
                    default -> System.out.println("Wrong input please try again");
                }
            }catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return toppingList;
    }

    // Prompt for meat toppings with option for extra
    public static List<MeatTopping> meatTopping(BreadSize size) {
        List<MeatTopping> meatList = new ArrayList<>();
        while (true) {

            System.out.println("Please select a meat topping (type 'DONE' to go back):");
            MeatTopping.meatToppings.forEach(System.out::println);

            String userMeatTopping = scanner.nextLine().trim().toLowerCase();

            if (userMeatTopping.equals("done")) break;

            if (MeatTopping.meatToppings.contains(userMeatTopping)) {

                System.out.println("Would you like to make it Extra? (yes/no)");
                boolean isExtra = scanner.nextLine().trim().replaceAll("\\s+", "").equalsIgnoreCase("yes");

                MeatTopping meatTopping = new MeatTopping(userMeatTopping, size, isExtra);
                meatList.add(meatTopping);

                System.out.printf("Added: %s$%.2f\n",
                        (isExtra ? "extra " + userMeatTopping + " " : userMeatTopping + " "),
                        meatTopping.getPrice());
            } else {
                System.out.println("Sorry, we don't have this topping.");
            }
        }
        return meatList;
    }

    // Prompt for cheese toppings with extra option
    public static List<CheeseTopping> cheeseTopping (BreadSize size){
        List<CheeseTopping> cheeseList = new ArrayList<>();
        while (true) {
            System.out.println("Please select a Cheese topping (type 'DONE' to go back):");
            CheeseTopping.namesOfCheese.forEach(System.out::println);

            String userCheeseTopping = scanner.nextLine().trim().toLowerCase();

            if(userCheeseTopping.equalsIgnoreCase("done")) break;

            if(CheeseTopping.namesOfCheese.contains(userCheeseTopping)){
                System.out.println("Would you like to make it Extra? (yes/no)");
                boolean isExtra = scanner.nextLine().trim().replaceAll("\\s+", "").equalsIgnoreCase("yes");

                CheeseTopping cheeseTopping = new CheeseTopping(userCheeseTopping, size, isExtra);
                cheeseList.add(cheeseTopping);

                System.out.printf("Added: %s %s $%.2f\n", isExtra ? "extra" : "", userCheeseTopping, cheeseTopping.getPrice());
            }else {
                System.out.println("Sorry, we don't have this topping. Try again.");
            }
        }
        return cheeseList;
    }

    // Prompt for regular toppings
    public static List<RegularTopping> regularTopping(){
        List<RegularTopping> regularToppingList = new ArrayList<>();
        while (true) {
            System.out.println("Please select a Regular topping (type 'DONE' to go back):");
            RegularTopping.regularToppings.forEach(System.out::println);

            String userRegularTopping = scanner.nextLine().trim().toLowerCase();

            if(userRegularTopping.equalsIgnoreCase("done")) break;

            if(RegularTopping.regularToppings.contains(userRegularTopping)){
                RegularTopping regularTopping = new RegularTopping(userRegularTopping);
                regularToppingList.add(regularTopping);

                System.out.printf("Added: %s\n", userRegularTopping);
            }else {
                System.out.println("Sorry, we don't have this topping. Try again.");
            }
        }
        return regularToppingList;
    }

    // Prompt for sauces
    public static List<Sauce> saucesPrompt(){
        List<Sauce> sauceList = new ArrayList<>();
        while (true) {
            System.out.println("Please select a Sauce (type 'DONE' to go back):");
            Sauce.sauces.forEach(System.out::println);

            String userSauce = scanner.nextLine().trim().toLowerCase();

            if(userSauce.equalsIgnoreCase("done")) break;

            if(Sauce.sauces.contains(userSauce)){
                Sauce sauce = new Sauce(userSauce);
                sauceList.add(sauce);
                System.out.printf("Added: %s\n", userSauce);
            } else {
                System.out.println("Sorry we don't have this sauce.");
            }
        }
        return sauceList;
    }

    // Prompt for side items
    public static List<Sides> sidesPrompt(){
        List<Sides> sidesList = new ArrayList<>();
        while (true) {
            System.out.println("Please select a Sides (type 'DONE' to go back):");
            Sides.sides.forEach(System.out::println);

            String userSide = scanner.nextLine().trim().toLowerCase();

            if(userSide.equalsIgnoreCase("done")) break;

            if(Sides.sides.contains(userSide)){
                Sides side = new Sides(userSide);
                sidesList.add(side);
                System.out.printf("Added: %s\n", userSide);
            } else {
                System.out.println("Sorry we don't have this side");
            }
        }
        return sidesList;
    }

    // Build multiple sandwiches through repeated prompts
    public static List<Sandwich> createSandwiches(){

        List<Sandwich> sandwiches = new ArrayList<>();

        System.out.println("How many Sandwiches would you like to order?");
        int count = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 1; i <= count; i++) {
            System.out.println("modele.Sandwich #" + i);

            Bread bread = breadPrompt();
            List<Topping> toppings =  toppingPromptMenu(bread.getSize());
            List<Sauce> sauces = saucesPrompt();
            List<Sides> sides =  sidesPrompt();

            System.out.println("Would you like it toasted?");

            boolean toasted = scanner.nextLine().trim().equalsIgnoreCase("yes");

            Sandwich sandwich = new Sandwich(bread.getName(),bread.getSize(),toppings,sauces,sides,toasted);
            sandwiches.add(sandwich);
        }
        return sandwiches;
    }
}