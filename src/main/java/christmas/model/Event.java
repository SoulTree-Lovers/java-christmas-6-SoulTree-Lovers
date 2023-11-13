package christmas.model;

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
        this.badge = "없음";
    }

    public void calculateAllDiscount() {
        if (myOrder.getPriceBeforeDiscount() < 10000) {return;}
        Integer totalDiscount = 0;
        totalDiscount += christmasDDayDiscount();
        if (!myCalendar.isWeekend()) { totalDiscount += weekdayDiscount(); }
        else if (myCalendar.isWeekend()){ totalDiscount += weekendDiscount(); }
        totalDiscount += specialDiscount();
        if(setGiveChampagne()) {totalDiscount += 25000;}
        this.totalDiscountRate = totalDiscount;
        setBadge();
        myOrder.setPriceAfterDiscount(myOrder.getPriceBeforeDiscount() - this.totalDiscountRate);
    }

    public Integer getTotalDiscountRate() {
        return totalDiscountRate;
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
                weekdayDiscountTotal += (2023 * entry.getValue());
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
                weekendDiscountTotal += (2023 * entry.getValue());
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

    public boolean setGiveChampagne() {
        giveChampagne = false;
        if (myOrder.getPriceBeforeDiscount() >= 120000) {
            giveChampagne = true;
            return true;
        }
        return false;
    }

    public boolean getGiveChampagne() {
        return this.giveChampagne;
    }

    public void setBadge() {
        if (this.totalDiscountRate == null) {this.totalDiscountRate = 0;}
        if (this.totalDiscountRate >= 20000) { this.badge = "산타"; }
        else if (this.totalDiscountRate >= 10000) { this.badge = "트리"; }
        else if (this.totalDiscountRate >= 5000) { this.badge = "별"; }
    }

    public String getBadge() {
        return this.badge;
    }
}
