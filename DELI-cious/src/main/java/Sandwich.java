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

    public Sandwich(int size, String typeOfBread, boolean isToasted) {
        this.size = size;
        this.typeOfBread = typeOfBread;
        this.isToasted = isToasted;
    }

    public int getSize() {
     return size;
    }

    public String getTypeOfBread() {
        return typeOfBread;
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
        return getSize() + "\" "+ getTypeOfBread() + " Sandwich" ;
    }

    @Override
    public double getPrice() {
       double price = priceOf12;

        if (getTypeOfBread().trim().equalsIgnoreCase("White") || getTypeOfBread().trim().equalsIgnoreCase("Wheat")
                || getTypeOfBread().trim().equalsIgnoreCase("Rye") || getTypeOfBread().trim().equalsIgnoreCase("Wrap")){
            if (getSize() == 4){
                price = priceOf4;
            } else if (getSize() == 8) {
                price = priceOf8;
            }
        }

        return price;

    }
}