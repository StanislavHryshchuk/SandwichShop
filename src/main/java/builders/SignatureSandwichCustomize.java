package builders;

import modele.Bread;
import modele.Sandwich;
import modele.Topping;

import java.util.List;
import java.util.Scanner;

public class SignatureSandwichCustomize {
    private static Scanner scanner = new Scanner(System.in);

    // ui.Main customization menu for a given sandwich
    public static Sandwich customizeMenu(Sandwich sandwich){
        boolean customizeMenuRunning = true;
        try{
            while (customizeMenuRunning){
                System.out.println("What would you like to customize?");
                System.out.println("""
                        1. Bread. (size, type)
                        2. Toppings.
                        3. Finish Customize.""");

                int userChoice = Integer.parseInt(scanner.nextLine().trim());
                try{
                    switch (userChoice){
                        case 1 -> {                                             // Update Bread Selection
                            Bread bread = SandwichBuilder.breadPrompt();
                            sandwich.setBreadName(bread.getName());
                            sandwich.setBreadSize(bread.getSize());
                        }
                        case 2 -> toppingHandlingInCustomizeMenu(sandwich);     // Launch add/remove menu
                        case 3 -> {                                             // Finalize customization after confirmation
                            if (confirmCustomization(sandwich)) {
                                customizeMenuRunning = false;
                            } else {
                                System.out.println("Returning to customization menu...");
                            }
                        }
                        default -> System.out.println("Wrong input. Try again");
                    }
                } catch (NumberFormatException e){
                    System.out.println(e.getMessage());
                }
            }
        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
        return sandwich;
    }

    // Allow user to remove toppings from sandwich
    public static void removeTopping(List<Topping> toppings){

        while (true){
            System.out.println("Which topping you would like to remove? (Type 'DONE' to go back)");
            toppings.forEach(System.out::println);

            String userRemoveTopping = scanner.nextLine().trim().toLowerCase();

            if (userRemoveTopping.equalsIgnoreCase("done")) break;

            boolean removed = toppings.removeIf(t -> t.getName().equalsIgnoreCase(userRemoveTopping));

            if (removed){
                System.out.println("modele.Topping removed.");
            } else{
                System.out.println("No matching topping found.");
            }
        }
    }

    // Add or remove toppings during customization
    public static void toppingHandlingInCustomizeMenu(Sandwich sandwich) {
        boolean addRemoveRunning = true;
        while (addRemoveRunning){
            System.out.println("""
                    1. Add
                    2. Remove
                    3. Back""");
            int userAddRemove = Integer.parseInt(scanner.nextLine().trim());
            switch (userAddRemove){
                // Add new toppings using same Bread size
                case 1 -> sandwich.getToppings().addAll(SandwichBuilder.toppingPromptMenu(sandwich.getBreadSize()));
                // Remove toppings by Name
                case 2 -> removeTopping(sandwich.getToppings());
                case 3 -> addRemoveRunning = false;
                default -> System.out.println("Wrong input. Try again");
            }
        }
    }

    // Show summary and confirm final sandwich
    public static boolean confirmCustomization(Sandwich sandwich){
        System.out.println("Current sandwich:\n" + sandwich);
        System.out.println("Confirm all customizations? (yes/no)");
        return scanner.nextLine().trim().equalsIgnoreCase("yes");
    }
}