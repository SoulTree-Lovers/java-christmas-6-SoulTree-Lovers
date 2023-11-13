package christmas.controller;

import static christmas.utility.Constants.COMMA;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.Calendar;
import christmas.model.Menu;
import christmas.model.MenuList;
import christmas.view.InputView;
import java.util.HashMap;
import java.util.Map;

public class UserIO {
    Calendar myCalendar;
    Menu myMenu;
    public UserIO() {
        myCalendar = new Calendar();
        myMenu = new Menu();
    }

    public void InputVisitDate() {
        InputView.visitDate();
        while (true) {
            try {
                String userInput = Console.readLine();
                Integer visitDate = Integer.parseInt(userInput);
                myCalendar.setVisitDate(visitDate);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void InputMenu() {
        InputView.order();
        while (true) {
            try {
                String userInput = Console.readLine();
                myMenu.addOrder(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
