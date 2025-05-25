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
                
                1- New Order
                2- Exit
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
                
                1- Add Sandwich
                2- Add Drink
                3- Add chips
                4- Checkout
                5- Exit""";
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
                        System.out.println("***** Checkout *****");

                        int orderNumber = 1;
                        for (Order o : menus){
                            System.out.println("****** Order " + orderNumber + "*****");
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
                            ReceiptManagement.writingReceipt(orders);
                            input = false;
                        } else {
                            menus.clear();
                        }
                    }
                    break;


                case "5":
                    input = true;
                    break;
                default:
                    System.out.println("Invalid input please try again.");
                    break;
            }
        }
    }
    public static List<Menu> sandwich() {
        String sandwichBread = """
                Select your bread:
                1- White
                2- Wheat
                3- Rye
                4- Wrap""";
        System.out.println(sandwichBread);
        String bread = scanner.nextLine();

        String sandwichSize = """
                1- 4""
                2- 8""
                3- 12" """;
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
        boolean extraMeat = false;
        boolean extraCheese = false;
        boolean extraRegular = false;
        boolean isToasted = false;

        boolean input = true;
        while (input) {
            String sandwichTopping = """
                    1- Meat
                    2- Cheese
                    3- Other toppings
                    4- Select sauces
                    5- back""";

            System.out.println(sandwichTopping);
            String topping = scanner.nextLine();

            switch (topping) {
                case "1":
                    meatTopping();
                    String meat = scanner.nextLine();
                    System.out.println("Extra?");
                    String isExtraMeat = scanner.nextLine();
                    extraMeat = isExtraMeat.trim().equals("1") ? true : false;
                    meats.add(new PremiumTopping(meat,extraMeat,size));
                    break;
                case "2":
                    cheeseTopping();
                    String cheese = scanner.nextLine();
                    System.out.println("Extra?\n1-yes\n2-no");
                    String isExtraCheese = scanner.nextLine();
                    extraCheese = isExtraCheese.trim().equals("1") ? true : false;
                    cheeses.add(new PremiumTopping(cheese,extraCheese,size));
                    break;
                case "3":
                    regularTopping();
                    String regular = scanner.nextLine();
                    System.out.println("Extra?\n1: yes\n2: no");
                    String isExtraRegular = scanner.nextLine();
                    extraRegular = isExtraRegular.trim().equals("1") ? true : false;
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

        System.out.println("Is toasted");
        String toasted = scanner.nextLine();
        isToasted = toasted.trim().equals("1") ? true : false;

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
               
                Select drink size:
               
                1- Small
                2- Medium
                3- Large""";
        System.out.println(drinkSize);
        String sizeChoice = scanner.nextLine();
        int size = 12;
        if (sizeChoice.trim().equals("1")){
            size = 4;
        } else if (sizeChoice.trim().equals("2")) {
            size = 8;
        }

        String drinkFlavor = """
                
                Select flavor
                
                1- Lemonade
                2- Coca
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
                
                select chips type
                
                1- Potato Chips
                2- Tortilla Chips
                3- Pita Chips
                """;
        System.out.println(chips);
        String type = scanner.nextLine();
        List<Menu> chipses = new ArrayList<>();
        chipses.add(new Chips(type));
        return chipses;
    }

    public static void meatTopping() {
            String topping = """
                   
                    Meats
                   
                    1- steak
                    2- ham
                    3- salami
                    4- roast beef -
                    5-chicken
                    6- bacon""";
            System.out.println(topping);
    }
    public static void cheeseTopping(){
        String cheese = """
               
                Cheese
                
                7- american
                8- provolone
                9- cheddar
                10- swiss""";
        System.out.println(cheese);
    }

    public static void regularTopping(){
        String regular = """
                
                Regular Toppings
                
                1- lettuce
                2- peppers
                3- onions
                4- tomatoes
                5- jalapeños
                6- cucumbers
                7- pickles
                8- guacamole
                9-- mushrooms""";
        System.out.println(regular);
    }

    public static void saucesTopping(){
        String sauces = """
                
                Sauces
                
                1- Mayo
                2- Mustard
                3- Ketchup
                4- Ranch
                5- Thousand Islands
                6- Vinaigrette""";
        System.out.println(sauces);
    }
}
