import java.io.FileWriter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReceiptManagement {

    public static void writingReceipt(List<Order> orders){

        LocalDateTime localDateTime =  LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss ");
        String date = localDateTime.format(timeFormatter);

        String path = "/Users/yohannesmulugeta/Desktop/plural sight/LearnToCode_Capstones/DELI-cious/DELI-cious/src/Receipts";
        String fileName = date + ".txt";

        try( FileWriter fileWriter = new FileWriter(path + "/" + fileName) ) {
            fileWriter.write("*******DELI-cious*******");

            double totalPrice = 0;
            int orderNumber = 1;

            for (Order order : orders) {
                fileWriter.write("\n\n--- Order #" + orderNumber++ + "---");

                double orderPrice = 0;
                for (Menu menu : order.getMenus()){
                    if (menu instanceof Sandwich sandwich){
                        fileWriter.write("\n---Sandwich---");
                        fileWriter.write(sandwich.getName());
                        orderPrice += sandwich.getPrice();
                    } else if (menu instanceof Drink drink) {
                        fileWriter.write("\n---Drink---");
                        fileWriter.write(drink.getName());
                        orderPrice+= drink.getPrice();
                    } else if (menu instanceof Chips chips) {
                        fileWriter.write("\n---Chips---");
                        fileWriter.write(chips.getName());
                        orderPrice += chips.getPrice();
                    }
                }
                fileWriter.write(String.format("\n%-30s $%.2f ","Total price: " , orderPrice));
                totalPrice+= orderPrice;
            }
            fileWriter.write("\n----------------------------------------------");
            fileWriter.write(String.format("\n%-30s $%.2f ","Total price: " , totalPrice));
            System.out.println("Receipt written to file.");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
