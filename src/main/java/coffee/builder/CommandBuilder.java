package coffee.builder;


import coffee.model.Order;

public class CommandBuilder {

    public static String SEPARATOR = ":";

    public static String STICK_CODE = "0";

    public static String EXTRACT_HOT_CODE = "h";

    public static String NOT_ENOUGH_MONEY_ERROR_MESSAGE = "M: Not enough money";

    public static String transform(Order order) {
        StringBuilder command = new StringBuilder();

        if(!hasPayedEnough(order)) {
            command.append(NOT_ENOUGH_MONEY_ERROR_MESSAGE);
        }
        else {
            command.append(order.getDrink());

            if(order.getDrink().isHotDrink() && order.isExtraHot()) {
                command.append(EXTRACT_HOT_CODE);
            }

            command.append(SEPARATOR);

            if (order.getDrink().isHotDrink() &&  hasOrderSugar(order)) {
                command.append(order.getSugar());
            }

            command.append(SEPARATOR);

            if (order.getDrink().isHotDrink() && hasOrderSugar(order)) {
                command.append(STICK_CODE);
            }
        }
        return command.toString();
    }

    private static boolean hasPayedEnough(Order order) {
        return order.getAmountPayed() >= order.getDrink().getPrice();
    }

    private static boolean hasOrderSugar(Order order) {
        return order.getSugar() > 0;
    }

}
