package christmas.controller;

import christmas.model.Calendar;
import christmas.model.Menu;
import christmas.model.MenuList;

public class PlannerManager {
    private Calendar myCalendar;
    private Menu myMenu;
    public PlannerManager(Calendar myCalendar, Menu myMenu) {
        this.myCalendar = myCalendar;
        this.myMenu = myMenu;
    }
    public void play() {
        // TODO: 프로그램 프로세스 로직 구현
        UserIO userIO = new UserIO(myCalendar, myMenu);
        userIO.InputVisitDate();
        userIO.InputMenu();
    }
}
