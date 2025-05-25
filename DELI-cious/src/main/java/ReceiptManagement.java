import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.List;

public class ReceiptManagement {

    public static void writingReceipt(List<Menu> menu){

        LocalDateTime localDateTime =  LocalDateTime.now();
        String date = String.valueOf(localDateTime);

        try( FileWriter fileWriter = new FileWriter(date) ) {
            Order order = new Order();
            for (Menu menu1 : menu){
                fileWriter.write(menu1.getName());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
