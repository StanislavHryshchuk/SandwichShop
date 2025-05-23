public enum BreadSize {
    FOUR_INCH(5.50, 1),
    EIGHT_INCH(7.00, 2),
    TWELVE_INCH(8.50, 3);

    private final double price;
    private final int sizeCorelation;
    BreadSize(double price, int sizeCorelation) {
        this.price = price;
        this.sizeCorelation = sizeCorelation;
    }

    public double getPrice(){
        return price;
    }

    public int getSizeCorelation() {
        return sizeCorelation;
    }

    public static BreadSize fromInput(int input) {
        return switch (input) {
            case 4 -> FOUR_INCH;
            case 8 -> EIGHT_INCH;
            case 12 -> TWELVE_INCH;
            default -> throw new IllegalArgumentException("Invalid bread size.");
        };
    }


}
