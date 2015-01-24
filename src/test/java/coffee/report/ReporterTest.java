package coffee.report;

import coffee.model.Drink;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ReporterTest {

    @Test
    public void add_drink_orders_and_calcul_sum() throws Exception {
        // Gviven
        Reporter reporter = new Reporter();

        reporter.addDrinkOrder(Drink.CHOCOLATE);
        reporter.addDrinkOrder(Drink.COFFEE);
        reporter.addDrinkOrder(Drink.ORANGE_JUICE);
        reporter.addDrinkOrder(Drink.TEA);
        reporter.addDrinkOrder(Drink.CHOCOLATE);
        reporter.addDrinkOrder(Drink.COFFEE);

        // When
        Double sumResult = reporter.allOrdersAmount();

        // Then
        assertThat(sumResult).isEqualTo(3.2);
    }

}