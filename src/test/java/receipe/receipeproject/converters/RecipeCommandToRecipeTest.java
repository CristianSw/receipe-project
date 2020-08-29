package receipe.receipeproject.converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import receipe.receipeproject.commands.CategoryCommand;
import receipe.receipeproject.commands.IngredientCommand;
import receipe.receipeproject.commands.NotesCommand;
import receipe.receipeproject.commands.RecipeCommand;
import receipe.receipeproject.domain.Difficulty;
import receipe.receipeproject.domain.Recipes;

import static org.junit.jupiter.api.Assertions.*;

class RecipeCommandToRecipeTest {
    public static final Long RECIPE_ID = 1L;
    public static final Integer COOK_TIME = Integer.valueOf("5");
    public static final Integer PREP_TIME = Integer.valueOf("7");
    public static final String DESCRIPTION = "My Recipe";
    public static final String DIRECTIONS = "Directions";
    public static final Difficulty DIFFICULTY = Difficulty.EASY;
    public static final Integer SERVINGS = Integer.valueOf("3");
    public static final String SOURCE = "Source";
    public static final String URL = "Some URL";
    public static final Long CAT_ID_1 = 1L;
    public static final Long CAT_ID_2 = 2L;
    public static final Long INGRED_ID_1 = 3L;
    public static final Long INGRED_ID_2 = 4L;
    public static final Long NOTES_ID = 9L;

    RecipeCommandToRecipe converter;

    @BeforeEach
    void setUp() {
        converter = new RecipeCommandToRecipe(new CategoryCommandToCategory()
                , new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure())
                , new NotesCommandToNotes());
    }

    @Test
    void nullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    void emptyObject() {
        assertNotNull(converter.convert(new RecipeCommand()));
    }

    @Test
    void convert() {
        //given
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(RECIPE_ID);
        recipeCommand.setCockTime(COOK_TIME);
        recipeCommand.setPrepTime(PREP_TIME);
        recipeCommand.setDescription(DESCRIPTION);
        recipeCommand.setDirections(DIRECTIONS);
        recipeCommand.setDifficulty(DIFFICULTY);
        recipeCommand.setServings(SERVINGS);
        recipeCommand.setSource(SOURCE);
        recipeCommand.setUrl(URL);
        CategoryCommand cat1 = new CategoryCommand();
        cat1.setId(CAT_ID_1);
        CategoryCommand cat2 = new CategoryCommand();
        cat2.setId(CAT_ID_2);
        recipeCommand.getCategories().add(cat1);
        recipeCommand.getCategories().add(cat2);
        IngredientCommand ingredient1 = new IngredientCommand();
        ingredient1.setId(INGRED_ID_1);
        IngredientCommand ingredient2 = new IngredientCommand();
        ingredient2.setId(INGRED_ID_2);
        recipeCommand.getIngredients().add(ingredient1);
        recipeCommand.getIngredients().add(ingredient2);
        NotesCommand notes = new NotesCommand();
        notes.setId(NOTES_ID);
        recipeCommand.setNotes(notes);

        //when
        Recipes recipes = converter.convert(recipeCommand);

        //then
        assertNotNull(converter.convert(recipeCommand));
        assertEquals(RECIPE_ID, recipes.getId());
        assertEquals(COOK_TIME, recipes.getCockTime());
        assertEquals(PREP_TIME, recipes.getPrepTime());
        assertEquals(DESCRIPTION, recipes.getDescription());
        assertEquals(DIRECTIONS, recipes.getDirections());
        assertEquals(DIFFICULTY, recipes.getDifficulty());
        assertEquals(SERVINGS, recipes.getServings());
        assertEquals(SOURCE, recipes.getSource());
        assertEquals(URL, recipes.getUrl());
        assertEquals(2, recipes.getCategories().size());
        assertEquals(2, recipes.getIngredients().size());
        assertEquals(NOTES_ID, recipes.getNotes().getId());
    }
}