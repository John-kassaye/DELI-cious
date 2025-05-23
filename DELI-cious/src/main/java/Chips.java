public class Chips implements Menu{
   private String type;
   private double price;

    public Chips(String type, double price) {
        this.type = type;
        this.price = price;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
