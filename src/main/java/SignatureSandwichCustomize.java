import java.util.List;
import java.util.Scanner;

public class SignatureSandwichCustomize {
    private static Scanner scanner = new Scanner(System.in);

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

                switch (userChoice){
                    case 1 -> {
                        Bread bread = SandwichBuilder.breadPrompt();
                        sandwich.setBreadName(bread.getName());
                        sandwich.setBreadSize(bread.getSize());
                    }
                    case 2 -> {
                        boolean addRemoveRunning = true;
                        while (addRemoveRunning){
                            System.out.println("""
                                1. Add
                                2. Remove
                                3. Back""");
                            int userAddRemove = Integer.parseInt(scanner.nextLine().trim());
                            switch (userAddRemove){
                                case 1 -> sandwich.getToppings().addAll(SandwichBuilder.toppingPrompt(sandwich.getBreadSize()));
                                case 2 -> removeTopping(sandwich.getToppings());
                                case 3 -> addRemoveRunning = false;
                                default -> System.out.println("Wrong input. Try again");
                            }
                        }
                    }
                    case 3 -> {
                        System.out.println("Current sandwich:\n" + sandwich);
                        System.out.println("Confirm all customizations? (yes/no)");
                        boolean confirm = scanner.nextLine().trim().equalsIgnoreCase("yes");
                        if (confirm){
                            customizeMenuRunning = false;
                            return sandwich;
                        } else {
                            System.out.println("Returning to customization menu...");
                        }
                    }
                    default -> System.out.println("Wrong input. Try again");
                }
            }
        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
        return sandwich;
    }

    public static List<Topping> removeTopping (List<Topping> toppings){

        while (true){
            System.out.println("Which topping u would like to remove? Type 'DONE' to go back");
            toppings.forEach(System.out::println);

            String userRemoveTopping = scanner.nextLine().trim().toLowerCase();

            if (userRemoveTopping.equalsIgnoreCase("done")) break;

            boolean removed = toppings.removeIf(t -> t.getName().equalsIgnoreCase(userRemoveTopping));

            if (removed){
                System.out.println("Topping is removed");
            } else{
                System.out.println("No matching topping found");
            }
        }
        return toppings;
    }
}