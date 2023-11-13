package christmas.view;

import christmas.model.Calendar;
import christmas.model.Order;

public class OutputView {
    private Calendar myCalendar;
    private Order myOrder;
    public OutputView(Calendar myCalendar, Order myOrder) {
        this.myCalendar = myCalendar;
        this.myOrder = myOrder;
    }

    public void priceBeforeDiscount() {

    }
}
