import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReceiptManagement {
    public static void writingReceipt(List<Order> orders, double finalPrice, int people){

        LocalDateTime localDateTime =  LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss ");
        String date = localDateTime.format(timeFormatter);

        String path = "/Users/yohannesmulugeta/Desktop/plural sight/LearnToCode_Capstones/DELI-cious/DELI-cious/src/Receipts";
        String fileName = date + ".txt";

        try( FileWriter fileWriter = new FileWriter(path + "/" + fileName) ) {
            fileWriter.write("*******DELI-cious*******");

            int orderNumber = 1;

            for (Order order : orders) {
                fileWriter.write("\n\n--- Order #" + orderNumber++ + "---");
                double orderPrice = 0;
                for (Menu menu : order.getMenus()){
                    fileWriter.write("\n" + menu.getName());
                    fileWriter.write("\n" + menu.toString());
                    orderPrice += menu.getPrice();
                }
                fileWriter.write(String.format("\n%-30s $%.2f ","Total price: " , orderPrice));

            }
            fileWriter.write("\n----------------------------------------------");
            fileWriter.write(String.format("\n%-30s $%.2f ","Total price:" , finalPrice));

            if (people > 1){
                finalPrice/= people;
                fileWriter.write(String.format("\n%-30s  $%.2f each", "Split between " + people + " people:" , finalPrice));
            }
            System.out.println("\n \uD83E\uDDFE Your receipt has been written to the file successfully.");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
