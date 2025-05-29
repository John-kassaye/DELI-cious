import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);
    public void homeScreen(){
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
        List<Menu> customSandwich = null;
        List<Menu> customSandwich2 = null;

        boolean input = false;

        while (!input) {

            List<Menu> orders = new ArrayList<>();
            String order1 = """
                
                🥪 Order Menu:
                
                1️⃣ - Add Sandwich
                2️⃣ - Add Drink
                3️⃣ - Add chips
                4️⃣ - Custom sandwich BLT
                5️⃣ - Custom Sandwich Philly Cheese Steak
                6️⃣ - Checkout
                7️⃣ - Exit
                """;
            System.out.println(order1);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> sandwich = sandwich();
                case "2" -> drink = drink();
                case "3" -> chips = chips();
                case "4" -> {
                    System.out.println("""
                                
                                BLT
                                
                                o 8" white bread
                                o Bacon
                                o Cheddar
                                o Lettuce
                                o Tomato
                                o Ranch
                                o Toasted
                                """);
                    customSandwich = customSandwich("BLT");
                }
                case "5" -> {
                    System.out.println("""
                                
                                Philly Cheese Steak
                                
                                o 8" white bread
                                o Steak
                                o American Cheese
                                o Peppers
                                o Mayo
                                o Toasted
                                """);
                    customSandwich2 = customSandwich("PHILLY");
                }
                case "6" -> {if (sandwich != null) {
                        orders.addAll(sandwich);
                    }

                    if (drink != null) {
                        orders.addAll(drink);
                    }

                    if (chips != null) {
                        orders.addAll(chips);
                    }

                    if (customSandwich != null){
                        orders.addAll(customSandwich);
                    }

                    if (customSandwich2 != null){
                        orders.addAll(customSandwich2);
                    }

                    if (orders.isEmpty()) {
                        System.out.println("Nothing to checkout.");
                    }

                    Order order = new Order();
                    order.addMenu(orders);
                    menus.add(order);

                    System.out.println("""
                            1 - Add another order
                            2 - Checkout
                            """);
                    String more = scanner.nextLine();

                    if (more.trim().equals("1")){
                        //Solving list duplication issues
                        // I didn't use this at first, and it was working fine until I encountered some scenarios. for instance, if I ordered a drink in order 1
                        // and didn't choose a drink in the next order, it would still show the drink in the second order as well.

                        sandwich = null;
                        drink = null;
                        chips = null;
                        customSandwich = null;
                        customSandwich2 = null;

                        orders = new ArrayList<>();
                    }
                    else if (more.trim().equals("2")) {
                        System.out.println("\n***** Checkout *****");

                        int orderNumber = 1;
                        double totalPrice = 0;

                        Collections.reverse(menus);
                        for (Order o : menus){
                            System.out.println("\n****** Order " + orderNumber + "*****\n");
                            o.display();
                            totalPrice += o.calculateTotal();
                            System.out.println();
                            orderNumber++;
                        }
                        System.out.println("---------------------------------");
                        System.out.printf("%-30s $%.2f","\nHere is your total price: " , totalPrice);

                        boolean isCustomer = false;

                        System.out.println("""
                                
                               
                                Do you have an account with us? 🎉 Customers with an account get a 10% discount!
                                
                                1️⃣ - Yes, I do! Please give me my discount. 💸
                                2️⃣ - No, I don't, but I want to become a customer. 🤝
                                3️⃣ - Thanks, I’ll pass. 🙏
                                """);
                        String customer = scanner.nextLine();

                        if (customer.trim().equals("1")){
                            isCustomer = LoginManagement.signInCheck();
                            if (isCustomer){
                                totalPrice*= 0.9 ;
                                System.out.printf("%-30s %.2f","\nHere is your price after discount: " , totalPrice);
                            }
                        } else if (customer.trim().equals("2")) {
                            LoginManagement.signUp();

                            isCustomer = LoginManagement.signInCheck();
                            if (isCustomer){
                                totalPrice*= 0.9 ;
                                System.out.printf("%-30s %.2f","\nHere is your price after discount: " , totalPrice);
                            }
                            }

                        int people = 1;

                        System.out.println("""
                                
                                Do you want to split the check?
                                1 - yes
                                2 - no
                                """);
                        String split = scanner.nextLine();
                        if (split.trim().equals("1")){
                            System.out.println("How many people?");
                            people = scanner.nextInt();
                            scanner.nextLine();
                            totalPrice/= people;
                            System.out.printf("\n%-30s $%.2f each "," Split between " + people + " people:", totalPrice);
                        }

                        System.out.println("\n1- Confirm ✅\n2- Delete❌");
                        String confirm = scanner.nextLine();
                        if (confirm.trim().equals("1")) {
                            List<Menu> allMenus = new ArrayList<>();
                            menus.forEach( o -> {
                                allMenus.addAll(o.getMenus());
                            });

                            ReceiptManagement.writingReceipt(menus,totalPrice,people);
                            System.out.println("🎉 Order confirmed. Thank you for your purchase!");
                            input = false;
                        }
                    } else {
                            menus.clear();
                            orders.clear();
                    }
                }
                case "7" -> input = true;
                default -> System.out.println("Invalid input please try again.");
            }
        }
    }

    public static List<Menu> customSandwich(String type){

        // I declared it here in case the user doesn't customize all of them.
        // Set defaults
        int size = 8;
        String bread = "1";
        String originalSauce = "";
        String originalMeat = "";
        String originalCheese = "";
        String originalRegular = "";
        String originalRegular2 = "";

        if (type.equals("BLT")) {
            originalMeat = "6";       // Bacon
            originalCheese = "9";     // Default cheese
            originalRegular = "1";    // Lettuce
            originalRegular2 = "4";    // Tomato
            originalSauce = "4";      // Mayo
        } else if (type.equals("PHILLY")) {
            originalMeat = "1";       // Steak
            originalCheese = "7";     // American
            originalRegular = "2";    // Onion
            originalSauce = "1";      // Chipotle
        }


       boolean isMeat = false;
       boolean isCheese = false;
       boolean isRegular = false;

        System.out.println("""
                
                1 - Confirm
                2 - Customize the toppings
                """);
        String choice = scanner.nextLine();
        List<Menu> menuList = new ArrayList<>();

        if (choice.trim().equals("2")) {

            List<Topping> meats = new ArrayList<>();
            List<Topping> cheeses = new ArrayList<>();
            List<Topping> regulars = new ArrayList<>();
            String sauce = originalSauce;

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
                    case "1" -> {
                        meatTopping();
                        String meat = scanner.nextLine();
                        System.out.println("Extra?");
                        String isExtraMeat = scanner.nextLine();
                        boolean extraMeat = isExtraMeat.trim().equals("1");

                        meats.add(new PremiumTopping(meat, extraMeat, size));
                        isMeat = true;
                    }
                    case "2" -> {
                        cheeseTopping();
                        String cheese = scanner.nextLine();
                        System.out.println("Extra?\n1-yes\n2-no");
                        String isExtraCheese = scanner.nextLine();
                        boolean extraCheese = isExtraCheese.trim().equals("1");

                        cheeses.add(new PremiumTopping(cheese, extraCheese, size));
                        isCheese = true;
                    }
                    case "3" -> {
                        regularTopping();
                        String regular = scanner.nextLine();
                        System.out.println("Extra?\n1: yes\n2: no");
                        String isExtraRegular = scanner.nextLine();
                        boolean extraRegular = isExtraRegular.trim().equals("1");

                        regulars.add(new RegularTopping(regular, extraRegular));
                        isRegular = true;
                    }
                    case "4" -> {
                        saucesTopping();
                        sauce = scanner.nextLine();
                    }
                    case "5" -> input = false;
                    default -> System.out.println("Invalid input");
                }


                // this should be outside the loop to prevent duplication
//                if (!isMeat){
//                    meats.add(new PremiumTopping(originalMeat,true,size));
//                }
            }

            // this handle the case where the user doesn't customize all options.
            if (!isMeat) {
                meats.add(new PremiumTopping(originalMeat, true, size));
            }

            if (!isCheese) {
                cheeses.add(new PremiumTopping(originalCheese, true, size));
            }

            if (!isRegular) {
                regulars.add(new RegularTopping(originalRegular, true));
                regulars.add(new RegularTopping(originalRegular2, true));
            }

            toastOption();
            String toasted = scanner.nextLine();
            boolean isToasted = toasted.trim().equals("1");

            List<Topping> toppings = new ArrayList<>();
            toppings.addAll(meats);
            toppings.addAll(cheeses);
            toppings.addAll(regulars);

            menuList.add(new Sandwich(size, bread, toppings, sauce, isToasted));
        }

