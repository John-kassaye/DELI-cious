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
        for (Menu menu : menus) {
            if (menu instanceof Sandwich sandwich) {
                System.out.println("*****Sandwich*****");
                System.out.println(sandwich);
            } else if (menu instanceof Drink drink) {
                System.out.println("\n*****Drink*****");
                System.out.println(drink);
            } else if (menu instanceof Chips chips) {
                System.out.println("\n*****Chips*****");
                System.out.println(chips);
            }
        }
        System.out.printf("%-30s %.2f","\nHere is your Total: " , calculateTotal());
    }
}
