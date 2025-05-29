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

        menus.forEach(menu -> {
            if (menu != null) {
                System.out.println(menu.getName());
                System.out.println(menu.toString());
            }
        });

        System.out.println("---------------------------------");
        System.out.printf("%-30s $%.2f", "\nHere is your price for order: ", calculateTotal());
    }
}