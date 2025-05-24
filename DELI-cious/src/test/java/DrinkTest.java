import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DrinkTest {

    @Test
    public void getPrice() {
        Drink drink = new Drink(12,"Lemonade");
        assertEquals(3,drink.getPrice());
    }
}