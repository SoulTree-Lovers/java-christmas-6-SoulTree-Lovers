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
        // TODO: 프로그램 프로세스 로직 구현
        UserIO userIO = new UserIO(myCalendar, myOrder);
        userIO.inputVisitDate();
        userIO.inputOrder();
        userIO.outputWelcomeMessage();
        userIO.outputOrder();
        userIO.outputPriceBeforeDiscount();
    }

    private void setStarDays() {
        List<Integer> starDays = List.of(3, 10, 17, 24, 25, 31);
        myCalendar.setStarDay(starDays);
    }
}
