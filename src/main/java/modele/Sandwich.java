package modele;
import enums.BreadSize;
import java.util.List;
import java.util.Scanner;

public class Sandwich {
    private static Scanner scanner = new Scanner(System.in);

    private String breadName;
    private BreadSize breadSize;
    private List<Topping> toppings;
    private List<Sauce> sauces;
    private List<Sides> sides;
    private boolean toasted;
    private double price;

    public Sandwich(String breadName, BreadSize breadSize, List<Topping> toppings, List<Sauce> sauces, List<Sides> sides, boolean toasted) {
        this.breadName = breadName;
        this.breadSize = breadSize;
        this.toppings = toppings;
        this.sides = sides;
        this.toasted = toasted;
        this.sauces = sauces;
        this.price = getPrice();
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public String getBreadName() {
        return breadName;
    }

    public void setBreadName(String breadType) {
        this.breadName = breadType;
    }

    public BreadSize getBreadSize() {
        return breadSize;
    }

    public void setBreadSize(BreadSize breadSize) {
        this.breadSize = breadSize;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public List<Sauce> getSauces() {
        return sauces;
    }

    public void setSauces(List<Sauce> sauces) {
        this.sauces = sauces;
    }

    public List<Sides> getSides() {
        return sides;
    }

    public void setSides(List<Sides> sides) {
        this.sides = sides;
    }

    public double getPrice(){
        double sandwichCost = 0.0;
        sandwichCost += breadSize.getPrice();

        if(toppings != null){
            for (Topping topping : toppings){
                sandwichCost += topping.getPrice();
            }
        }
        return sandwichCost;
    }

    @Override
    public String toString() {

        StringBuilder toppingList = new StringBuilder("Toppings:\n");

        for (Topping topping : toppings) {
            if (topping instanceof RegularTopping) {
                toppingList.append("\t").append(topping.getName()).append("\n");
            } else {
                toppingList
                    .append("\t").append(topping.isExtra() ? "extra " : "")
                    .append(topping.getName())
                    .append(String.format(" - $%.2f", topping.getPrice()))
                    .append("\n");
            }
        }
        return """        
        Bread:
        \t%s (%s) %s - $%.2f
        %s
        Sauces: %s
        Sides: %s
        ---------------------
        Sandwich Total: $%.2f
        """.formatted(
                breadName,
                breadSize.getLabel(),
                toasted ? "Toasted" : "Not Toasted",
                breadSize.getPrice(),
                toppingList.toString(),
                sauces.toString().replaceAll("[\\[\\]]", ""),
                sides.toString().replaceAll("[\\[\\]]", ""),
                getPrice());
    }
}