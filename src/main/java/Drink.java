import java.util.List;

public class Drink {

    private String name;
    private double price;
    private String size;
    public static List<String> drinksList = List.of(
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

    @Override
    public String toString() {
        return String.format("%s (%s)" + " - $%.2f", name,size,price);
    }
}