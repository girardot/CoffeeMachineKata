package coffee.model;

public enum Drink {

    COFFEE("C", 0.6),
    TEA("T", 0.4),
    CHOCOLATE("H", 0.5),
    ORANGE_JUICE("O", 0.6);

    private String code;

    private Double price;

    Drink(String code, Double price) {
        this.code = code;
        this.price = price;
    }

    @Override
    public String toString() {
        return code;
    }

    public String getCode() {
        return code;
    }

    public Double getPrice() {
        return price;
    }

    public boolean isHotDrink() {
        return this != ORANGE_JUICE;
    }

}
