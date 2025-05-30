package modele;
import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private String name = LocalDateTime.now().toString();
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;
    private double orderPrice;

    public Order(String name, List<Sandwich> sandwiches, List<Drink> drinks, List<Chips> chips) {
        this.name = name;
        this.sandwiches = sandwiches;
        this.drinks = drinks;
        this.chips = chips;
        this.orderPrice = getPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(List<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }

    public void setChips(List<Chips> chips) {
        this.chips = chips;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public double getPrice(){
        double totalCost = 0.0;

        if(sandwiches != null){
            for(Sandwich sandwich : sandwiches){
                totalCost += sandwich.getPrice();
            }
        }
        if (drinks != null){
            for(Drink drink : drinks){
                totalCost += drink.getPrice();
            }
        }
        if (chips != null){
            for(Chips c: chips){
                totalCost += c.getPrice();
            }
        }
        return totalCost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Order Summary ===\n");
        sb.append("Order for: ").append(name);

        if (sandwiches != null && !sandwiches.isEmpty()) {
            sb.append("\t\nSandwich:\n");
            for (Sandwich s : sandwiches) {
                sb.append(s).append("\n");
            }
        }
        if (drinks != null && !drinks.isEmpty()) {
            sb.append("Drinks:\n");
            for (Drink d : drinks) {
                sb.append("\t").append(d).append("\n");
            }
        }
        if (chips != null && !chips.isEmpty()){
            sb.append(("Chips:\n"));
            for (Chips c : chips){
                sb.append("\t").append(c).append("\n");
            }
        }
        sb.append("===================\n");
        sb.append(String.format("Total Order cost: $%.2f", getPrice()));
        return sb.toString();
    }
}