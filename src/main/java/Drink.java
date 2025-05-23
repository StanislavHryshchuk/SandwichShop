public class Drink {
    private String name;
    private double price;
    private String size;

    public Drink(String name, String size) {
        this.name = name;
        this.size = size;
        this.price = getPrice(size);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice(String size) {
        if (size.equalsIgnoreCase("Large")){
            return this.price = 3.00;
        } else if (size.equalsIgnoreCase("Medium")) {
            return this.price = 2.5;
        } else return 2.0;

    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("Drink: %s" +
                "\n\tS: %s" +
                "\n\tP: %.2f", name,size,price)  ;
    }
}
