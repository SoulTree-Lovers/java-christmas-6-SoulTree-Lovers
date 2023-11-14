package christmas.model;

import static christmas.utility.Constants.*;

import java.util.Map;

public class Event {
    private boolean giveChampagne;
    private String badge;
    private Integer totalDiscountRate;
    private Calendar myCalendar;
    private Order myOrder;
    public Event(Calendar myCalendar, Order myOrder) {
        this.myCalendar = myCalendar;
        this.myOrder = myOrder;
        this.badge = NONE;
        this.totalDiscountRate = INITIAL_PRICE;
    }

    public void calculateAllDiscount() {
        if (myOrder.getPriceBeforeDiscount() < MIN_PRICE_FOR_EVENT) {
            myOrder.setPriceAfterDiscount(myOrder.getPriceBeforeDiscount());
            return;
        }
        Integer totalDiscount = INITIAL_PRICE;
        totalDiscount += christmasDDayDiscount();
        if (!myCalendar.isWeekend()) { totalDiscount += weekdayDiscount(); }
        else if (myCalendar.isWeekend()){ totalDiscount += weekendDiscount(); }
        totalDiscount += specialDiscount();
        if(setGiveChampagne()) {totalDiscount += CHAMPAGNE_PRICE;}
        this.totalDiscountRate = totalDiscount;
        setBadge();
        myOrder.setPriceAfterDiscount(myOrder.getPriceBeforeDiscount() - this.totalDiscountRate);
    }

    public Integer getTotalDiscountRate() {
        return this.totalDiscountRate;
    }

    public Integer christmasDDayDiscount() {
        if (myCalendar.getVisitDate() <= CHRISTMAS_DAY) {
            return MIN_DISCOUNT_RATE_FOR_CHRISTMAS_EVENT + (myCalendar.getVisitDate()-1) * DISCOUNT_RATE_FOR_CHRISTMAS_EVENT_PER_DAY;
        }
        return 0;
    }

    public Integer weekdayDiscount() {
        // TODO : 평일 할인 로직 구현
        Map<Menu, Integer> order = myOrder.getOrder();
        Integer weekdayDiscountTotal = INITIAL_PRICE;
        for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
            Menu menu = entry.getKey();
            if (menu.getType().equals(DESSERT)) {
                weekdayDiscountTotal += (DISCOUNT_RATE_FOR_WEEKDAY_EVENT * entry.getValue());
            }
        }
        return weekdayDiscountTotal;
    }

    public Integer weekendDiscount() {
        // TODO : 주말 할인 로직 구현
        Map<Menu, Integer> order = myOrder.getOrder();
        Integer weekendDiscountTotal = INITIAL_PRICE;
        for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
            Menu menu = entry.getKey();
            if (menu.getType().equals(MAIN)) {
                weekendDiscountTotal += (DISCOUNT_RATE_FOR_WEEKEND_EVENT * entry.getValue());
            }
        }
        return weekendDiscountTotal;
    }

    public Integer specialDiscount() {
        if (myCalendar.existStar()) {
            return DISCOUNT_RATE_FOR_SPECIAL_EVENT;
        }
        return 0;
    }

    public boolean setGiveChampagne() {
        giveChampagne = false;
        if (myOrder.getPriceBeforeDiscount() >= MIN_PRICE_FOR_FREE_CHAMPAGNE) {
            giveChampagne = true;
            return true;
        }
        return false;
    }

    public boolean getGiveChampagne() {
        return this.giveChampagne;
    }

    public void setBadge() {
        if (this.totalDiscountRate == null) {this.totalDiscountRate = INITIAL_PRICE;}
        if (this.totalDiscountRate >= MIN_TOTAL_DISCOUNT_RATE_FOR_SANTA) { this.badge = SANTA; }
        else if (this.totalDiscountRate >= MIN_TOTAL_DISCOUNT_RATE_FOR_TREE) { this.badge = TREE; }
        else if (this.totalDiscountRate >= MIN_TOTAL_DISCOUNT_RATE_FOR_STAR) { this.badge = STAR; }
    }

    public String getBadge() {
        return this.badge;
    }
}
