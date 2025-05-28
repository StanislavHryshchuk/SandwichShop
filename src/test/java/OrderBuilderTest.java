import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderBuilderTest {
    @Test
    public void orderBuildTest(){
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

        List<Sandwich> sandwiches = new ArrayList<>();
        sandwiches.add(sandwich);

        List<Drink> drinks = new ArrayList<>();
        Drink drink = new Drink("Cola", "M");
        drinks.add(drink);
        List<Chips> chips = new ArrayList<>();
        Chips c1 = new Chips("Lays");
        chips.add(c1);

        String name = "Stan";

        Order order = new Order(name, sandwiches,drinks,chips);

        assertNotNull(order);
        assertEquals("Stan", order.getName());
        assertTrue(order.getSandwiches().getFirst().isToasted());
    }

    @Test
    public void orderGetPriceTest(){
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

        List<Sandwich> sandwiches = new ArrayList<>();
        sandwiches.add(sandwich);

        List<Drink> drinks = new ArrayList<>();
        Drink drink = new Drink("Cola", "M");
        drinks.add(drink);
        List<Chips> chips = new ArrayList<>();
        Chips c1 = new Chips("Lays");
        chips.add(c1);

        String name = "Stan";

        Order order = new Order(name, sandwiches,drinks,chips);

        assertEquals(12,order.getPrice(), 0.1);
    }
}
