import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private List<Ingredient> ingredients;

    @Mock
    private Ingredient ingredient;
    private Burger burger;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
    }

    @Test
    @DisplayName("Выбор булочки")
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    @DisplayName("Добавить ингредиент")
    public void addIngredientTest() {
        burger.ingredients = ingredients;
        burger.addIngredient(ingredient);
        verify(ingredients).add(ingredient);
    }

    @Test
    @DisplayName("Удалить ингредиент")
    public void removeIngredientTest() {
        burger.ingredients = ingredients;
        burger.removeIngredient(1);
        verify(ingredients).remove(1);
    }

    @Test
    @DisplayName("Заменить ингредиент")
    public void moveIngredientTest() {
        burger.ingredients = ingredients;
        burger.moveIngredient(0, 1);
        verify(ingredients).add(1, ingredients.remove(0));
    }

    @Test
    @DisplayName("Узнать стоимость")
    public void getPriceTest() {
        float price = 10.0f;
        when(bun.getPrice()).thenReturn(4.0f);
        when(ingredient.getPrice()).thenReturn(1.0f);
        burger.bun = bun;
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient);
        assertEquals(price, burger.getPrice(), 0.0f);
    }

    @Test
    @DisplayName("Получить счёт")
    public void getReceiptTest() {
        StringBuilder expectedReceipt = new StringBuilder();
        when(bun.getName()).thenReturn("Fluor");
        when(ingredient.getName()).thenReturn("Space");
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        when(bun.getPrice()).thenReturn(10.0f);
        when(ingredient.getPrice()).thenReturn(10.0f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        expectedReceipt.append(String.format("(==== %s ====)%n", bun.getName()));
        expectedReceipt.append(String.format("= %s %s =%n", IngredientType.SAUCE.toString().toLowerCase(), "Space"));
        expectedReceipt.append(String.format("(==== %s ====)%n", bun.getName()));
        expectedReceipt.append(String.format("%nPrice: %f%n", burger.getPrice()));
        assertEquals(expectedReceipt.toString(), burger.getReceipt());
    }
}
