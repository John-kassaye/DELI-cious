public abstract class Topping {
    private String name;
    private boolean isExtra;

    public Topping(String name, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
    }

    public String getName() {
        return switch (name.trim()) {
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

    public boolean isExtra() {
        return isExtra;
    }

    public abstract double getPrice();
}


