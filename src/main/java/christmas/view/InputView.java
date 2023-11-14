package christmas.view;


import static christmas.utility.Constants.ORDER_MESSAGE;
import static christmas.utility.Constants.VISIT_DATE_MESSAGE_1;
import static christmas.utility.Constants.VISIT_DATE_MESSAGE_2;

public class InputView {
    private InputView() {}

    public static void visitDate()  {
        System.out.println(VISIT_DATE_MESSAGE_1);
        System.out.println(VISIT_DATE_MESSAGE_2);
    }

    public static void order() {
        System.out.println(ORDER_MESSAGE);
    }
}
