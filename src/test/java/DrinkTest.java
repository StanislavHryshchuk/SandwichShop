import modele.Drink;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {

    @Test
   public void getPriceTest_LargeDrink(){
       Drink drink = new Drink("Cola", "L");
       assertEquals(3.00,drink.getPrice());
   }
    @Test
    public void getPriceTest_MediumDrink(){
        Drink drink = new Drink("Cola", "M");
        assertEquals(2.50,drink.getPrice());
    }
    @Test
    public void getPriceTest_SmallDrink(){
        Drink drink = new Drink("Cola", "s");
        assertEquals(2.00,drink.getPrice());
    }
    @Test
    public void  toStringTestCorrectFormat(){
        Drink drink = new Drink("Cola", "M");
        String expectedString = "Cola (M) - $2.50";
        assertEquals(expectedString,drink.toString());
    }
    @Test
    public void sizeOfDrinkList(){
        List<String> drinklist = Drink.drinksList;
        int size = drinklist.size();
        assertEquals(5,size);
    }
}