import java.util.List;

public class CustomSandwich extends Sandwich{

    public CustomSandwich(int size, String typeOfBread, List<Topping> toppings, String sauce, boolean isToasted) {
        super(size, typeOfBread, toppings, sauce, isToasted);
    }
}
