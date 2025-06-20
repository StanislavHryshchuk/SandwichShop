package modele;

import enums.BreadSize;

import java.util.List;

public class MeatTopping extends Topping {

    public static List<String> meatToppings = List.of(
            "steak",
            "ham",
            "salami",
            "roast beef",
            "chicken",
            "bacon");

    public MeatTopping(String name, BreadSize size, boolean extra) {
        super(name, getPrice(size,extra), extra);
    }

    private static double getPrice(BreadSize size, boolean extra) {
        return switch (size) {
            case BreadSize.FOUR_INCH ->  extra ? 1.50 : 1.00;
            case BreadSize.EIGHT_INCH ->  extra ? 3.00 : 2.00;
            case BreadSize.TWELVE_INCH ->  extra ? 3.50 : 3.00;
        };
    }
}