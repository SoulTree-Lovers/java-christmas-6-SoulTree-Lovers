package christmas.exception;

import static christmas.utility.Constants.ERROR_MESSAGE_DATE;
import static christmas.utility.Constants.MAX_DATE;
import static christmas.utility.Constants.MIN_DATE;

public class DateException {
    private DateException() {}
    public static void validateAll(String userInput) {
        validateDateType(userInput);
        validateDateRange(userInput);
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
}
