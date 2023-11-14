package christmas.utility;

import java.util.List;

public class Constants {
    public static final String COMMA = ",";
    public static final String LINE = "-";

    // UserException class
    public static final Integer FIRST_ITEM = 0;
    public static final Integer SECOND_ITEM = 1;

    public static final Integer MIN_DATE = 1;
    public static final Integer MAX_DATE = 31;

    // Calendar class
    public static final Integer MENU_FORMAT_LENGTH = 2; // 메뉴이름-수량

    public static final List<Integer> WEEKEND = List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);
    public static final List<Integer> STAR_DAYS = List.of(3, 10, 17, 24, 25, 31);

    // Event class
    public static final Integer MIN_PRICE_FOR_EVENT = 10000;
    public static final Integer CHAMPAGNE_PRICE = 25000;
    public static final Integer CHRISTMAS_DAY = 25;
    public static final Integer MIN_DISCOUNT_RATE_FOR_CHRISTMAS_EVENT = 1000;
    public static final Integer DISCOUNT_RATE_FOR_CHRISTMAS_EVENT_PER_DAY = 100;
    public static final Integer DISCOUNT_RATE_FOR_WEEKDAY_EVENT = 2023;
    public static final Integer DISCOUNT_RATE_FOR_WEEKEND_EVENT = 2023;
    public static final Integer DISCOUNT_RATE_FOR_SPECIAL_EVENT = 1000;
    public static final Integer MIN_PRICE_FOR_FREE_CHAMPAGNE = 120000;
    public static final Integer MIN_TOTAL_DISCOUNT_RATE_FOR_SANTA = 20000;
    public static final Integer MIN_TOTAL_DISCOUNT_RATE_FOR_TREE = 10000;
    public static final Integer MIN_TOTAL_DISCOUNT_RATE_FOR_STAR = 5000;
    public static final Integer INITIAL_PRICE = 0;
    public static final String MAIN = "메인";
    public static final String DESSERT = "디저트";
    public static final String SANTA = "산타";
    public static final String TREE = "트리";
    public static final String STAR = "별";
    public static final String NONE = "없음";

    // InputView class 메시지
    public static final String VISIT_DATE_MESSAGE_1 = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    public static final String VISIT_DATE_MESSAGE_2 = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    public static final String ORDER_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    // OutputView class 메시지
    public static final String WELCOME_MESSAGE_1 = "12월 ";
    public static final String WELCOME_MESSAGE_2 = "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    public static final String ORDER_LIST_MESSAGE = "<주문 메뉴>";
    public static final String PRICE_BEFORE_DISCOUNT_MESSAGE = "<할인 전 총주문 금액>";
    public static final String GIVE_CHAMPAGNE_MESSAGE_1 = "<증정 메뉴>";
    public static final String GIVE_CHAMPAGNE_MESSAGE_2 = "샴페인 1개";
    public static final String DISCOUNT_MESSAGE_1 = "<혜택 내역>";
    public static final String DISCOUNT_MESSAGE_2 = "크리스마스 디데이 할인: ";
    public static final String DISCOUNT_MESSAGE_3 = "평일 할인: ";
    public static final String DISCOUNT_MESSAGE_4 = "주말 할인: ";
    public static final String DISCOUNT_MESSAGE_5 = "특별 할인: ";
    public static final String DISCOUNT_MESSAGE_6 = "증정 이벤트: -25,000원";
    public static final String TOTAL_DISCOUNT_RATE_MESSAGE = "<총혜택 금액>";
    public static final String PRICE_AFTER_DISCOUNT_MESSAGE = "<할인 후 예상 결제 금액>";
    public static final String BADGE_MESSAGE = "<12월 이벤트 배지>";
    public static final String FORMAT_INTEGER_PATTERN = "#,###";
    public static final String SPACE = " ";
    public static final String NUMBER_COUNT = "개";
    public static final String WON = "원";

    // UserException class 에러 메시지
    public static final String ERROR_MESSAGE_DATE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    public static final String ERROR_MESSAGE_ORDER = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
}
