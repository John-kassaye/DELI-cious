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
            for (Menu menu1 : menu){
                fileWriter.write(menu1.getName());
                price+= menu1.getPrice();
            }

            fileWriter.write(String.format("\n%-30s %.2f ","Total price: " , price));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
