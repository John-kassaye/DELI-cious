import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChipsTest {

    @Test
    void getPrice() {
        Chips chips = new Chips("chips");
        assertEquals(1.5,chips.getPrice());
    }
}