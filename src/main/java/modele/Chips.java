package modele;

import java.util.List;

public class Chips {
    private String name;
    private double price;
    public static List<String> chipsList = List.of(
            "Pringles",
            "Lays",
            "Cheetos",
            "Doritos");

    public Chips(String name) {
        this.name = name;
        this.price = 1.50;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s - $%.2f", name,price)  ;
    }
}