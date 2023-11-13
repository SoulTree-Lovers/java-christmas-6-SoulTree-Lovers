package christmas;

import christmas.controller.PlannerManager;
import christmas.model.Calendar;
import christmas.model.Menu;

public class Application {
    private static Calendar myCalendar = new Calendar();
    private static Menu myMenu = new Menu();
    private static PlannerManager myPlannerManager = new PlannerManager(myCalendar, myMenu);
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        myPlannerManager.play();
    }
}
