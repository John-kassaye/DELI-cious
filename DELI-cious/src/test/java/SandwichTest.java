import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {

    @Test
    void getPrice() {
        Sandwich sandwich = new Sandwich(4,"White",true);
        Sandwich sandwich2 = new Sandwich(8,"Wheat",true);
        Sandwich sandwich3 = new Sandwich(12,"Wrap",false);
        assertEquals(5.5,sandwich.getPrice());
        assertEquals(7,sandwich2.getPrice());
        assertEquals(8.5,sandwich3.getPrice());
    }
}