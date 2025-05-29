import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChipsTest {

    @Test
    @DisplayName("Calculate total price for chips")
    void getPrice() {
        Chips chips = new Chips("chips");
        assertEquals(1.5,chips.getPrice());
    }
}