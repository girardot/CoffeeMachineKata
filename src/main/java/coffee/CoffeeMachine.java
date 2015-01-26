package coffee;

import coffee.builder.CommandBuilder;
import coffee.model.Command;
import coffee.model.Drink;
import coffee.model.Order;
import coffee.report.Reporter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static coffee.utils.ConsoleTextLabel.*;

public class CoffeeMachine {

    private static DrinkMaker drinkMaker;

    private static Reporter reporter;

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

    public static void main(String[] args) throws IOException {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        do {
            // Choose drink
            System.out.println(DRINK_SELECTION);
            input = reader.readLine();
            Drink drink = chooseDrink(input);

            // Extra hot
            System.out.println(SUGAR_NUMBER);
            input = reader.readLine();
            int sugar = Integer.parseInt(input);

            // Extra hot
            System.out.println(INSERT_COINS);
            input = reader.readLine();
            double amountPayed = Double.parseDouble(input);

            // Extra hot
            System.out.println(EXTRA_HOT);
            input = reader.readLine();
            boolean extraHot = chooseExtraHot(input);

            coffeeMachine.processOrder(new Order(drink, sugar, amountPayed, extraHot));

            System.out.println(reporter.getReport());
            System.out.println(EXIT_LABEL);

        } while (!isEndChar(input));

    }

    private static boolean chooseExtraHot(String input) {
        return input.equals("Y");
    }

    private static Drink chooseDrink(String input) {
        Drink drink = null;

        switch (input) {
            case "1":
                drink = Drink.COFFEE;
                break;
            case "2":
                drink = Drink.TEA;
                break;
            case "3":
                drink = Drink.CHOCOLATE;
                break;
            case "4":
                drink = Drink.ORANGE_JUICE;
                break;
        }
        return drink;
    }

    private static boolean isEndChar(String value) {
        return (value.equals("e") || value.equals("E"));
    }

}
