import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Menu {
    private int size;
    private String typeOfBread;
    private List<Topping> toppings = new ArrayList<>();
    private boolean toasted;
    private String sauce;

    private static final double priceOf4 = 5.50;
    private static final double priceOf8 = 7.00;
    private static final double priceOf12 = 8.50;

    public Sandwich(int size, String typeOfBread, List<Topping> toppings, String sauce,boolean isToasted) {
        this.size = size;
        this.typeOfBread = typeOfBread;
        this.toasted = isToasted;
        this.toppings = toppings;
        this.sauce = sauce;
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

    public List<Topping> getToppings() {
        return toppings;
    }

    public void addToppings(Topping topping) {
        toppings.add(topping);
    }

    public double calculatePrice() {
        return 0;
    }

    public boolean isToasted() {
        return toasted;
    }

    public String getToast() {
        String is = "No";
        if (toasted) {
            is = "Yes";
        }

        return is;
    }

    public String toppingToString() {
        StringBuilder format = new StringBuilder();

        toppings.forEach(topping -> {
            format.append(String.format(topping.toString()));
        });

        return format.toString();
    }

    public String getSauce() {
        return switch (sauce.trim()) {
            case "1" -> "Mayo";
            case "2" -> "Mustard";
            case "3" -> "Ketchup";
            case "4" -> "Ranch";
            case "5" -> "Thousand Islands";
            case "6" -> "Vinaigrette";
            default -> "No sauce";
        };
    }

    public void removeTopping(String toppingName) {
        toppings.removeIf(t -> t.getName().equalsIgnoreCase(toppingName));
    }


    @Override
    public String getName() {
        return "*****Sandwich*****";
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

    @Override
    public String toString() {
        return String.format("%-30s %d", "\nSize:", getSize()) + "\"" +
                String.format("%-30s %s", "\nBread:", getTypeOfBread()) +
                toppingToString() +
                String.format("%-30s %s", "\nSauce:", getSauce()) +
                String.format("%-30s %s", "\nToasted:", getToast());
    }
}