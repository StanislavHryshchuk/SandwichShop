import java.util.List;

public class Chips {
    private String name;
    private double price;
    public static List<String> chips = List.of(
            "Pringles",
            "Lays",
            "Cheetos",
            "Doritos");


    public Chips(){};

    public Chips(String name) {
        this.name = name;
        this.price = 1.50;
    }

    public Chips createChips(){
        while (true) {
            System.out.println("Available chips: ");
            chips.forEach(System.out::println);

            String userChipsName = Order.scanner.nextLine().trim();

            if (chips.contains(userChipsName)){
                return new Chips(userChipsName);
            }else {
                System.out.println("Sorry we don't have this Chips in our menu. Please select from list");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s - $%.2f", name,price)  ;
    }

}
