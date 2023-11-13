package christmas.model;

public enum Menu {
    MUSHROOM_SOUP("양송이수프", 6000, "애피타이저"),
    TAPAS("타파스", 5500, "애피타이저"),
    CAESAR_SALAD("시저샐러드", 8000, "애피타이저"),
    T_BONE_STEAK("티본스테이크", 55000, "메인"),
    BBQ_RIBS("바비큐립", 54000, "메인"),
    SEAFOOD_PASTA("해산물파스타", 35000, "메인"),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, "메인"),
    CHOCOLATE_CAKE("초코케이크", 15000, "디저트"),
    ICE_CREAM("아이스크림", 5000, "디저트"),
    ZERO_COLA("제로콜라", 3000, "음료"),
    RED_WINE("레드와인", 60000, "음료"),
    CHAMPAGNE("샴페인", 25000, "음료");

    private final String name;
    private final Integer price;
    private final String type;

    Menu(final String name, final Integer price, final String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}
