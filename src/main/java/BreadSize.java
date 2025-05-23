public enum BreadSize {
    FOUR_INCH(5.50),
    EIGHT_INCH(7.00),
    TWELVE_INCH(8.50);

    private final double price;

    BreadSize(double price) {
        this.price = price;
    }

    public double getPrice(){
        return price;
    }
}
