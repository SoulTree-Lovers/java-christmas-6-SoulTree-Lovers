package christmas.model;

import static christmas.utility.Constants.COMMA;
import static christmas.utility.Constants.LINE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private List<Map<MenuList, Integer>> order;
    public Menu() {
        this.order = new ArrayList<>();
    }

    public void setOrder(List<Map<MenuList, Integer>> order) {
        this.order = order;
    }

    public List<Map<MenuList, Integer>> getOrder() {
        return this.order;
    }

    public void addOrder(String userInput) {
        String[] menus = userInput.split(COMMA);
        Map<MenuList, Integer> currOrder = new HashMap<>();
        for (String menu : menus) {
            String[] currMenu = menu.trim().split(LINE);
            String menuName = currMenu[0].trim();
            Integer quantity = Integer.parseInt(currMenu[1].trim());
            addMenu(currOrder, menuName, quantity);
        }
        this.order.add(currOrder);
    }

    private void addMenu(Map<MenuList, Integer> order, String menuName, Integer quantity) {
        for (MenuList menu : MenuList.values()) {
            if (menu.getName().equals(menuName)) {
                order.put(menu, quantity);
                break;
            }
        }
    }
}
