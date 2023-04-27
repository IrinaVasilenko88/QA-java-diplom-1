import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Выбор ингредиентов. Тестовые данные {0},{1},{2},{3},{4},{5}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {IngredientType.SAUCE, "Spicy", 10},
                {IngredientType.FILLING, "Mini-salad", 5},
                {IngredientType.SAUCE, "Traditional", 16},
                {IngredientType.FILLING, null, 2.0f},
                {IngredientType.FILLING, "Cheese", 4.0f},
                {IngredientType.SAUCE, null, 0}
        };
    }

    @Test
    @DisplayName("Выбор ингредиентов")
    public void ingredientTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), 0.01);
    }
}
