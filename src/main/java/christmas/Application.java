package christmas;

import christmas.controller.PlannerManager;
import christmas.model.Calendar;
import christmas.model.Order;

public class Application {
    private static Calendar myCalendar = new Calendar();
    private static Order myOrder = new Order();
    private static PlannerManager myPlannerManager = new PlannerManager(myCalendar, myOrder);
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        myPlannerManager.play();
    }
}
