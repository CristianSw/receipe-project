package receipe.receipeproject.converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import receipe.receipeproject.commands.IngredientCommand;
import receipe.receipeproject.commands.UnitOfMeasureCommand;
import receipe.receipeproject.domain.Recipes;
import receipe.receipeproject.domain.UnitOfMeasure;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class IngredientCommandToIngredientTest {
    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";
    public static final BigDecimal AMOUNT = new BigDecimal("3");
    public static final Long UOM_ID = 12L;
    public static final Recipes RECIPE = new Recipes();

    IngredientCommandToIngredient converter;

    @BeforeEach
    void setUp() {
        converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    void testNullObject(){
        assertNull(converter.convert(null));
    }

    @Test
    void emptyObject(){
        assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
    void convert() {
        //given
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(ID_VALUE);
        ingredientCommand.setDescription(DESCRIPTION);
        ingredientCommand.setAmount(AMOUNT);
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(UOM_ID);
        ingredientCommand.setUnitOfMeasure(unitOfMeasure);

        //when
        converter.convert(ingredientCommand);

        //then
        assertNotNull(ingredientCommand);
        assertNotNull(ingredientCommand.getUnitOfMeasure());
        assertEquals(ingredientCommand.getId(),ID_VALUE);
        assertEquals(ingredientCommand.getDescription(),DESCRIPTION);
        assertEquals(ingredientCommand.getAmount(),AMOUNT);
        assertEquals(ingredientCommand.getUnitOfMeasure().getId(),UOM_ID);
    }
    @Test
    void convertWithNullUOM() {
        //given
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(ID_VALUE);
        ingredientCommand.setDescription(DESCRIPTION);
        ingredientCommand.setAmount(AMOUNT);
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();

        //when
        converter.convert(ingredientCommand);
        //then
        assertNotNull(ingredientCommand);
        assertNull(ingredientCommand.getUnitOfMeasure());
        assertEquals(ingredientCommand.getId(),ID_VALUE);
        assertEquals(ingredientCommand.getDescription(),DESCRIPTION);
        assertEquals(ingredientCommand.getAmount(),AMOUNT);
    }
}