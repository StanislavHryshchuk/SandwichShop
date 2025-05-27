import java.util.List;

public class CheeseTopping extends Topping {

    public static List<String> namesOfCheese = List.of(
            "american",
            "provolone",
            "cheddar",
            "swiss");

    public CheeseTopping(String name, BreadSize size, boolean extra) {
        super(name,getPrice(size,extra), extra);
    }

    private static double getPrice(BreadSize size, boolean extra) {
        return switch (size) {
            case FOUR_INCH -> extra ? 1.05 : 0.75 ;
            case EIGHT_INCH -> extra ? 2.10 : 1.50;
            case TWELVE_INCH -> extra ? 3.15 : 2.25;
        };
    }
}