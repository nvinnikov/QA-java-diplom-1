import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;
import org.junit.runner.RunWith;
import praktikum.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Database database;

    @Test
    public void setBunsTest(){
        Burger burger = new Burger();
        Bun bun = new Bun("СмолТести", (float) 111.2);
        burger.setBuns(bun);
        Assert.assertEquals(burger.bun, bun);
    }
    @Test
    public void addIngredientTest(){
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Лук", (float) 20.0);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        burger.addIngredient(ingredient);
        Assert.assertEquals(burger.ingredients, ingredients);
    }
    @Test
    public void removeIngredientTest(){
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Лук", (float) 20.0);
        List<Ingredient> ingredients = new ArrayList<>();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(burger.ingredients, ingredients);
    }
    @Test
    public void moveIngredientTest(){
        Burger burger = new Burger();
        Ingredient ingredient0 = new Ingredient(IngredientType.SAUCE, "Лук", (float) 20.0);
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Помидор", (float) 50.0);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient0);
        burger.addIngredient(ingredient0);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(0,1);
        Assert.assertEquals(burger.ingredients, ingredients);
    }
    @Test
    public void getPriceTest(){
        Burger burger = new Burger();
        Bun bun = new Bun("СмолТести", (float) 111.2);
        burger.setBuns(bun);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Лук", (float) 20.0);
        burger.addIngredient(ingredient);
        Assert.assertEquals(burger.getPrice(), (float) 242.4, 0.01);
    }
    @Test
    public void getReceiptTest(){
        Burger burger = new Burger();
        Bun bun = new Bun("СмолТести", (float) 111.2);
        burger.setBuns(bun);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Лук", (float) 20.0);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        burger.addIngredient(ingredient);
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        for (Ingredient i : ingredients) {
            receipt.append(String.format("= %s %s =%n", i.getType().toString().toLowerCase(),
                    i.getName()));
        }
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", (float) 242.4));
        Assert.assertEquals(burger.getReceipt(), receipt.toString());
    }

}
