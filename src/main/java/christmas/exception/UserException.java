package christmas.exception;

import static christmas.utility.Constants.COMMA;
import static christmas.utility.Constants.ERROR_MESSAGE_DATE;
import static christmas.utility.Constants.ERROR_MESSAGE_ORDER;
import static christmas.utility.Constants.FIRST_ITEM;
import static christmas.utility.Constants.LINE;
import static christmas.utility.Constants.MAX_DATE;
import static christmas.utility.Constants.MENU_FORMAT_LENGTH;
import static christmas.utility.Constants.MIN_DATE;
import static christmas.utility.Constants.SECOND_ITEM;

import christmas.model.Menu;
import java.util.HashSet;
import java.util.Set;

public class UserException {
    // TODO : DateException과 OrderException으로 클래스 분리하기
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
        if (date < MIN_DATE || date > MAX_DATE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DATE);
        }
    }

    private static void validateOrderMenuNone(String userInput) {
        String[] menuItems = userInput.split(COMMA);
        for (String menuItem : menuItems) {
            String menuName = menuItem.split(LINE)[FIRST_ITEM].trim();
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
        String[] menuItems = userInput.split(COMMA);
        for (String menuItem : menuItems) {
            String[] parts = menuItem.split(LINE);
            int count = Integer.parseInt(parts[SECOND_ITEM].trim());
            if (count < MIN_DATE) {
                throw new IllegalArgumentException(ERROR_MESSAGE_ORDER);
            }
        }
    }

    private static void validateOrderMenuFormat(String userInput) {
        String[] menuItems = userInput.split(COMMA);
        for (String menuItem : menuItems) {
            String[] parts = menuItem.split(LINE);
            if (parts.length != MENU_FORMAT_LENGTH || !isInteger(parts[SECOND_ITEM].trim())) {
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
        String[] menuItems = userInput.split(COMMA);
        Set<String> uniqueMenus = new HashSet<>();
        for (String menuItem : menuItems) {
            String[] parts = menuItem.split(LINE);
            if (!uniqueMenus.add(parts[FIRST_ITEM].trim())) {
                throw new IllegalArgumentException(ERROR_MESSAGE_ORDER);
            }
        }
    }

}
