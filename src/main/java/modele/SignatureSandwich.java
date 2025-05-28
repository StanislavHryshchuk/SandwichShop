package modele;
import enums.BreadSize;
import java.util.ArrayList;
import java.util.List;

public class SignatureSandwich extends Sandwich{

    public static List<String> signatureSandwichList = List.of(
            "1. BLT Sandwich",
            "2. Philly Cheese Steak"
    );

    public SignatureSandwich(String breadName, BreadSize breadSize, List<Topping> toppings, List<Sauce> sauces, List<Sides> sides, boolean toasted) {
        super(breadName, breadSize, toppings, sauces, sides, toasted);
    }
    // Factory method to build a BLT Signature Sandwich
    public static Sandwich bltSandwich(){
        BreadSize size = BreadSize.EIGHT_INCH;
        Bread bread = new Bread(Bread.breadNames.get(1), size);

        List<Topping> toppings = new ArrayList<>();
        toppings.add(new MeatTopping(MeatTopping.meatToppings.getLast(),size,false));
        toppings.add(new CheeseTopping(CheeseTopping.namesOfCheese.get(1),size,false));
        toppings.add(new RegularTopping(RegularTopping.regularToppings.getFirst()));
        toppings.add(new RegularTopping(RegularTopping.regularToppings.get(3)));

        List<Sauce> sauces = new ArrayList<>();
        sauces.add(new Sauce(Sauce.sauces.get(3)));
        boolean toasted = true;

        List<Sides> sides = new ArrayList<>();

        return  new SignatureSandwich(bread.getName(),size,toppings,sauces,sides,toasted);
    }

    // Factory method to build Philly Cheese Steak Signature Sandwich
    public static Sandwich pcSteakSandwich(){
        BreadSize size = BreadSize.EIGHT_INCH;
        Bread bread = new Bread(Bread.breadNames.get(1),size);

        List<Topping> toppings = new ArrayList<>();
        toppings.add(new MeatTopping(MeatTopping.meatToppings.getFirst(),size,false));
        toppings.add(new CheeseTopping(CheeseTopping.namesOfCheese.getFirst(),size,false));
        toppings.add(new RegularTopping(RegularTopping.regularToppings.get(1)));

        List<Sauce> sauces = new ArrayList<>();
        sauces.add(new Sauce(Sauce.sauces.getFirst()));
        boolean toasted = true;

        List<Sides> sides = new ArrayList<>();

        return  new SignatureSandwich(bread.getName(), size,toppings,sauces,sides,toasted);
    }
}