import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        homeScreen();

    }

    public static void homeScreen(){
        String homeScreen = """
                             Welcome to the DELICIOUS
                
                1️⃣ - New Order
                2️⃣ - Exit
                """;
        System.out.println(homeScreen);
        String order = scanner.nextLine();

        if (order.equalsIgnoreCase("1")){
            orderScreen();
        } else {
            System.exit(0);
        }
    }

    public static void orderScreen() {

        List<Order> menus = new ArrayList<>();

        List<Menu> sandwich= null;
        List<Menu> drink = null;
        List<Menu> chips = null;

        boolean input = false;

        while (!input) {

            List<Menu> orders = new ArrayList<>();
            String order1 = """
                
                🥪 Order Menu:
                
                1️⃣ - Add Sandwich
                2️⃣ - Add Drink
                3️⃣ - Add chips
                4️⃣ - Checkout
                5 - Custom Sandwich
                5️⃣ - Exit
                """;
            System.out.println(order1);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    sandwich = sandwich();
                    break;
                case "2":
                    drink = drink();
                    break;
                case "3":
                    chips = chips();
                    break;
                case "4":

                    if (sandwich != null) {
                        orders.addAll(sandwich);
                    }

                    if (drink != null) {
                        orders.addAll(drink);
                    }

                    if (chips != null) {
                        orders.addAll(chips);
                    }

                    if (sandwich == null && drink == null && chips == null) {
                        System.out.println("Nothing to checkout.");
                    }

                    Order order = new Order();
                    order.addMenu(orders);
                    menus.add(order);

                    System.out.println("Do you want to add another order?\n1- Yes\n2- No");
                    String more = scanner.nextLine();

                    if (!more.trim().equals("1")) {
                        System.out.println("\n***** Checkout *****");

                        int orderNumber = 1;
                        for (Order o : menus){
                            System.out.println("\n****** Order " + orderNumber + "*****\n");
                            o.display();
                            System.out.println();
                            orderNumber++;
                        }

                        System.out.println("\n1- Confirm\n2- Delete");
                        String confirm = scanner.nextLine();
                        if (confirm.trim().equals("1")) {
                            List<Menu> allMenus = new ArrayList<>();

                            for (Order o : menus){
                                allMenus.addAll(o.getMenus());
                            }
                            ReceiptManagement.writingReceipt(allMenus);
                            input = false;
                        } else {
                            menus.clear();
                        }
                    }
                    break;


                case "5":
                    input = true;
                    break;
                case "6":
                    customSandwich();
                    break;
                default:
                    System.out.println("Invalid input please try again.");
                    break;
            }
        }
    }

    public static void customSandwich(){
       String bread = "1";
       int size = 8;
       String originalMeat = "6";
       String originalCheese = "9";
       String originalRegular = "1";
       String originalSauce = "4";

       String blt = """
                
                o 8" white bread
                o Bacon
                o Cheddar
                o Lettuce
                o Tomato
                o Ranch
                o Toasted
                """;
        System.out.println(blt);
        System.out.println("""
                1 - Confirm
                2 - Customize the toppings
                """);
        String choice = scanner.nextLine();
        if (choice.trim().equals("2")){

            List<Topping> meats = new ArrayList<>();
            List<Topping> cheeses = new ArrayList<>();
            List<Topping> regulars = new ArrayList<>();
            String sauce = "4";

            boolean input = true;
            while (input) {
                String sandwichTopping = """
                    
                    Add Sandwich Options:
                    
                    1️⃣ - 🥩 Add Meats
                    2️⃣ - 🧀 Add Cheese
                    3️⃣ - 🥗 Add Other Toppings
                    4️⃣ - 🧂 Add Sauces
                    5️⃣ - 🔙 back
                    """;

                System.out.println(sandwichTopping);
                String topping = scanner.nextLine();

                switch (topping) {
                    case "1":
                        meatTopping();
                        String meat = scanner.nextLine();
                        System.out.println("Extra?");
                        String isExtraMeat = scanner.nextLine();
                        boolean extraMeat = isExtraMeat.trim().equals("1") ? true : false;

                        if (meat != null){
                            meats.add(new PremiumTopping(meat,extraMeat,size));}
                        else {
                            meats.add(new PremiumTopping(originalMeat,extraMeat,size));
                        }
                        break;
                    case "2":
                        cheeseTopping();
                        String cheese = scanner.nextLine();
                        System.out.println("Extra?\n1-yes\n2-no");
                        String isExtraCheese = scanner.nextLine();
                        boolean extraCheese = isExtraCheese.trim().equals("1") ? true : false;

                        if (cheese != null){
                            cheeses.add(new PremiumTopping(cheese,extraCheese,size));}
                        else {
                            cheeses.add(new PremiumTopping(originalCheese,extraCheese,size));
                        }
                        break;
                    case "3":
                        regularTopping();
                        String regular = scanner.nextLine();
                        System.out.println("Extra?\n1: yes\n2: no");
                        String isExtraRegular = scanner.nextLine();
                        boolean extraRegular = isExtraRegular.trim().equals("1") ? true : false;

                        if (regular != null){
                            regulars.add(new RegularTopping(regular,extraRegular));}
                        else {
                            regulars.add(new RegularTopping(originalRegular,extraRegular));
                        }
                        break;
                    case "4":
                        saucesTopping();
                        sauce = scanner.nextLine();
                        break;
                    case "5":
                        input = false;
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            }

            System.out.println(" \n" +
                    "\uD83D\uDD25 Is toasted");
            String toasted = scanner.nextLine();
            boolean isToasted = toasted.trim().equals("1") ? true : false;

            List<Topping> toppings = new ArrayList<>();
            toppings.addAll(meats);
            toppings.addAll(cheeses);
            toppings.addAll(regulars);

            List<Menu> menuList = new ArrayList<>();
            if (sauce != null){
                menuList.add(new Sandwich(size,bread,toppings,sauce,isToasted));}
            else {
                menuList.add(new Sandwich(size,bread,toppings,originalSauce,isToasted));
            }

            for (Menu menu : menuList){
                System.out.println(menu.getName());
            }
        }
    }

    public static List<Menu> sandwich() {
        String sandwichBread = """
                
                🍞 Select your bread:
                
                1️⃣ - White
                2️⃣ - Wheat
                3️⃣ - Rye
                4️⃣ - Wrap""";
        System.out.println(sandwichBread);
        String bread = scanner.nextLine();

        String sandwichSize = """
                
                📏 Select sandwich size:
                
                1️⃣ - 4"
                2️⃣ - 8"
                3️⃣ - 12"
                """;
        System.out.println(sandwichSize);
        String sizeChoice = scanner.nextLine();
        int size = switch (sizeChoice) {
            case "1" -> 4;
            case "2" -> 8;
            case "3" -> 12;
            default -> {
                System.out.println("Invalid choice. Defaulting to 4\"");
                yield 4;
            }
        };
        List<Topping> meats = new ArrayList<>();
        List<Topping> cheeses = new ArrayList<>();
        List<Topping> regulars = new ArrayList<>();
        String sauce = "";

        boolean input = true;
        while (input) {
            String sandwichTopping = """
                    
                    Add Sandwich Options:
                    
                    1️⃣ - 🥩 Add Meats
                    2️⃣ - 🧀 Add Cheese
                    3️⃣ - 🥗 Add Other Toppings
                    4️⃣ - 🧂 Add Sauces
                    5️⃣ - 🔙 back
                    """;

            System.out.println(sandwichTopping);
            String topping = scanner.nextLine();

            switch (topping) {
                case "1":
                    meatTopping();
                    String meat = scanner.nextLine();
                    System.out.println("Extra?");
                    String isExtraMeat = scanner.nextLine();
                    boolean extraMeat = isExtraMeat.trim().equals("1") ? true : false;
                    meats.add(new PremiumTopping(meat,extraMeat,size));
                    break;
                case "2":
                    cheeseTopping();
                    String cheese = scanner.nextLine();
                    System.out.println("Extra?\n1-yes\n2-no");
                    String isExtraCheese = scanner.nextLine();
                    boolean extraCheese = isExtraCheese.trim().equals("1") ? true : false;
                    cheeses.add(new PremiumTopping(cheese,extraCheese,size));
                    break;
                case "3":
                    regularTopping();
                    String regular = scanner.nextLine();
                    System.out.println("Extra?\n1: yes\n2: no");
                    String isExtraRegular = scanner.nextLine();
                    boolean extraRegular = isExtraRegular.trim().equals("1") ? true : false;
                    regulars.add(new RegularTopping(regular,extraRegular));
                    break;
                case "4":
                    saucesTopping();
                    sauce = scanner.nextLine();
                    break;
                case "5":
                    input = false;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }

        System.out.println(" \n" +
                "\uD83D\uDD25 Is toasted");
        String toasted = scanner.nextLine();
        boolean isToasted = toasted.trim().equals("1") ? true : false;

        List<Topping> toppings = new ArrayList<>();
        toppings.addAll(meats);
        toppings.addAll(cheeses);
        toppings.addAll(regulars);

        List<Menu> menus = new ArrayList<>();
        menus.add(new Sandwich(size, bread, toppings, sauce, isToasted));

        return menus;
    }

    public static List<Menu> drink(){
        String drinkSize = """
               
                 🥤 Select drink size:
               
                1️⃣ - Small
                2️⃣ - Medium
                3️⃣ - Large""";
        System.out.println(drinkSize);
        String sizeChoice = scanner.nextLine();
        int size = 12;
        if (sizeChoice.trim().equals("1")){
            size = 4;
        } else if (sizeChoice.trim().equals("2")) {
            size = 8;
        }

        String drinkFlavor = """
                
                🥤 Select flavor:
                
                1️⃣ - Lemonade
                2️⃣ - Coca
                """;
        System.out.println(drinkFlavor);
        String flavorChoice = scanner.nextLine();
        String flavor = "Coca";

        if (flavorChoice.trim().equals("1")){
            flavor = "Lemonade";
        }

        List<Menu> drinks = new ArrayList<>();
        drinks.add(new Drink(size,flavor));
        return drinks;
    }

    public static List<Menu> chips(){
        String chips = """
                
                🍟 select chips type:
                
                1️⃣ - Potato Chips
                2️⃣ - Tortilla Chips
                3️⃣ - Pita Chips
                """;
        System.out.println(chips);
        String type = scanner.nextLine();
        List<Menu> chipses = new ArrayList<>();
        chipses.add(new Chips(type));
        return chipses;
    }

    public static void meatTopping() {

        String topping = """
                
                🥩 Meats:
                
                1️⃣ - steak
                2️⃣ - ham
                3️⃣ - salami
                4️⃣ - roast beef
                5️⃣ - chicken
                6️⃣ - bacon""";
        System.out.println(topping);
    }
    public static void cheeseTopping(){
        String cheese = """
               
                🧀 Cheeses:
                
                7️⃣ - american
                8️⃣ - provolone
                9️⃣ - cheddar
                🔟 - swiss""";
        System.out.println(cheese);
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
                9️⃣ - mushrooms""";
        System.out.println(regular);
    }

    public static void saucesTopping(){
        String sauces = """
                
                🧂 Sauces:
                
                1️⃣ - Mayo
                2️⃣ - Mustard
                3️⃣ - Ketchup
                4️⃣ - Ranch
                5️⃣ - Thousand Islands
                6️⃣ - Vinaigrette""";
        System.out.println(sauces);
    }
}
