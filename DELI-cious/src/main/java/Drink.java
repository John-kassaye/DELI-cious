public class Drink implements Menu {
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public String getSize() {
        if (size.trim().equals("1")){
            return "Small";
        } else if (size.trim().equals("2")) {
            return "Medium";
        } else {
            return "Large";
        }
    }

    public String getFlavor() {
        if (flavor.trim().equals("1")){
            return "Lemonade";
        } else if (flavor.trim().equals("2")) {
            return "Coke";
        } else {
            return "Sprite";
        }
    }

    @Override
    public String getName() {
       return "*****Drink*****";

    }

    @Override
    public double getPrice() {
        return switch (getSize()) {
            case "Small" -> 2.00;
            case "Medium" -> 2.50;
            default -> 3.00;
        };
    }

    @Override
    public String toString() {
        return String.format("%-30s %s","\nSize:",getSize()) +"\"" +
                String.format("%-30s %s","\nFlavor:",getFlavor());
    }
}
