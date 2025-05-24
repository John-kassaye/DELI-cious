import java.util.ArrayList;
import java.util.List;

public class Order {
    List<Menu> menus = new ArrayList<>();

    public void addMenu(Menu menu){
        menus.add(menu);
    }

    public double calculateTotal(){
        double price = 0;
        for (Menu menu : menus){
            price+= menu.getPrice();
        }

        return price;
    }

    public void display(){
        for (Menu menu : menus){
            System.out.println(menu);
        }

        System.out.printf("%-30s %.2f","\nHere is your Total: " , calculateTotal());
    }
}
