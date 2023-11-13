package christmas.view;

import christmas.model.Calendar;
import christmas.model.Menu;
import christmas.model.Order;
import java.util.List;
import java.util.Map;

public class OutputView {
    private Calendar myCalendar;
    private Order myOrder;
    public OutputView(Calendar myCalendar, Order myOrder) {
        this.myCalendar = myCalendar;
        this.myOrder = myOrder;
    }

    public void priceBeforeDiscount() {
        System.out.println("<주문 메뉴>");
        Map<Menu, Integer> orders = myOrder.getOrder();
        for (Map.Entry<Menu, Integer> entry : orders.entrySet()) {
            System.out.println(entry.getKey().getName() + " " + entry.getValue() + "개");
        }
    }

}
