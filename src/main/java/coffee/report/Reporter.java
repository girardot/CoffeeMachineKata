package coffee.report;

import coffee.model.Drink;

import java.util.EnumMap;
import java.util.Map;

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

    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder();
        for (Map.Entry<Drink, Double> drinkDoubleEntry : drinksOrdered.entrySet()) {
            reportBuilder.append(drinkDoubleEntry.getKey())
                    .append(" : ")
                    .append(drinkDoubleEntry.getValue())
                    .append("\n");
        }

        reportBuilder.append("SUM OF MONEY :").append(allOrdersAmount());

        return reportBuilder.toString();
    }

}
