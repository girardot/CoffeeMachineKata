package coffee;

import coffee.builder.CommandBuilder;
import coffee.model.Order;

public class CoffeeMachine {

    private DrinkMaker drinkMaker;

    public CoffeeMachine() {
        drinkMaker = new DrinkMaker();
    }

    public void processOrder(Order order) {
        String command = CommandBuilder.transform(order);
        drinkMaker.sendCommand(command);
    }

}
