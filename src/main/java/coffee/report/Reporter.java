package coffee.report;

import coffee.model.Drink;

import java.util.EnumMap;

public class Reporter {

    private final EnumMap<Drink, Double> drinksOrdered;

    public Reporter() {
        this.drinksOrdered = new EnumMap<>(Drink.class);
    }

    public void addDrinkOrder(Drink drink) {
        drinksOrdered.merge(drink, 1.0, (count, none) -> count + 1);
    }

    public Double allOrdersAmount() {
        return drinksOrdered
                .entrySet()
                .parallelStream()
                .map(e -> e.getKey().getPrice() * e.getValue())
                .reduce(0.0, Double::sum);
    }

}
