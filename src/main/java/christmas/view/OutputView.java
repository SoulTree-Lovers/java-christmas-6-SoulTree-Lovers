package christmas.view;

import static christmas.utility.Constants.LINE;

import christmas.model.Calendar;
import christmas.model.Event;
import christmas.model.Menu;
import christmas.model.Order;
import java.text.DecimalFormat;
import java.util.List;
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
        System.out.println("12월 " + myCalendar.getVisitDate() + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
    }

    public void orderList() {
        System.out.println("<주문 메뉴>");
        Map<Menu, Integer> orders = myOrder.getOrder();
        for (Map.Entry<Menu, Integer> entry : orders.entrySet()) {
            System.out.println(entry.getKey().getName() + " " + entry.getValue() + "개");
        }
        System.out.println();
    }

    public void priceBeforeDiscount() {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(formatInteger(myOrder.getPriceBeforeDiscount()) + "원");
        System.out.println();
    }

    public void giveChampagne() {
        System.out.println("<증정 메뉴>");
        if (myEvent.getGiveChampagne()) {
            System.out.println("샴페인 1개");
            System.out.println();
            return;
        }
        System.out.println("없음");
        System.out.println();
    }

    public void discount() {
        System.out.println("<혜택 내역>");
        if (myEvent.getTotalDiscountRate() == 0) {
            System.out.println("없음");
            System.out.println();
            return;
        }
        if (myEvent.christmasDDayDiscount() > 0) { System.out.println("크리스마스 디데이 할인: " + LINE + formatInteger(myEvent.christmasDDayDiscount()) + "원"); }
        if (!myCalendar.isWeekend() && myEvent.weekdayDiscount() > 0) { System.out.println("평일 할인: " + LINE + formatInteger(myEvent.weekdayDiscount()) + "원"); }
        if (myCalendar.isWeekend() && myEvent.weekendDiscount() > 0) { System.out.println("주말 할인: " + LINE + formatInteger(myEvent.weekendDiscount()) + "원"); }
        if (myEvent.specialDiscount() > 0) { System.out.println("특별 할인: " + LINE + formatInteger(myEvent.specialDiscount() )+ "원"); }
        if (myEvent.getGiveChampagne()) { System.out.println("증정 이벤트: -25,000원"); }
        System.out.println();
    }

    public void totalDiscountRate() {
        System.out.println("<총혜택 금액>");
        if (myEvent.getTotalDiscountRate() > 0) {
            System.out.println(LINE + formatInteger(myEvent.getTotalDiscountRate()) + "원");
            System.out.println();
            return;
        }
        System.out.println(formatInteger(myEvent.getTotalDiscountRate()) + "원");
        System.out.println();
    }

    public void priceAfterDiscount() {
        System.out.println("<할인 후 예상 결제 금액>");
        if (myEvent.getGiveChampagne()) {
            System.out.println(formatInteger(myOrder.getPriceAfterDiscount() + 25000) + "원");
        }
        if (!myEvent.getGiveChampagne()) {
            System.out.println(formatInteger(myOrder.getPriceAfterDiscount()) + "원");
        }
        System.out.println();
    }

    public void badge() {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(myEvent.getBadge());
        System.out.println();
    }

    private String formatInteger(Integer price) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(price);
    }
}
