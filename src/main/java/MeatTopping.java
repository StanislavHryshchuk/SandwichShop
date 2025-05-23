import java.util.List;

public class MeatTopping extends Topping {

    public static List<String> meatToppings = List.of(
            "steak",
            "ham",
            "salami",
            "roast beef",
            "chicken",
            "bacon");

    public MeatTopping(String name, double price, boolean extra) {
        super(name, 1, extra);
    }
}
