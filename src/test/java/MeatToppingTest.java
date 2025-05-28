import enums.BreadSize;
import modele.MeatTopping;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class MeatToppingTest {

    @Test
    public void getPriceTestExtraMeat_4inch(){
        BreadSize size = BreadSize.FOUR_INCH;
        MeatTopping mt = new MeatTopping("steak", size,true);
        assertEquals(1.50, mt.getPrice());
    }

    @Test
    public void getPriceTestExtraMeat_8inch(){
        BreadSize size = BreadSize.EIGHT_INCH;
        MeatTopping mt = new MeatTopping("steak", size,true);
        assertEquals(3, mt.getPrice());
    }
    @Test
    public void getPriceTestExtraMeat_12inch(){
        BreadSize size = BreadSize.TWELVE_INCH;
        MeatTopping mt = new MeatTopping("steak", size,true);
        assertEquals(3.50, mt.getPrice());
    }

    @Test
    public void getPriceTestNoExtraMeat_4inch(){
        BreadSize size = BreadSize.FOUR_INCH;
        MeatTopping mt = new MeatTopping("steak", size,false);
        assertEquals(1.00, mt.getPrice());
    }

    @Test
    public void getPriceTestNoExtraMeat_8inch(){
        BreadSize size = BreadSize.EIGHT_INCH;
        MeatTopping mt = new MeatTopping("steak", size,false);
        assertEquals(2, mt.getPrice());
    }
    @Test
    public void getPriceTestNoExtraMeat_12inch(){
        BreadSize size = BreadSize.TWELVE_INCH;
        MeatTopping mt = new MeatTopping("steak", size,false);
        assertEquals(3.00, mt.getPrice());
    }

    @Test
    public void isMeatToppingInTheListTest(){
        List<String> toppings = MeatTopping.meatToppings;
        assertTrue(toppings.contains("steak"));
        assertFalse(toppings.contains("Spam"));
    }
}
