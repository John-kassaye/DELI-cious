import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {

    @Test
    @DisplayName("Calculate sandwich price with premium and regular toppings")
    void getPrice() {
        Topping topping = new PremiumTopping("1",true,4);
        Topping topping2 = new RegularTopping("3",true);

        List<Topping> toppings = new ArrayList<>();
        toppings.add(topping);
        toppings.add(topping2);

        Sandwich sandwich = new Sandwich(4,"White",toppings,"1",true);
        Sandwich sandwich2 = new Sandwich(8,"Wheat",toppings,"2",true);
        Sandwich sandwich3 = new Sandwich(12,"Wrap",toppings,"3",false);

        assertEquals(7,sandwich.getPrice());
        assertEquals(8.5,sandwich2.getPrice());
        assertEquals(10,sandwich3.getPrice());
    }
}