public abstract class Topping {

    private double price;
    private boolean extra;
    private String name;

    public Topping(String name, double price, boolean extra) {
        this.name = name;
        this.price = price;
        this.extra = extra;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isExtra() {
        return extra;
    }

    public void setExtra(boolean extra) {
        this.extra = extra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if(this instanceof RegularTopping){
            return name;
        }
        if (extra) {
            return String.format("%s (extra) - $%.2f", name, price);
        } else {
            return String.format("%s - $%.2f", name, price);
        }
    }
}