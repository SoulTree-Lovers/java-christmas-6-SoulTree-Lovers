package christmas.controller;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.Calendar;
import christmas.view.InputView;

public class UserIO {
    public UserIO() {}

    public void InputVisitDate() {
        InputView.visitDate();
        Calendar myCalendar = new Calendar();
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
}
