package christmas.controller;

import christmas.model.Calendar;
import christmas.model.Order;
import java.util.ArrayList;
import java.util.List;

public class PlannerManager {
    private Calendar myCalendar;
    private Order myOrder;
    public PlannerManager(Calendar myCalendar, Order myOrder) {
        this.myCalendar = myCalendar;
        this.myOrder = myOrder;
    }
    public void play() {
        UserIO userIO = new UserIO(myCalendar, myOrder);
        userIO.inputVisitDate();
        userIO.inputOrder();

        userIO.outputWelcomeMessage();
        userIO.outputOrder();
        userIO.outputPriceBeforeDiscount();
    }

}
