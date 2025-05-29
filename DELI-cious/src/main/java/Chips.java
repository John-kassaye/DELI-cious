public class Chips implements Menu{
   private String type;

    public Chips(String type) {
        this.type = type;
    }

    public String getType() {
        if (type.trim().equals("1")) {
            return "Potato Chips";
        } else if (type.trim().equals("2")) {
            return "Tortilla Chips";
        } else {
            // Default case defaults to Pita Chips; input is limited to values 1 to 3
            return "Pita Chips";
        }
    }

    @Override
    public String getName() {
        return "-----Chips-----";
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String toString() {
        return String.format("%-30s %s","\nType:",getType());
    }
}
