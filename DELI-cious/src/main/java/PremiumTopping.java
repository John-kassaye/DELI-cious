public class PremiumTopping extends Topping {
    private int sandwichSize;

    public PremiumTopping(String name, boolean isExtra, int sandwichSize) {
        super(name, isExtra);
        this.sandwichSize = sandwichSize;
    }

    public int getSandwichSize() {
        return sandwichSize;
    }

    public boolean isMeat() {
        boolean isMeat = false;
        if (getName().equalsIgnoreCase("Steak") ||
                getName().equalsIgnoreCase("Ham") ||
                getName().equalsIgnoreCase("Salami") ||
                getName().equalsIgnoreCase("Roast Beef") ||
                getName().equalsIgnoreCase("Chicken") ||
                getName().equalsIgnoreCase("Bacon")) {
            isMeat = true;
        }

        return isMeat;
    }

    public boolean isCheese() {
        boolean isCheese = false;
        if (getName().equalsIgnoreCase("American") ||
                getName().equalsIgnoreCase("Provolone") ||
                getName().equalsIgnoreCase("Cheddar") ||
                getName().equalsIgnoreCase("Swiss")) {
            isCheese = true;
        }

        return isCheese;
    }

    @Override
    public double getPrice() {
        double basePrice = 0.0;
        double extraPrice = 0.0;

        if (isMeat()) {
            if (getSandwichSize() == 4) {
                basePrice = 1.00;
                extraPrice = 0.50;
            } else if (getSandwichSize() == 8) {
                basePrice = 2.00;
                extraPrice = 1.00;
            } else if (getSandwichSize() == 12) {
                basePrice = 3.00;
                extraPrice = 1.50;
            }
        } else if (isCheese()) {
            if (getSandwichSize() == 4) {
                basePrice = 1.00;
                extraPrice = 0.30;
            } else if (getSandwichSize() == 8) {
                basePrice = 2.00;
                extraPrice = 0.60;
            } else if (getSandwichSize() == 12) {
                basePrice = 3.00;
                extraPrice = 0.90;
            }
        }

        return isExtra() ? basePrice + extraPrice : basePrice;
    }

    @Override
    public String toString() {
        return String.format("%-30s %s", "\nPremium Topping:",getName());
    }
}
