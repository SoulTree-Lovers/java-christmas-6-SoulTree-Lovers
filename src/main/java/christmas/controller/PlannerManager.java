package christmas.controller;

import christmas.model.Calendar;
import christmas.model.Event;
import christmas.model.Order;
import java.util.ArrayList;
import java.util.List;

public class PlannerManager {
    private Calendar myCalendar;
    private Order myOrder;
    private Event myEvent;
    public PlannerManager(Calendar myCalendar, Order myOrder, Event myEvent) {
        this.myCalendar = myCalendar;
        this.myOrder = myOrder;
        this.myEvent = myEvent;
    }
    public void play() {
        UserIO userIO = new UserIO(myCalendar, myOrder, myEvent);
        userIO.inputVisitDate();
        userIO.inputOrder();
        myEvent.calculateAllDiscount();
        userIO.outputWelcomeMessage();
        userIO.outputOrder();
        userIO.outputPriceBeforeDiscount();
        userIO.outputGiveChampagne();
        userIO.outputDiscountList();
        userIO.outputTotalDiscountRate();
        userIO.outputPriceAfterDiscount();
        userIO.outputBadge();
    }

}
