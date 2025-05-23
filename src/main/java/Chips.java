public class Chips {
    private String name;
    private double price = 1.50;

    public Chips(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Chips: %s\n\tP: %.2f", name,price)  ;
    }
}
