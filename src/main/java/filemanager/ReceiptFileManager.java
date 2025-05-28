package filemanager;
import modele.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {

    //Create a file and write the Final Order Summary to it
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