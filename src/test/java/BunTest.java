import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    private final String expectedName;
    private final float expectedPrice;

    public BunTest(String name, float price, String expectedName, float expectedPrice) {
        this.name = name;
        this.price = price;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "Выбор булочки. Тестовые данные {0},{1},{2},{3}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Fluor", 500, "Fluor", 500},
                {"Crater", 1, "Crater", 1},
                {"Fluor", 0, "Fluor", 0},
                {null, 5, null, 5}
        };
    }

    @Test
    @DisplayName("Выбор булочки и цены")
    public void bunChoiceTest() {
        Bun bun = new Bun(name, price);
        assertEquals(expectedName, bun.getName());
        assertEquals(expectedPrice, bun.getPrice(), 0.01);
    }
}

