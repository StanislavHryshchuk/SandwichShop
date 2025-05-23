import java.util.List;

public class CheeseTopping extends Topping {

    public static List<String> namesOfCheese = List.of(
            "american",
            "provolone",
            "cheddar",
            "swiss");

    public CheeseTopping(String name, boolean extra) {
        super(name,0.75, extra);

    }


}
