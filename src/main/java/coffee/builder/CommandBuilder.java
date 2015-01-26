package coffee.builder;


import coffee.model.Command;
import coffee.model.Order;

public class CommandBuilder {

    public static String SEPARATOR = ":";

    public static String STICK_CODE = "0";

    public static String EXTRACT_HOT_CODE = "h";

    public static String NOT_ENOUGH_MONEY_ERROR_MESSAGE = "M: Not enough money";

    public static Command transform(Order order) {
        Command command;

        if (!hasPayedEnough(order)) {
            command = new Command(NOT_ENOUGH_MONEY_ERROR_MESSAGE, true);
        } else {
            StringBuilder commandMessageBuilder = new StringBuilder();
            commandMessageBuilder.append(order.getDrink());

            if (order.getDrink().isHotDrink() && order.isExtraHot()) {
                commandMessageBuilder.append(EXTRACT_HOT_CODE);
            }

            commandMessageBuilder.append(SEPARATOR);

            if (order.getDrink().isHotDrink() && hasOrderSugar(order)) {
                commandMessageBuilder.append(order.getSugar());
            }

            commandMessageBuilder.append(SEPARATOR);

            if (order.getDrink().isHotDrink() && hasOrderSugar(order)) {
                commandMessageBuilder.append(STICK_CODE);
            }
            command = new Command(commandMessageBuilder.toString(), false);
        }

        return command;
    }

    private static boolean hasPayedEnough(Order order) {
        return order.getAmountPayed() >= order.getDrink().getPrice();
    }

    private static boolean hasOrderSugar(Order order) {
        return order.getSugar() > 0;
    }

}
