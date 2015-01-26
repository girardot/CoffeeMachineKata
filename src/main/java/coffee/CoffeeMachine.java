package coffee;

import coffee.builder.CommandBuilder;
import coffee.model.Command;
import coffee.model.Order;
import coffee.report.Reporter;

public class CoffeeMachine {

    private DrinkMaker drinkMaker;

    private Reporter reporter;

    public CoffeeMachine() {
        drinkMaker = new DrinkMaker();
        reporter = new Reporter();
    }

    public void processOrder(Order order) {
        Command command = CommandBuilder.transform(order);

        drinkMaker.sendCommand(command.getMessage());

        if (!command.isError()) {
            reporter.addDrinkOrder(order.getDrink());
        }
    }

}