// Using this block makes the CustomSandwich class unnecessary
//        else {
//            List<Topping> toppings = new ArrayList<>();
//            toppings.add(new PremiumTopping(originalMeat, true, size));
//            toppings.add(new PremiumTopping(originalCheese, true, size));
//            toppings.add(new RegularTopping(originalRegular, true));
//
//            menuList.add(new Sandwich(size, bread, toppings, originalSauce, true));
//        }

        else if (type.trim().equals("PHILLY")) {
            menuList.add(CustomSandwich.createPhillyCheeseSteak());
        } else if (type.trim().equals("BLT")) {
            menuList.add(CustomSandwich.createBLT());
        }

        return menuList;
    }

    public static List<Menu> sandwich() {
        String sandwichBread = """
                
                🍞 Select your bread:
                
                1️⃣ - White
                2️⃣ - Wheat
                3️⃣ - Rye
                4️⃣ - Wrap
                """;
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
                yield 4;     // This one is IntelliJ's suggestion.
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
                case "1" -> {
                    meatTopping();
                    String meat = scanner.nextLine();
                    System.out.println("Extra?");
                    String isExtraMeat = scanner.nextLine();
                    boolean extraMeat = isExtraMeat.trim().equals("1");
                    meats.add(new PremiumTopping(meat, extraMeat, size));
                }
                case "2" -> {
                    cheeseTopping();
                    String cheese = scanner.nextLine();
                    System.out.println("Extra?\n1-yes\n2-no");
                    String isExtraCheese = scanner.nextLine();
                    boolean extraCheese = isExtraCheese.trim().equals("1");
                    cheeses.add(new PremiumTopping(cheese, extraCheese, size));
                }
                case "3" -> {
                    regularTopping();
                    String regular = scanner.nextLine();
                    System.out.println("Extra?\n1: yes\n2: no");
                    String isExtraRegular = scanner.nextLine();
                    boolean extraRegular = isExtraRegular.trim().equals("1");
                    regulars.add(new RegularTopping(regular,extraRegular));
                }
                case "4" -> {
                    saucesTopping();
                    sauce = scanner.nextLine();
                }
                case "5" -> input = false;
                default -> System.out.println("Invalid input");
            }
        }

        toastOption();
        String toasted = scanner.nextLine();
        boolean isToasted = toasted.trim().equals("1");

        List<Topping> toppings = new ArrayList<>();
        toppings.addAll(meats);
        toppings.addAll(cheeses);
        toppings.addAll(regulars);

        List<Menu> menus = new ArrayList<>();
        menus.add(new Sandwich(size, bread, toppings,sauce, isToasted));

        return menus;
    }

    public static List<Menu> drink(){
        String drinkSize = """
               
                🥤 Select drink size:
               
                1️⃣ - Small
                2️⃣ - Medium
                3️⃣ - Large
                """;

        String sizeChoice = "";
        while (true){
            System.out.println(drinkSize);
            sizeChoice = scanner.nextLine();

            if (sizeChoice.trim().equals("1") || sizeChoice.trim().equals("2") || sizeChoice.trim().equals("3")){
                break;
            } else {
                System.out.println("❌ Invalid input. Please enter 1, 2, or 3.");
            }
        }

        String drinkFlavor = """
                
                🥤 Select flavor:
                
                1️⃣ - Lemonade
                2️⃣ - Coke
                3️⃣ - Sprite
                """;
        String flavorChoice = "";
        while (true) {
            System.out.println(drinkFlavor);
            flavorChoice = scanner.nextLine();

            if (flavorChoice.trim().equals("1") || flavorChoice.trim().equals("2") || flavorChoice.trim().equals("3")){
                break;
            } else {
                System.out.println("❌ Invalid input. Please enter 1, 2, or 3.");
            }
        }

        List<Menu> drinks = new ArrayList<>();
        drinks.add(new Drink(sizeChoice,flavorChoice));
        return drinks;
    }

    public static List<Menu> chips() {
        String chip = """
                
                🍟 select chips type:
                
                1️⃣ - Potato Chips
                2️⃣ - Tortilla Chips
                3️⃣ - Pita Chips
                """;
        String type = "";
        while (true) {
            System.out.println(chip);
            type = scanner.nextLine();

            if (type.equals("1") || type.equals("2") || type.equals("3")) {
                break;
            } else {
                System.out.println("❌ Invalid input. Please enter 1, 2, or 3.");
            }
        }

        List<Menu> chips = new ArrayList<>();
        chips.add(new Chips(type));
        return chips;
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

    public static void saucesTopping(){
        String sauces = """
                
                🧂 Sauces:
                
                1️⃣ - Mayo
                2️⃣ - Mustard
                3️⃣ - Ketchup
                4️⃣ - Ranch
                5️⃣ - Thousand Islands
                6️⃣ - Vinaigrette
                """;
        System.out.println(sauces);
    }

    public static void toastOption(){
        System.out.println("""
                
                \uD83D\uDD25 Would you like it toasted??
                1 - Yes
                2 - no
                """);
    }
}
