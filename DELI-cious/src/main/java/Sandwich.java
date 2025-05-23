
public class Sandwich {
    private int size;
    private String typeOfBread;
    private Topping toppings;

    public Sandwich(int size, String typeOfBread, Topping topping) {
        this.size = size;
        this.typeOfBread = typeOfBread;
        this.toppings = topping;
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

    public Topping getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        return "  size:  " + getSize() + '\'' +
                " typeOfBread:  " + getTypeOfBread();
    }
}