import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {

    public static void writeToFile(Order order){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        LocalDateTime nameOfFile = LocalDateTime.now();
        try(FileWriter fr = new FileWriter("src\\main\\resources\\Receipts\\" + nameOfFile.format(dtf) + ".txt")){
            fr.write(order.toString());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
