
import java.util.List;
import java.util.Scanner;

public class Drink {
    private static Scanner scanner = new Scanner(System.in);

    private String name;
    private double price;
    private String size;
    public static List<String> drinks = List.of(
            "Cola",
            "Pepsi",
            "Dr.Pepper",
            "Fanta",
            "Juice");

    public Drink(){};

    public Drink(String name, String size) {
        this.name = name;
        this.size = size;
        this.price = getPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        if (size.equalsIgnoreCase("L")){
            return 3.00;
        } else if (size.equalsIgnoreCase("M")) {
            return 2.5;
        } else return 2.0;

    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Drink createDrink(){
        while (true) {
            System.out.println("Available drinks: ");
            drinks.forEach(System.out::println);

            String userDrinkName = scanner.nextLine().trim();
            System.out.println("Please select the size. (S, M, L)");

            String userDrinkSize = scanner.nextLine().trim().toUpperCase();
            if (drinks.contains(userDrinkName)){
                return new Drink(userDrinkName,userDrinkSize);
            }else {
                System.out.println("Sorry we don't have this Drink in our menu. Please select from list");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s (%s)" + " - $%.2f", name,size,price);
    }
}