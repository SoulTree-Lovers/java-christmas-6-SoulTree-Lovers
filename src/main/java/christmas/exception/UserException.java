package christmas.exception;

import static christmas.utility.Constants.ERROR_MESSAGE_DATE;
import static christmas.utility.Constants.ERROR_MESSAGE_ORDER;

import christmas.model.Menu;
import java.util.HashSet;
import java.util.Set;

public class UserException {
    private UserException() {}

    public static void validateDateAll(String userInput) {
        validateDateType(userInput);
        validateDateRange(userInput);
    }

    public static void validateOrderAll(String userInput) {
        validateOrderMenuFormat(userInput);
        validateOrderMenuNone(userInput);
        validateOrderMenuCount(userInput);
        validateOrderMenuDuplicate(userInput);
    }

    private static void validateDateType(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DATE);
        }
    }

    private static void validateDateRange(String userInput) {
        Integer date = Integer.parseInt(userInput);
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DATE);
        }
    }

    private static void validateOrderMenuNone(String userInput) {
        String[] menuItems = userInput.split(",");
        for (String menuItem : menuItems) {
            String menuName = menuItem.split("-")[0].trim();
            if (!isMenuInMenuList(menuName)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_ORDER);
            }
        }
    }

    private static boolean isMenuInMenuList(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equals(menuName)) {
                return true;
            }
        }
        return false;
    }


    private static void validateOrderMenuCount(String userInput) {
        String[] menuItems = userInput.split(",");
        for (String menuItem : menuItems) {
            String[] parts = menuItem.split("-");
            int count = Integer.parseInt(parts[1].trim());
            if (count < 1) {
                throw new IllegalArgumentException(ERROR_MESSAGE_ORDER);
            }
        }
    }

    private static void validateOrderMenuFormat(String userInput) {
        String[] menuItems = userInput.split(",");
        for (String menuItem : menuItems) {
            String[] parts = menuItem.split("-");
            if (parts.length != 2 || !isInteger(parts[1].trim())) {
                throw new IllegalArgumentException(ERROR_MESSAGE_ORDER);
            }
        }
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void validateOrderMenuDuplicate(String userInput) {
        String[] menuItems = userInput.split(",");
        Set<String> uniqueMenus = new HashSet<>();
        for (String menuItem : menuItems) {
            if (!uniqueMenus.add(menuItem.trim())) {
                throw new IllegalArgumentException(ERROR_MESSAGE_ORDER);
            }
        }
    }

}
