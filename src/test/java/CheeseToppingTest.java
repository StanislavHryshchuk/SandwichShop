import enums.BreadSize;
import modele.CheeseTopping;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CheeseToppingTest {

    @Test
    public void getPriceTestExtraCheese_4inch(){
        BreadSize size = BreadSize.FOUR_INCH;
        CheeseTopping ct = new CheeseTopping("swiss", size,true);
        assertEquals(1.05, ct.getPrice());
    }
    @Test
    public void getPriceTestExtraCheese_8inch(){
        BreadSize size = BreadSize.EIGHT_INCH;
        CheeseTopping ct = new CheeseTopping("swiss", size,true);
        assertEquals(2.10, ct.getPrice());
    }
    @Test
    public void getPriceTestExtraCheese_12inch(){
        BreadSize size = BreadSize.TWELVE_INCH;
        CheeseTopping ct = new CheeseTopping("swiss", size,true);
        assertEquals(3.15, ct.getPrice());
    }

    @Test
    public void getPriceTestNoExtraCheese_4inch(){
        BreadSize size = BreadSize.FOUR_INCH;
        CheeseTopping ct = new CheeseTopping("swiss", size,false);
        assertEquals(0.75, ct.getPrice());
    }
    @Test
    public void getPriceTestNoExtraCheese_8inch(){
        BreadSize size = BreadSize.EIGHT_INCH;
        CheeseTopping ct = new CheeseTopping("swiss", size,false);
        assertEquals(1.50, ct.getPrice());
    }
    @Test
    public void getPriceTestNoExtraCheese_12inch(){
        BreadSize size = BreadSize.TWELVE_INCH;
        CheeseTopping ct = new CheeseTopping("swiss", size,false);
        assertEquals(2.25, ct.getPrice());
    }

    @Test
    public void isMeatToppingInTheListTest(){
        List<String> toppings = CheeseTopping.namesOfCheese;
        assertTrue(toppings.contains("swiss"));
        assertFalse(toppings.contains("Pepper Jack"));
    }
}
