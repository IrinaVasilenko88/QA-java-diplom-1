package praktikum;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final String expectedType;

    public IngredientTypeTest(String expectedType) {
        this.expectedType = expectedType;
    }

    @Parameterized.Parameters(name = "Выбор типа ингредиента. Тестовые данные {0},{1},{2},{3}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"}
        };
    }

    @Test
    @DisplayName("Выбор типа ингредиента")
    public void ingredientTypeTest() {
        assertEquals(expectedType, IngredientType.valueOf(expectedType).toString());
    }
}
