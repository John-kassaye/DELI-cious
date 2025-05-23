public class PremiumTopping extends Topping{


    public PremiumTopping(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice() {
        return 0;
    }


}
