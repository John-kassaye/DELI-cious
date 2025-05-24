import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void calculateTotal() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(new PremiumTopping("Steak",true,4));
        toppings.add(new PremiumTopping("American",true,8));


        Menu menu1 = new Sandwich(4,"White",toppings,true);
        Menu menu2 = new Drink(4,"Lemonade");
        Menu menu = new Chips("Chips");

        Order order = new Order();
        order.addMenu(menu);
        order.addMenu(menu1);
        order.addMenu(menu2);

        assertEquals(7.1,order.calculateTotal());
    }
}