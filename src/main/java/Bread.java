import java.util.List;

public class Bread {
    private String name;
    private String size;
    private double price;
    public static List<String> breadNames = List.of(
            "Wheat",
            "White",
            "Rye",
            "Wrap");

    public Bread(String name, String size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
