package coffee.report;

import coffee.model.Drink;

import java.math.BigDecimal;
import java.util.EnumMap;

import static java.math.BigDecimal.valueOf;
import static java.math.BigDecimal.ZERO;

public class Reporter {

    private final EnumMap<Drink, Double> drinksOrdered;

    public Reporter() {
        this.drinksOrdered = new EnumMap<>(Drink.class);
    }

    public void addDrinkOrder(Drink drink) {
        drinksOrdered.merge(drink, 1.0, (count, none) -> count + 1);
    }

    public Double allOrdersAmount() {
//        return drinksOrdered
//                .entrySet()
//                .parallelStream()
//                .map(e -> e.getKey().getPrice().multiply(valueOf(e.getValue())))
//                .reduce(ZERO, BigDecimal::add);
        return 0.0;
    }

}
