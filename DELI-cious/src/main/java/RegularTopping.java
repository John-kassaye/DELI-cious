public class RegularTopping extends Topping{
    public RegularTopping(String name, boolean isExtra) {
        super(name, isExtra);
    }

    public String getName() {
        return switch (getTopName().trim()) {
            case "1" -> "lettuce";
            case "2" -> "peppers";
            case "3" -> "onions";
            case "4" -> "tomatoes";
            case "5" -> "jalapeños";
            case "6" -> "cucumbers";
            case "7" -> "pickles";
            case "8" -> "guacamole";
            default -> "mushrooms";
        };

    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String toString(){
        return String.format("%-30s %s","\nRegular topping",getName());
    }

    public static void regularTopping(){
        String regular = """
                
                🥬 Regular Toppings:
                
                1️⃣ - lettuce
                2️⃣ - peppers
                3️⃣ - onions
                4️⃣ - tomatoes
                5️⃣ - jalapeños
                6️⃣ - cucumbers
                7️⃣ - pickles
                8️⃣ - guacamole
                9️⃣ - mushrooms
                """;
        System.out.println(regular);
    }
}
