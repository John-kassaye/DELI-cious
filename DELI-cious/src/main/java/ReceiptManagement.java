import java.io.FileWriter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReceiptManagement {

    public static void writingReceipt(List<Menu> menu){

        LocalDateTime localDateTime =  LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss ");
        String date = localDateTime.format(timeFormatter);

        try( FileWriter fileWriter = new FileWriter(date + ".txt") ) {
            double price = 0;
            int orderNumber = 1;
            for (Menu menu1 : menu) {
                if (menu1 != null) {
                    fileWriter.write("order #" + orderNumber);
                    if (menu1 instanceof Sandwich sandwich){
                        fileWriter.write("Sandwich");
                        fileWriter.write(menu1.getName());
                        price += sandwich.getPrice();
                    } else if (menu1 instanceof Drink drink) {
                        fileWriter.write("Drink");
                        fileWriter.write(drink.getName());
                        price+= drink.getPrice();
                    } else if (menu instanceof Chips chips) {
                        fileWriter.write("Chips");
                        fileWriter.write(chips.getName());
                        price+= chips.getPrice();
                    }
                    orderNumber++;
                }
            }
            fileWriter.write(String.format("\n%-30s %.2f ","Total price: " , price));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
