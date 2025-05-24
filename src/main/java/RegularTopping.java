import java.util.List;

public class RegularTopping extends Topping{

    public static List<String> regularToppings = List.of(
            "lettuce",
            "peppers",
            "onions",
            "tomatoes",
            "jalapeños",
            "cucumbers",
            "pickles",
            "guacamole",
            "mushrooms");

    public RegularTopping(String name) {
        super(name, 0.0, false);
    }
}
