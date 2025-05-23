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
        return "";
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
