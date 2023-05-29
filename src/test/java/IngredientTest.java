import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    private IngredientType ingredientType;
    private final static double DELTA = 0.01;
    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(ingredientType, "qwe", (float) 2.2);
        Assert.assertEquals((float) 2.2, ingredient.getPrice(), DELTA);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(ingredientType, "qwe", (float) 2.2);
        Assert.assertEquals("qwe", ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(ingredientType, "qwe", (float) 2.2);
        Assert.assertEquals(ingredientType, ingredient.getType());
    }
}
