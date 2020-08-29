package receipe.receipeproject.converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import receipe.receipeproject.commands.UnitOfMeasureCommand;
import receipe.receipeproject.domain.Ingredient;
import receipe.receipeproject.domain.Recipes;
import receipe.receipeproject.domain.UnitOfMeasure;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class IngredientToIngredientCommandTest {
    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";
    public static final BigDecimal AMOUNT = new BigDecimal("3");
    public static final Long UOM_ID = 12L;
    public static final Recipes RECIPE = new Recipes();
    IngredientToIngredientCommand converter;

    @BeforeEach
    void setUp() {
        converter = new IngredientToIngredientCommand(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject() {
        assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    void convert() {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setAmount(AMOUNT);
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(UOM_ID);
        ingredient.setUom(unitOfMeasure);

        //when
        converter.convert(ingredient);

        //then
        assertNotNull(ingredient);
        assertNotNull(ingredient.getUom());
        assertEquals(ingredient.getId(), ID_VALUE);
        assertEquals(ingredient.getDescription(), DESCRIPTION);
        assertEquals(ingredient.getAmount(), AMOUNT);
        assertEquals(ingredient.getUom().getId(), UOM_ID);
    }

    @Test
    void convertWithNullUOM() {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setAmount(AMOUNT);
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();

        //when
        converter.convert(ingredient);

        //then
        assertNotNull(ingredient);
        assertNull(ingredient.getUom());
        assertEquals(ingredient.getId(), ID_VALUE);
        assertEquals(ingredient.getDescription(), DESCRIPTION);
        assertEquals(ingredient.getAmount(), AMOUNT);
    }
}