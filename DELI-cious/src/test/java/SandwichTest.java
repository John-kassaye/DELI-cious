import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {

    @Test
    void getPrice() {
        Topping topping = new PremiumTopping("Steak",true,4);
        Topping topping2 = new RegularTopping("Steak",true);

        List<Topping> toppings = new ArrayList<>();
        toppings.add(topping);
        toppings.add(topping2);

        Sandwich sandwich = new Sandwich(4,"White",toppings,true);
        Sandwich sandwich2 = new Sandwich(8,"Wheat",toppings,true);
        Sandwich sandwich3 = new Sandwich(12,"Wrap",toppings,false);
        assertEquals(5.5,sandwich.getPrice());
        assertEquals(7,sandwich2.getPrice());
        assertEquals(8.5,sandwich3.getPrice());
    }
}