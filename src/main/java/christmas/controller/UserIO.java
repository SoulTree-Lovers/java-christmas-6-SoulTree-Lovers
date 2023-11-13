package christmas.controller;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.Calendar;
import christmas.model.Order;
import christmas.view.InputView;

public class UserIO {
    Calendar myCalendar;
    Order myOrder;
    public UserIO(Calendar myCalendar, Order myOrder) {
        this.myCalendar = myCalendar;
        this.myOrder = myOrder;
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
                myOrder.addOrder(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
