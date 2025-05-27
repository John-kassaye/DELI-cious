import java.util.ArrayList;
import java.util.List;

public class Order {
    List<Menu> menus = new ArrayList<>();

    public void addMenu(List<Menu> menu) {
        if (menu != null) {
            this.menus.addAll(menu);
        }
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public double calculateTotal() {
        double price = 0;
        for (Menu menu : menus) {
            price += menu.getPrice();
        }

        return price;
    }

    public void display() {
        if (menus == null || menus.isEmpty()){
            System.out.println("No items in order");
            return;
        }

        for (Menu menu : menus) {
            if (menu != null) {
                if (menu instanceof Sandwich sandwich) {
                    System.out.println("*****Sandwich*****");
                    System.out.println(sandwich.getName());
                } else if (menu instanceof Drink drink) {
                    System.out.println("\n*****Drink*****");
                    System.out.println(drink.getName());
                } else if (menu instanceof Chips chips) {
                    System.out.println("\n*****Chips*****");
                    System.out.println(chips.getName());
                }
            }
        }
        System.out.printf("%-30s %.2f", "\nHere is your Total: ", calculateTotal());
    }
}