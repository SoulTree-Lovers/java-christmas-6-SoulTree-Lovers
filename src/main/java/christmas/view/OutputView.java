package christmas.view;

import christmas.model.Calendar;
import christmas.model.Menu;
import christmas.model.Order;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {
    private Calendar myCalendar;
    private Order myOrder;
    public OutputView(Calendar myCalendar, Order myOrder) {
        this.myCalendar = myCalendar;
        this.myOrder = myOrder;
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

    private String formatInteger(Integer price) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(price);
    }
}
