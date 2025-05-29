import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class DrinkTest {

    @Test
    @DisplayName("Calculate price of a Lemonade drink")
    public void getPrice() {
        Drink drink = new Drink("12","Lemonade");
        assertEquals(3,drink.getPrice());
    }
}