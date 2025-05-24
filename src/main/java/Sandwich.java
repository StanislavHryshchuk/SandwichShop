import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sandwich {
    private static Scanner scanner = new Scanner(System.in);
    private String breadName;
    private BreadSize breadSize;
    private List<Topping> toppings;
    private List<Sauce> sauces;
    private List<Sides> sides;
    private boolean toasted;

    public Sandwich(String breadName, BreadSize breadSize, List<Topping> toppings, List<Sauce> sauces, List<Sides> sides, boolean toasted) {
        this.breadName = breadName;
        this.breadSize = breadSize;
        this.toppings = toppings;
        this.sides = sides;
        this.toasted = toasted;
        this.sauces = sauces;
    }
    public Sandwich(){};

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public String getBreadType() {
        return breadName;
    }

    public void setBreadType(String breadType) {
        this.breadName = breadType;
    }

    public BreadSize getBreadSize() {
        return breadSize;
    }

    public void setBreadSize(BreadSize breadSize) {
        this.breadSize = breadSize;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }


    public Sandwich createSandwich () {

        Bread bread = breadPrompt();

        System.out.println("Would you like it toasted?");

        boolean toasted = scanner.nextLine().trim().equalsIgnoreCase("yes");

        toppingPrompt(bread.getSize());
        saucesPrompt();
        sidesPrompt();


        return new Sandwich(bread.getName(),bread.getSize(),this.toppings,this.sauces,this.sides,toasted);

    }

    public Bread breadPrompt() {
        // Bread Prompts
        System.out.println("What Bread size you would like? (4', 8', 12')");
        int userBreadSize = Integer.parseInt(scanner.nextLine().trim());
        BreadSize size = BreadSize.fromInput(userBreadSize);

        System.out.println("What type of bread you would like? (White, Wheat, Rye, Wrap)");
        String userBreadName = scanner.nextLine().trim().replaceAll("\\s{2,}", " ");

        System.out.println("You chose: " + size + " " + userBreadName + "\nPrice: $" + size.getPrice());

        Bread bread = new Bread(userBreadName,size);

        toppingPrompt(size);
        return bread;
    }

    public void toppingPrompt(BreadSize size) {

        //Topping prompt
        this.toppings = new ArrayList<>();

        boolean selectionProcess = true;

        while (selectionProcess) {

            System.out.println("What topping you would like to add first:\n1. Meat Toppings.\n2. Cheese Toppings.\n3. Regular Toppings.\n4. Select Sauce.\n5. Back");

            int userToppingSelect = Integer.parseInt(scanner.nextLine().trim());

            switch (userToppingSelect) {
                case 1 -> meatTopping(toppings,size);
                case 2 -> cheeseTopping(toppings,size);
                case 3 -> regularTopping(toppings);
                case 4 -> saucesPrompt();
                case 5 -> selectionProcess = false;
                default -> System.out.println("Wrong input please try again");
            }
        }
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
                this.toppings.add(meatTopping);

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
                this.toppings.add(cheeseTopping);

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
                this.toppings.add(regularTopping);

                System.out.printf("Added: %s", userRegularTopping);
            }
        }
    }

    public void saucesPrompt(){

        this.sauces = new ArrayList<>();

        while (true) {
            System.out.println("Please select a Sauce (type 'DONE' to go back):");
            Sauce.sauces.forEach(System.out::println);

            String userSauce = scanner.nextLine().trim().toLowerCase();

            if(userSauce.equalsIgnoreCase("done")) break;

            if(Sauce.sauces.contains(userSauce)){
                Sauce sauce = new Sauce(userSauce);
                this.sauces.add(sauce);
                System.out.printf("Added: %s", userSauce);
            }
        }
    }

    public void sidesPrompt(){
        while (true) {
            System.out.println("Please select a Sides (type 'DONE' to go back):");
            Sides.sides.forEach(System.out::println);

            String userSide = scanner.nextLine().trim().toLowerCase();

            if(userSide.equalsIgnoreCase("done")) break;

            if(Sides.sides.contains(userSide)){
                Sides side = new Sides(userSide);
                this.sides.add(side);
                System.out.printf("Added: %s", userSide);
            }
        }
    }

    @Override
    public String toString() {
        return """
        --- Sandwich Summary ---
        Bread: %s (%s) %s
        Toppings: %s
        Sauces: %s
        """.formatted(
                breadName,
                breadSize.getLabel(),
                toasted ? "Toasted" : "Not Toasted",
                toppings,
                sauces
        );
    }

}
