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
        String path = "/Users/yohannesmulugeta/Desktop/plural sight/LearnToCode_Capstones/DELI-cious/DELI-cious/src/Receipts";

        try( FileWriter fileWriter = new FileWriter(path + "/" + date + ".txt") ) {
            double price = 0;
            
            for (Menu menu1 : menu) {
                if (menu1 != null) {
                    if (menu1 instanceof Sandwich sandwich){
                        fileWriter.write("\nSandwich");
                        fileWriter.write(menu1.getName());
                        price += sandwich.getPrice();
                    } else if (menu1 instanceof Drink drink) {
                        fileWriter.write("\nDrink");
                        fileWriter.write(drink.getName());
                        price+= drink.getPrice();
                    } else if (menu instanceof Chips chips) {
                        fileWriter.write("\nChips");
                        fileWriter.write(chips.getName());
                        price+= chips.getPrice();
                    }
                }
            }
            fileWriter.write(String.format("\n%-30s %.2f ","Total price: " , price));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
