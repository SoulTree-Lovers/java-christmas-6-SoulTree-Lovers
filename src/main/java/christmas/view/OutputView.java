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

    public void orderList() {
        System.out.println("<주문 메뉴>");
        Map<Menu, Integer> orders = myOrder.getOrder();
        for (Map.Entry<Menu, Integer> entry : orders.entrySet()) {
            System.out.println(entry.getKey().getName() + " " + entry.getValue() + "개");
        }
    }

    public void priceBeforeDiscount() {
        Map<Menu, Integer> orders = myOrder.getOrder();
        Integer totalPrice = 0;
        for (Map.Entry<Menu, Integer> entry : orders.entrySet()) {
            Menu menu = entry.getKey();
            Integer quantity = entry.getValue();
            Integer menuPrice = menu.getPrice() * quantity;
            totalPrice += menuPrice;
        }
        System.out.println("할인 전 총 가격: " + totalPrice + "원");
    }
}
