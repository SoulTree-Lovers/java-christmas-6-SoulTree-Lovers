package christmas;

import christmas.controller.PlannerManager;
import christmas.model.Calendar;
import christmas.model.Event;
import christmas.model.Order;

public class Application {
    private static Calendar myCalendar = new Calendar();
    private static Order myOrder = new Order();
    private static Event myEvent = new Event(myCalendar, myOrder);
    private static PlannerManager myPlannerManager = new PlannerManager(myCalendar, myOrder, myEvent);
    public static void main(String[] args) {
        myPlannerManager.play();
    }
}
