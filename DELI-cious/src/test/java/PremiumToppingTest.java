import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PremiumToppingTest {

    @Test
    @DisplayName("Verify price calculation for PremiumToppings")
    void getPrice() {
        PremiumTopping premiumTopping = new PremiumTopping("7",true,4);
        PremiumTopping premiumTopping2 = new PremiumTopping("9",false,8);
        PremiumTopping premiumTopping3 = new PremiumTopping("1",true,8);
        PremiumTopping premiumTopping4 = new PremiumTopping("4",true,12);

        assertEquals(1.05,premiumTopping.getPrice());
        assertEquals(1.5,premiumTopping2.getPrice());
        assertEquals(3,premiumTopping3.getPrice());
        assertEquals(4.5,premiumTopping4.getPrice());
    }
}