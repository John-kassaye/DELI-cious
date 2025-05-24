import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        homeScreen();

        Topping premiumTopping = new PremiumTopping("Steak",true,8);
        Topping premiumTopping2 = new PremiumTopping("American",false,8);
        Topping premiumTopping3 = new PremiumTopping("Ham",false,8);
        Topping regularTopping = new RegularTopping("Steak",true);

        List<Topping> toppings= new ArrayList<>();
        toppings.add(premiumTopping);
        toppings.add(premiumTopping2);
        toppings.add(premiumTopping3);
        toppings.add(regularTopping);

        Menu menu =  new Sandwich(8,"Wheat",toppings,false);
        Menu menu1 = new Drink(4,"Lemonade");
        Menu menu3 = new Drink(8,"Lemonade");
        Menu menu2 = new Chips("Chips");

        List<Menu> orderList = new ArrayList<>();


        Order order = new Order();
        order.addMenu(menu);
        order.addMenu(menu1);
        order.addMenu(menu2);

        order.display();

    }

    public static void homeScreen(){
        String homeScreen = """
                             Welcome to the DELICIOUS
                
                1- New Order
                2- Exit""";
        System.out.println(homeScreen);
        String order = scanner.nextLine();

        if (order.equalsIgnoreCase("1")){
            orderScreen();
        } else {
            System.exit(0);
        }
    }

    public static void orderScreen(){
        String order = """
                1- Add Sandwich
                2- Add Drink
                3- Add chips
                4- Checkout
                0- Cancel order""";
        System.out.println(order);
        choice();
    }

    public static void choice(){
        String choice = scanner.nextLine();
        switch (choice){
            case "1":
                addSandwich();
                break;
            case "2":
                addDrink();
                break;
            case "4":
                break;
            default:
                System.out.println("Invalid input please try again.");
        }
    }

    public static void addSandwich() {
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
                3- 12" /t""";
        System.out.println(sandwichSize);
        String size = scanner.nextLine();

        String meat = "";
        String cheese = "";
        String regular = "";
        String sauce = "";

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
                    break;
                case "2":
                    cheeseTopping();
                    cheese = scanner.nextLine();
                    break;
                case "3":
                    regularTopping();
                    regular = scanner.nextLine();
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
    }

    public static Drink addDrink(){
        String drinkSize = """
               
                Select drink size:
               
                1- Small
                2- Medium
                3- Large""";
        System.out.println(drinkSize);
        String size = scanner.nextLine();

        String drinkFlavor = """
                
                Select flavor
                1- Lemonde
                2- Coca
                """;
        System.out.println(drinkFlavor);
        String flavor = scanner.nextLine();

        return new Drink(Integer.parseInt(size),flavor);

    }

    public static void meatTopping() {
            String topping = """
                   
                    Meats
                   
                    1- steak
                    2- ham
                    3- salami
                    4- roast beef - chicken
                    5- bacon""";
            System.out.println(topping);
    }
    public static void cheeseTopping(){
        String cheese = """
               
                Cheese
                
                1- american
                2- provolone
                3- cheddar
                4- swiss""";
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
                
                1- mayo
                2- mustard
                3- ketchup
                4- ranch
                5- thousand islands
                6- vinaigrette""";
        System.out.println(sauces);
    }
}
