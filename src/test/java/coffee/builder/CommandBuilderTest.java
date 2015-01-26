package coffee.builder;

import coffee.model.Drink;
import coffee.model.Order;
import org.junit.Test;

import static coffee.builder.CommandBuilder.transform;
import static org.assertj.core.api.Assertions.assertThat;


public class CommandBuilderTest {

    @Test
    public void should_transform_order_in_command() throws Exception {

        // Classic orders
        assertThat(transform(new Order(Drink.TEA, 1, 1)).getMessage()).isEqualTo("T:1:0");
        assertThat(transform(new Order(Drink.CHOCOLATE, 0, 1)).getMessage()).isEqualTo("H::");
        assertThat(transform(new Order(Drink.COFFEE, 2, 1)).getMessage()).isEqualTo("C:2:0");

        // ERROR
        assertThat(transform(new Order(Drink.COFFEE, 2, 0.2)).getMessage()).isEqualTo("M: Not enough money");

        // ORANGE JUICE
        assertThat(transform(new Order(Drink.ORANGE_JUICE, 0, 1)).getMessage()).isEqualTo("O::");
        assertThat(transform(new Order(Drink.ORANGE_JUICE, 1, 1)).getMessage()).isEqualTo("O::");

        // Extra Hot
        assertThat(transform(new Order(Drink.TEA, 1, 1, true)).getMessage()).isEqualTo("Th:1:0");
        assertThat(transform(new Order(Drink.CHOCOLATE, 0, 1, true)).getMessage()).isEqualTo("Hh::");
        assertThat(transform(new Order(Drink.COFFEE, 2, 1, true)).getMessage()).isEqualTo("Ch:2:0");

        assertThat(transform(new Order(Drink.ORANGE_JUICE, 0, 1, true)).getMessage()).isEqualTo("O::");
        assertThat(transform(new Order(Drink.ORANGE_JUICE, 0, 1, false)).getMessage()).isEqualTo("O::");
    }

}