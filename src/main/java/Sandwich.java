import java.util.List;

public class Sandwich {
    private String breadType;
    private BreadSize breadSize;
    private List<Topping> toppings;
    private boolean toasted;

    public Sandwich(String breadType, BreadSize breadSize, List<Topping> toppings) {
        this.breadType = breadType;
        this.breadSize = breadSize;
        this.toppings = toppings;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
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



//    @Override
//    public String toString() {
//        return String.format("**Sandwitch**" +
//                "\n\tBread: %s" +
//                "\n\tSize: %s" +
//                "\n\tP: %.2f", name,,price)  ;
//    }
}
