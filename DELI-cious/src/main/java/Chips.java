public class Chips implements Menu{
   private String type;

    public Chips(String type) {
        this.type = type;
    }

    public String getType() {
        // I used the default Pita chips because I won't get a number greater than 3 in the first place
        if (type.trim().equals("1")) {
            return "Potato Chips";
        } else if (type.trim().equals("2")) {
            return "Tortilla Chips";
        } else {
            return "Pita Chips";
        }
    }

    @Override
    public String getName() {
        return String.format("-----Chips-----") +
                String.format("%-30s %s","\nType:",getType());
    }

    @Override
    public double getPrice() {
        return 1.50;
    }
}
