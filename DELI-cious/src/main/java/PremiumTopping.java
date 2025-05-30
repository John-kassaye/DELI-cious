public class PremiumTopping extends Topping {
    private int sandwichSize;

    public PremiumTopping(String name, boolean isExtra, int sandwichSize) {
        super(name, isExtra);
        this.sandwichSize = sandwichSize;
    }

    public String getName(){
        return switch (getTopName().trim()) {
            case "1" -> "Steak";
            case "2" -> "Ham";
            case "3" -> "Salami";
            case "4" -> "Roast Beef";
            case "5" -> "Chicken";
            case "6" -> "Bacon";
            case "7" -> "American";
            case "8" -> "Provolone";
            case "9" -> "Cheddar";
            default -> "Swiss";
        };
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
                extraPrice = 0.5;
            } else if (getSandwichSize() == 8) {
                basePrice = 2.00;
                extraPrice = 1.00;
            } else if (getSandwichSize() == 12) {
                basePrice = 3.00;
                extraPrice = 1.50;
            }
        } else if (isCheese()) {
            if (getSandwichSize() == 4) {
                basePrice = 0.75;
                extraPrice = 0.30;
            } else if (getSandwichSize() == 8) {
                basePrice = 1.5;
                extraPrice = 0.60;
            } else if (getSandwichSize() == 12) {
                basePrice = 2.25;
                extraPrice = 0.90;
            }
        }

        return isExtra() ? basePrice + extraPrice : basePrice;
    }

    @Override
    public String toString() {
        return String.format("%-30s %s", "\nPremium Topping:",getName());
    }

    public static void meatTopping() {

        String topping = """
                
                🥩 Meats:
                
                1️⃣ - steak
                2️⃣ - ham
                3️⃣ - salami
                4️⃣ - roast beef
                5️⃣ - chicken
                6️⃣ - bacon
                """;
        System.out.println(topping);
    }

    public static void cheeseTopping(){
        String cheese = """
               
                🧀 Cheeses:
                
                7️⃣ - american
                8️⃣ - provolone
                9️⃣ - cheddar
                🔟 - swiss
                """;
        System.out.println(cheese);
    }
}
