import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    @DisplayName("Calculate total price including sandwich, drink, and chips")
    void calculateTotal() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(new PremiumTopping("1",true,4));
        toppings.add(new PremiumTopping("7",true,4));


        Menu menu1 = new Sandwich(4,"White",toppings,"1",true);
        Menu menu2 = new Drink("1","Lemonade");
        Menu menu = new Chips("Chips");

        List<Menu> menus = new ArrayList<>();
        menus.add(menu);
        menus.add(menu1);
        menus.add(menu2);

        Order order = new Order();
        order.addMenu(menus);

        assertEquals(11.55,order.calculateTotal());
    }
}