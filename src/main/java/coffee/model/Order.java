package coffee.model;

import coffee.model.Drink;

public class Order {

    private Drink drink;

    private int sugar;

    private double amountPayed;

    private boolean extraHot;

    public Order(Drink drink, int sugar, double amount) {
        this(drink, sugar, amount, false);
    }

    public Order(Drink drink, int sugar, double amountPayed, boolean extraHot) {
        this.drink = drink;
        this.sugar = sugar;
        this.amountPayed = amountPayed;
        this.extraHot = extraHot;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public double getAmountPayed() {
        return amountPayed;
    }

    public void setAmountPayed(double amountPayed) {
        this.amountPayed = amountPayed;
    }

    public boolean isExtraHot() {
        return extraHot;
    }

    public void setExtraHot(boolean extraHot) {
        this.extraHot = extraHot;
    }

}
