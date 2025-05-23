import java.util.List;
import java.util.Scanner;

public class HomeScreen {
    private static Scanner scanner = new Scanner(System.in);

    public void homeScreen(){

        System.out.println("\n*** Home Screen ***");

        System.out.println("""
                1. New Order
                2. Exit""");
        try {
            int userChoice = Integer.parseInt(scanner.nextLine());

            switch (userChoice) {
                case 1 :
                    addOreder();
                    break;
                case 2:
                    break;

            }
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }

    public void addOrder (){
        System.out.println("""
                What you wold like to add to your Order:
                1. Sandwich
                2. Drink
                3. Chips""");
        try {
            int userChoice = Integer.parseInt(scanner.nextLine().trim());

           switch (userChoice){
               case 1: addSandwich();

                   break;
            }
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {


    }
    public Sandwich addSandwich(){

        // Bread Prompts
        System.out.println("What Bread size you would like? (4', 8', 12')");
        int userBreadSize = Integer.parseInt(scanner.nextLine().trim());

        BreadSize size = BreadSize.fromInput(userBreadSize);
        System.out.println("You chose: " + size + "\nPrice: $" + size.getPrice());

        System.out.println("What type of bread you would like? (White, Wheat, Rye, Wrap)");
        String userBreadType = scanner.nextLine().trim().replaceAll("\\s{2,}", " ");



        //Topping prompt
        System.out.println("What topping you would like to add first:\n1. Meat Toppings.\n2. Cheese Toppings.\n3. Regular Toppings.");
        int userToppingSelect = Integer.parseInt(scanner.nextLine().trim());

        if (userToppingSelect == 1){

            System.out.println("Please select the meat topping:");
            MeatTopping.meatToppings.stream()
                    .peek(m -> System.out.println(m))
                    .toList();
            String userMeatTopping = scanner.nextLine().trim().replaceAll("\\s{2,}", " ");

            System.out.println("Would you like make it Extra? (yes/no)");
            boolean userMeatExtra =scanner.nextLine().trim().replaceAll("\\s{2,}", " ").equalsIgnoreCase("yes");

        } else if (userToppingSelect == 2){
            System.out.println("Please select the Cheese topping");
            CheeseTopping.namesOfCheese.stream()
                    .peek(c -> System.out.println(c))
                    .toList();

        }

        return null;
    }
}

