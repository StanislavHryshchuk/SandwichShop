import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private String name = LocalDateTime.now().toString();
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;

}
