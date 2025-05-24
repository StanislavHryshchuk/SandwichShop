public enum BreadSize {
    FOUR_INCH(5.50, "4'"),
    EIGHT_INCH(7.00, "8'"),
    TWELVE_INCH(8.50, "12'");

    private final double price;
    private final String label;

    BreadSize(double price, String label) {
        this.price = price;
        this.label = label;
    }

    public double getPrice(){
        return price;
    }

    public String getLabel() {
        return label;
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
