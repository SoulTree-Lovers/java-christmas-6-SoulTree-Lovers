package christmas.model;

import static christmas.utility.Constants.COMMA;
import static christmas.utility.Constants.LINE;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<Menu, Integer> order;
    private Integer priceBeforeDiscount;
    private Integer priceAfterDiscount;
    public Order() {
        this.order = new HashMap<>();
    }

    public void setOrder(Map<Menu, Integer> order) {
        this.order = order;
    }

    public Map<Menu, Integer> getOrder() {
        return this.order;
    }

    public Integer getPriceBeforeDiscount() {
        return this.priceBeforeDiscount;
    }

    public Integer getPriceAfterDiscount() {
        return this.priceAfterDiscount;
    }

    public void calculatePriceBeforeDiscount() {
        Integer totalPrice = 0;
        for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
            Menu menu = entry.getKey();
            Integer quantity = entry.getValue();
            Integer menuPrice = menu.getPrice() * quantity;
            totalPrice += menuPrice;
        }
        this.priceBeforeDiscount = totalPrice;
    }

    public void addOrder(String userInput) {
        String[] menus = userInput.split(COMMA);
        for (String menu : menus) {
            String[] currMenu = menu.trim().split(LINE);
            String menuName = currMenu[0].trim();
            Integer quantity = Integer.parseInt(currMenu[1].trim());
            addMenu(menuName, quantity);
        }
    }

    private void addMenu(String menuName, Integer quantity) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equals(menuName)) {
                order.put(menu, quantity);
                break;
            }
        }
    }
}
