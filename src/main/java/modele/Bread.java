package modele;

import enums.BreadSize;

import java.util.List;

public class Bread {
    private String name;
    private BreadSize size;

    public static List<String> breadNames = List.of(
            "Wheat",
            "White",
            "Rye",
            "Wrap");

    public Bread(String name, BreadSize size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return size.getPrice();
    }

    public BreadSize getSize() {
        return size;
    }

    @Override
    public String toString() {
        return String.format("Bread: %s %s \nPrice: $%.2f", name, size.getLabel(), size.getPrice());
    }
}