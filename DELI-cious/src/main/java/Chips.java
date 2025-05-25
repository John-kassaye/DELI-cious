public class Chips implements Menu{
   private String type;

    public Chips(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getName() {
        return String.format("%-30s %s","\nType",getType()) +
                String.format("%-30s %s","\nPrice",getPrice());
    }

    @Override
    public double getPrice() {
        return 1.50;
    }
}
