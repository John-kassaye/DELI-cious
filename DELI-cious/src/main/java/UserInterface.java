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
                2- Exit""";
        System.out.println(homeScreen);
    }

    public static void orderScreen(){
        String order = """
                1- Add Sandwich
                2- Add Drink
                3- Add chips
                4- Checkout
                0- Cancel order""";
        System.out.println(order);
    }

    public static void addSandwich(){
        String bread = """
                Select your bread:
                1- White
                2- Wheat
                3- Rye
                4- Wrap""";
        System.out.println(bread);
        String choice = scanner.nextLine();

        String sandwichSize = """
                1- 4""
                2- 8""
                3- 12""";
        System.out.println(sandwichSize);
        String size = scanner.nextLine();

        String sandwichTopping = """
                1- Meat
                2- Cheese
                3- Other toppings
                4- Select sauces""";
        System.out.println(sandwichTopping);
        String topping = scanner.nextLine();
    }

    public static void addDrink(){
        String drinkSize = """
                Select drink size:
                1- Small
                2- Medium
                3- Large""";
        System.out.println(drinkSize);
        String size = scanner.nextLine();

        String drinkFlavor = """
                """;
        System.out.println(drinkFlavor);
        String flavor = scanner.nextLine();
    }

    public static void checkoutDisplay(){}
}
