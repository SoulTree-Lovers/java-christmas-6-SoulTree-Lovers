package christmas.model;

import java.util.Map;

public class Event {
    private boolean giveChampagne;
    private String badge;
    private Calendar myCalendar;
    private Order myOrder;
    public Event(Calendar myCalendar, Order myOrder) {
        this.myCalendar = myCalendar;
        this.myOrder = myOrder;
    }

    public Integer christmasDDayDiscount() {
        if (myCalendar.getVisitDate() <= 25) {
            return 1000 + (myCalendar.getVisitDate()-1) * 100;
        }
        return 0;
    }

    public Integer weekdayDiscount() {
        // TODO : 평일 할인 로직 구현
        Map<Menu, Integer> order = myOrder.getOrder();
        Integer weekdayDiscountTotal = 0;
        for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
            Menu menu = entry.getKey();
            if (menu.getType().equals("디저트")) {
                weekdayDiscountTotal += 2023;
            }
        }
        return weekdayDiscountTotal;
    }

    public Integer weekendDiscount() {
        // TODO : 주말 할인 로직 구현
        Map<Menu, Integer> order = myOrder.getOrder();
        Integer weekendDiscountTotal = 0;
        for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
            Menu menu = entry.getKey();
            if (menu.getType().equals("메인")) {
                weekendDiscountTotal += 2023;
            }
        }
        return weekendDiscountTotal;
    }

    public Integer specialDiscount() {
        if (myCalendar.existStar()) {
            return 1000;
        }
        return 0;
    }

    public void setGiveChampagne() {
        giveChampagne = false;
        if (myOrder.getPriceBeforeDiscount() >= 120000) {
            giveChampagne = true;
        }
    }
}
