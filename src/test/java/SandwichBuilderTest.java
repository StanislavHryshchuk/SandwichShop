import enums.BreadSize;
import modele.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class SandwichBuilderTest {
    @Test
    public void createSandwichTest(){
        BreadSize size = BreadSize.FOUR_INCH;
        Bread bread = new Bread("Wrap", size);

        CheeseTopping ct = new CheeseTopping("swiss", size,true);
        MeatTopping mt = new MeatTopping("steak", size,true);
        RegularTopping rt = new RegularTopping("onions");
        List<Topping> toppings = new ArrayList<>(List.of(mt, ct, rt));

        List<Sauce> sauces = new ArrayList<>();
        Sauce sauce = new Sauce("ranch");
        sauces.add(sauce);

        List<Sides> sides = new ArrayList<>();
        Sides side = new Sides("sauce");
        sides.add(side);
        boolean toasted = true;

        Sandwich sandwich = new Sandwich(bread.getName(),bread.getSize(),toppings,sauces,sides,toasted);

        assertNotNull(sandwich);
        assertEquals("steak",sandwich.getToppings().getFirst().getName());
        assertTrue(sandwich.isToasted());
    }
    @Test
    public void getPriceTest(){
        BreadSize size = BreadSize.FOUR_INCH;
        Bread bread = new Bread("Wrap", size);

        CheeseTopping ct = new CheeseTopping("swiss", size,true);
        MeatTopping mt = new MeatTopping("steak", size,true);
        RegularTopping rt = new RegularTopping("onions");
        List<Topping> toppings = new ArrayList<>(List.of(mt, ct, rt));

        List<Sauce> sauces = new ArrayList<>();
        Sauce sauce = new Sauce("ranch");
        sauces.add(sauce);

        List<Sides> sides = new ArrayList<>();
        Sides side = new Sides("sauce");
        sides.add(side);
        boolean toasted = true;

        Sandwich sandwich = new Sandwich(bread.getName(),bread.getSize(),toppings,sauces,sides,toasted);

        assertEquals(8.00,sandwich.getPrice(),0.1);
    }
}
