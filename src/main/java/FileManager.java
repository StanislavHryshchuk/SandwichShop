import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class FileManager {

    public static void writeToFile(Order order){
        LocalDateTime nameOfFile = LocalDateTime.now();

        try(FileWriter fr = new FileWriter("src\\main\\resources\\Receipts\\" + nameOfFile + ".txt")){
            fr.write(order.toString());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
