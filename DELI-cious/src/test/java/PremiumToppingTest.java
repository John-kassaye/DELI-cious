import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PremiumToppingTest {

    @Test
    void getPrice() {
        PremiumTopping premiumTopping = new PremiumTopping("American",false,4);
        PremiumTopping premiumTopping2 = new PremiumTopping("Cheddar",true,8);
        PremiumTopping premiumTopping3 = new PremiumTopping("Steak",false,8);
        PremiumTopping premiumTopping4 = new PremiumTopping("Roast Beef",true,12);

        assertEquals(0.75,premiumTopping.getPrice());
        assertEquals(2.1,premiumTopping2.getPrice());
        assertEquals(2,premiumTopping3.getPrice());
        assertEquals(4.5,premiumTopping4.getPrice());
    }
}