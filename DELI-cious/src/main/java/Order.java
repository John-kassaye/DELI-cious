import java.util.ArrayList;
import java.util.List;

public class Order {
    List<Menu> menus = new ArrayList<>();

    public void addMenu(Menu menu){
        menus.add(menu);
    }

    public double calculateTotal(){
        return 0;
    }

    public void display(){

    }
}
