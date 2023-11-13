package christmas.controller;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.Calendar;
import christmas.model.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

public class UserIO {
    private OutputView outputView;
    private Calendar myCalendar;
    private Order myOrder;
    public UserIO(Calendar myCalendar, Order myOrder) {
        this.myCalendar = myCalendar;
        this.myOrder = myOrder;
        this.outputView = new OutputView(myCalendar, myOrder);
    }

    public void inputVisitDate() {
        InputView.visitDate();
        while (true) {
            try {
                String userInput = Console.readLine();
                Integer visitDate = Integer.parseInt(userInput);
                myCalendar.setVisitDate(visitDate);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputOrder() {
        InputView.order();
        while (true) {
            try {
                String userInput = Console.readLine();
                myOrder.addOrder(userInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        myOrder.calculatePriceBeforeDiscount();
    }

    public void outputWelcomeMessage() {
        outputView.welcomeMessage();
    }

    public void outputOrder() {
        outputView.orderList();
    }

    public void outputPriceBeforeDiscount() {
        outputView.priceBeforeDiscount();
    }
}
