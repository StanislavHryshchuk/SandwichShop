package modele;

import java.util.List;

public class Sauce {
    public static List<String> sauces = List.of(
            "mayo",
            "mustard",
            "ketchup",
            "ranch",
            "thousand island",
            "vinaigrette");

    private String name;

    public Sauce(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}