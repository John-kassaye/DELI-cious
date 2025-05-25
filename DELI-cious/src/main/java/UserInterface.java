import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        homeScreen();

        Topping premiumTopping = new PremiumTopping("Steak",true,8);
        Topping premiumTopping2 = new PremiumTopping("American",false,8);
        Topping premiumTopping3 = new PremiumTopping("Ham",false,8);
        Topping regularTopping = new RegularTopping("Steak",true);

        List<Topping> toppings= new ArrayList<>();
        toppings.add(premiumTopping);
        toppings.add(premiumTopping2);
        toppings.add(premiumTopping3);
        toppings.add(regularTopping);

        Menu menu =  new Sandwich(8,"Wheat",toppings,"Au jus",false);
        Menu menu1 = new Drink(4,"Lemonade");
        Menu menu3 = new Drink(8,"Lemonade");

        List<Menu> orderList = new ArrayList<>();


        Order order = new Order();
        order.addMenu(menu);
        order.addMenu(menu1);
        order.addMenu(menu3);

//        order.display();

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

        Menu sandwich = null;
        Menu drink = null;
        Menu chips = null;

        boolean input = false;

        while (!input) {
            String order1 = """
                
                1- Add Sandwich
                2- Add Drink
                3- Add chips
                4- Checkout
                5- Add Another order""";
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
                    System.out.println("***** Checkout *****");

                    Order order2 = new Order();

                    if (sandwich != null) {
                        order2.addMenu(sandwich);
                    }

                    if (drink != null) {
                        order2.addMenu(drink);
                    }

                    if (chips != null){
                        order2.addMenu(chips);
                    }

                    if (sandwich == null && drink == null && chips == null) {
                        System.out.println("Nothing to checkout.");
                    }
                    order2.display();
                    break;

                    case "5":
                    input = true;
                default:
                    System.out.println("Invalid input please try again.");
                    break;
            }
        }
    }
    public static Sandwich sandwich() {
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
        String meat = "";
        String cheese = "";
        String regular = "";
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
                    meat = scanner.nextLine();
                    System.out.println("Extra?");
                    String isExtraMeat = scanner.nextLine();
                    extraMeat = isExtraMeat.trim().equals("1") ? true : false;
                    break;
                case "2":
                    cheeseTopping();
                    cheese = scanner.nextLine();
                    System.out.println("Extra?\n1-yes\n2-no");
                    String isExtraCheese = scanner.nextLine();
                    extraCheese = isExtraCheese.trim().equals("1") ? true : false;
                    break;
                case "3":
                    regularTopping();
                    regular = scanner.nextLine();
                    System.out.println("Extra?\n1: yes\n2: no");
                    String isExtraRegular = scanner.nextLine();
                    extraRegular = isExtraRegular.trim().equals("1") ? true : false;
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

        if (!meat.isBlank()) {
            toppings.add(new PremiumTopping(meat, extraMeat, size));
        }
        if (!cheese.isBlank()) {
            toppings.add(new PremiumTopping(cheese, extraCheese, size));
        }
        if (!regular.isBlank()) {
            toppings.add(new RegularTopping(regular, extraRegular));
        }
        return new Sandwich(size, bread, toppings, sauce, isToasted);
    }

    public static Drink drink(){
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
        return new Drink(size,flavor);
    }

    public static Chips chips(){
        String chips = """
                
                select chips type
                
                1- Potato Chips
                2- Tortilla Chips
                3- Pita Chips
                """;
        System.out.println(chips);
        String type = scanner.nextLine();

        return new Chips(type);
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
