import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Menu{
    private int size;
    private String typeOfBread;
    private List<Topping> toppings = new ArrayList<>();
    private boolean isToasted;

    private static final double priceOf4 = 5.50;
    private static final double priceOf8 = 7.00;
    private static final double priceOf12 = 8.50;

    public Sandwich(int size, String typeOfBread, List<Topping> topping, boolean isToasted) {
        this.size = size;
        this.typeOfBread = typeOfBread;
        this.toppings = topping;
        this.isToasted = isToasted;
    }

    public int getSize() {
        if (size == 1) {
            return 4;
        } else if (size == 2) {
            return 8;
        } else if (size == 3) {
            return 12;
        }

        return 0;
    }

    public String getTypeOfBread() {
        return switch (typeOfBread.trim()) {
            case "1" -> "White";
            case "2" -> "Wheat";
            case "3" -> "Rye";
            case "4" -> "Wrap";
            default -> typeOfBread;
        };
    }

    public void addToppings(Topping topping) {
        toppings.add(topping);
    }

    public double calculatePrice(){
        return 0;
    }

    @Override
    public String toString() {
        return "  size:  " + getSize() + '\'' +
                " typeOfBread:  " + getTypeOfBread();
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public double getPrice() {
        if (getSize() == 4){
            return priceOf4;
        } else if (getSize() == 8) {
            return getPrice();
        } else {
            return priceOf12;
        }
    }
}