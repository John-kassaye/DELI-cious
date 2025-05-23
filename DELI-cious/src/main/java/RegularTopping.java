public class RegularTopping extends Topping{
    public RegularTopping(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
