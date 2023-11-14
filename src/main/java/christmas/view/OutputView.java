package christmas.view;

import static christmas.utility.Constants.*;

import christmas.model.Calendar;
import christmas.model.Event;
import christmas.model.Menu;
import christmas.model.Order;
import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    private Calendar myCalendar;
    private Order myOrder;
    private Event myEvent;
    public OutputView(Calendar myCalendar, Order myOrder, Event myEvent) {
        this.myCalendar = myCalendar;
        this.myOrder = myOrder;
        this.myEvent = myEvent;
    }

    public void welcomeMessage() {
        System.out.println(WELCOME_MESSAGE_1 + myCalendar.getVisitDate() + WELCOME_MESSAGE_2);
        System.out.println();
    }

    public void orderList() {
        System.out.println(ORDER_LIST_MESSAGE);
        Map<Menu, Integer> orders = myOrder.getOrder();
        for (Map.Entry<Menu, Integer> entry : orders.entrySet()) {
            System.out.println(entry.getKey().getName() + SPACE + entry.getValue() + NUMBER_COUNT);
        }
        System.out.println();
    }

    public void priceBeforeDiscount() {
        System.out.println(PRICE_BEFORE_DISCOUNT_MESSAGE);
        System.out.println(formatInteger(myOrder.getPriceBeforeDiscount()) + WON);
        System.out.println();
    }

    public void giveChampagne() {
        System.out.println(GIVE_CHAMPAGNE_MESSAGE_1);
        if (myEvent.getGiveChampagne()) {
            System.out.println(GIVE_CHAMPAGNE_MESSAGE_2);
            System.out.println();
            return;
        }
        System.out.println(NONE);
        System.out.println();
    }

    public void discount() {
        System.out.println(DISCOUNT_MESSAGE_1);
        if (myEvent.getTotalDiscountRate() == INITIAL_PRICE) {
            System.out.println(NONE);
            System.out.println();
            return;
        }
        if (myEvent.christmasDDayDiscount() > INITIAL_PRICE) { System.out.println(DISCOUNT_MESSAGE_2 + LINE + formatInteger(myEvent.christmasDDayDiscount()) + WON); }
        if (!myCalendar.isWeekend() && myEvent.weekdayDiscount() > INITIAL_PRICE) { System.out.println(DISCOUNT_MESSAGE_3 + LINE + formatInteger(myEvent.weekdayDiscount()) + WON); }
        if (myCalendar.isWeekend() && myEvent.weekendDiscount() > INITIAL_PRICE) { System.out.println(DISCOUNT_MESSAGE_4 + LINE + formatInteger(myEvent.weekendDiscount()) + WON); }
        if (myEvent.specialDiscount() > INITIAL_PRICE) { System.out.println(DISCOUNT_MESSAGE_5 + LINE + formatInteger(myEvent.specialDiscount() )+ WON); }
        if (myEvent.getGiveChampagne()) { System.out.println(DISCOUNT_MESSAGE_6); }
        System.out.println();
    }

    public void totalDiscountRate() {
        System.out.println(TOTAL_DISCOUNT_RATE_MESSAGE);
        if (myEvent.getTotalDiscountRate() > INITIAL_PRICE) {
            System.out.println(LINE + formatInteger(myEvent.getTotalDiscountRate()) + WON);
            System.out.println();
            return;
        }
        System.out.println(formatInteger(myEvent.getTotalDiscountRate()) + WON);
        System.out.println();
    }

    public void priceAfterDiscount() {
        System.out.println(PRICE_AFTER_DISCOUNT_MESSAGE);
        if (myEvent.getGiveChampagne()) {
            System.out.println(formatInteger(myOrder.getPriceAfterDiscount() + CHAMPAGNE_PRICE) + WON);
        }
        if (!myEvent.getGiveChampagne()) {
            System.out.println(formatInteger(myOrder.getPriceAfterDiscount()) + WON);
        }
        System.out.println();
    }

    public void badge() {
        System.out.println(BADGE_MESSAGE);
        System.out.println(myEvent.getBadge());
        System.out.println();
    }

    private String formatInteger(Integer price) {
        DecimalFormat decimalFormat = new DecimalFormat(FORMAT_INTEGER_PATTERN);
        return decimalFormat.format(price);
    }
}
