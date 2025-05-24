import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Menu {
    private int size;
    private String typeOfBread;
    private List<Topping> toppings = new ArrayList<>();
    private boolean isToasted;

    private static final double priceOf4 = 5.50;
    private static final double priceOf8 = 7.00;
    private static final double priceOf12 = 8.50;

    public Sandwich(int size, String typeOfBread, List<Topping> toppings, boolean isToasted) {
        this.size = size;
        this.typeOfBread = typeOfBread;
        this.isToasted = isToasted;
        this.toppings = toppings;

    }

    public int getSize() {
        return size;
    }

    public String getTypeOfBread() {
        return switch (typeOfBread) {
            case "1" -> "White";
            case "2" -> "Wheat";
            case "3" -> "Rye";
            default -> "Wrap";
        };
    }

    public void addToppings(Topping topping) {
        toppings.add(topping);
    }

    public double calculatePrice() {
        return 0;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public String dis() {
        String is = "No";
        if (isToasted) {
            is = "Yes";
        }

        return is;
    }

    public String toppingToString() {
        StringBuilder format = new StringBuilder();

        for (Topping topping : toppings) {
            format.append(String.format(topping.toString()));
        }

        return format.toString();
    }

//    @Override
//    public String toString() {
//        return String.format("%-30s %d", "\nSize:", getSize()) +
//                String.format("%-30s %s", "\nBread:", getTypeOfBread()) +
//                toppingToString() +
//                String.format("%-30s %s", "\nToasted", dis());
//
//    }

    @Override
    public String getName() {
        return String.format("%-30s %d", "\nSize:", getSize()) +
                String.format("%-30s %s", "\nBread:", getTypeOfBread()) +
                toppingToString() +
                String.format("%-30s %s", "\nToasted", dis());

    }

    @Override
    public double getPrice() {
        double price = priceOf12;

        if (getTypeOfBread().trim().equalsIgnoreCase("White") || getTypeOfBread().trim().equalsIgnoreCase("Wheat")
                || getTypeOfBread().trim().equalsIgnoreCase("Rye") || getTypeOfBread().trim().equalsIgnoreCase("Wrap")) {
            if (getSize() == 4) {
                price = priceOf4;
            } else if (getSize() == 8) {
                price = priceOf8;
            }
        }

        for (Topping topping : toppings) {
            price += topping.getPrice();
        }

        return price;
    }
}