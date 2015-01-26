package coffee.report;

import org.junit.Test;

import static coffee.model.Drink.*;
import static org.assertj.core.api.Assertions.assertThat;


public class ReporterTest {

    @Test
    public void add_drink_orders_and_calcul_sum() throws Exception {
        // Gviven
        Reporter reporter = new Reporter();

        reporter.addDrinkOrder(CHOCOLATE); // 0.5
        reporter.addDrinkOrder(COFFEE); //  0.6
        reporter.addDrinkOrder(ORANGE_JUICE); // 0.6
        reporter.addDrinkOrder(TEA); // 0.4
        reporter.addDrinkOrder(CHOCOLATE);//0.5
        reporter.addDrinkOrder(COFFEE); // 0.6

        // When
        Double sumResult = reporter.allOrdersAmount();

        // Then
        assertThat(sumResult).isEqualTo(3.2);
    }

}