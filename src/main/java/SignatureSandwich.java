import java.util.ArrayList;
import java.util.List;

public class SignatureSandwich extends Sandwich{

    public SignatureSandwich(String breadName, BreadSize breadSize, List<Topping> toppings, List<Sauce> sauces, List<Sides> sides, boolean toasted) {
        super(breadName, breadSize, toppings, sauces, sides, toasted);
    }

    public Sandwich bltSandwich(){
        BreadSize size = BreadSize.EIGHT_INCH;
        Bread bread = new Bread(Bread.breadNames.get(1), size);
        List<Topping> toppings = new ArrayList<>();
        toppings.add(new MeatTopping(MeatTopping.meatToppings.getLast(),size,false));
        toppings.add(new RegularTopping(RegularTopping.regularToppings.getFirst()));
        toppings.add(new RegularTopping(RegularTopping.regularToppings.get(3)));
        List<Sauce> sauces = new ArrayList<>();
        sauces.add(new Sauce(Sauce.sauces.get(3)));
        boolean toasted = true;
        List<Sides> sides= new ArrayList<>();
        return new SignatureSandwich(bread.getName(),size,toppings,sauces,sides,toasted);
    }

    public double getPrice(BreadSize size){
        double sandwichCost = 0.0;
        sandwichCost += size.getPrice();

        if(toppings != null){
            for (Topping topping : toppings){
                sandwichCost += topping.getPrice();
            }
        }
        return sandwichCost;
    }
}
