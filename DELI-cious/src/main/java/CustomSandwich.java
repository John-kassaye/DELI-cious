import java.util.ArrayList;
import java.util.List;

public class CustomSandwich extends Sandwich{

    private static final double priceOf4 = 5.50;
    private static final double priceOf8 = 7.00;
    private static final double priceOf12 = 8.50;

    public CustomSandwich(int size, String typeOfBread, List<Topping> toppings, String sauce, boolean isToasted) {
        super(size, typeOfBread, toppings, sauce, isToasted);
    }

    public static Sandwich createBLT() {
        int size = 8;
        String bread = "1";
        String sauce = "4";

        List<Topping> toppings = new ArrayList<>();
        toppings.add(new PremiumTopping("6",true,size));
        toppings.add(new PremiumTopping("9",true,size));
        toppings.add(new RegularTopping("1",true));
        toppings.add(new RegularTopping("4",true));

        return new Sandwich(size,bread,toppings,sauce,true);
    }

    public static Sandwich createPhillyCheeseSteak() {
        int size = 8;
        String bread = "1";
        String sauce = "1";

        List<Topping> toppings = new ArrayList<>();
        toppings.add(new PremiumTopping("1",true,size));
        toppings.add(new PremiumTopping("7",true,size));
        toppings.add(new RegularTopping("2",true));

        return new Sandwich(size,bread,toppings,sauce,true);
    }

//    @Override
//    public double getPrice() {
//        double price = priceOf12;
//
//        if (getTypeOfBread().trim().equalsIgnoreCase("White") || getTypeOfBread().trim().equalsIgnoreCase("Wheat")
//                || getTypeOfBread().trim().equalsIgnoreCase("Rye") || getTypeOfBread().trim().equalsIgnoreCase("Wrap")) {
//            if (getSize() == 4) {
//                price = priceOf4;
//            } else if (getSize() == 8) {
//                price = priceOf8;
//            }
//        }
//
//        for (Topping topping : getToppings()) {
//            price += topping.getPrice();
//        }
//
//        return price;
//    }
}
