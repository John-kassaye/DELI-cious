public class Drink implements Menu {
    private int size;
    private String flavor;

    public Drink(int size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public int getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public String toString() {
        return " size: " + size + '\'' +
                " flavor: " + flavor;
    }

    @Override
    public String getName() {
        return getSize() +"\" " + getFlavor();
    }

    @Override
    public double getPrice() {
        return switch (getSize()) {
            case 4 -> 2.00;
            case 8 -> 2.50;
            default -> 3.00;
        };
    }
}
