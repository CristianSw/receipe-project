package receipe.receipeproject.converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import receipe.receipeproject.commands.CategoryCommand;
import receipe.receipeproject.commands.IngredientCommand;
import receipe.receipeproject.commands.NotesCommand;
import receipe.receipeproject.commands.RecipeCommand;
import receipe.receipeproject.domain.*;

import static org.junit.jupiter.api.Assertions.*;

class RecipeToRecipeCommandTest {
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
    RecipeToRecipeCommand converter;

    @BeforeEach
    void setUp() {
        converter = new RecipeToRecipeCommand(new CategoryToCategoryCommand(),
                new IngredientToIngredientCommand(new UnitOfMeasureCommandToUnitOfMeasure())
                , new NotesToNotesCommand());
    }

    @Test
    void nullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    void emptyObject() {
        converter.convert(new Recipes());
    }

    @Test
    void convert() {
        //given
        Recipes recipe = new Recipes();
        recipe.setId(RECIPE_ID);
        recipe.setCockTime(COOK_TIME);
        recipe.setPrepTime(PREP_TIME);
        recipe.setDescription(DESCRIPTION);
        recipe.setDirections(DIRECTIONS);
        recipe.setDifficulty(DIFFICULTY);
        recipe.setServings(SERVINGS);
        recipe.setSource(SOURCE);
        recipe.setUrl(URL);

        Category cat1 = new Category();
        cat1.setId(CAT_ID_1);
        Category cat2 = new Category();
        cat2.setId(CAT_ID_2);
        recipe.getCategories().add(cat1);
        recipe.getCategories().add(cat2);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(INGRED_ID_1);
        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(INGRED_ID_2);
        recipe.getIngredients().add(ingredient1);
        recipe.getIngredients().add(ingredient2);

        Notes notes = new Notes();
        notes.setId(NOTES_ID);
        recipe.setNotes(notes);

        //when
        RecipeCommand recipeCommand = converter.convert(recipe);

        //then
        assertNotNull(recipe);
        assertEquals(RECIPE_ID, recipeCommand.getId());
        assertEquals(COOK_TIME, recipeCommand.getCockTime());
        assertEquals(PREP_TIME, recipeCommand.getPrepTime());
        assertEquals(DESCRIPTION, recipeCommand.getDescription());
        //assertEquals(DIRECTIONS, recipeCommand.getDescription());
        assertEquals(DIFFICULTY, recipeCommand.getDifficulty());
        assertEquals(SERVINGS, recipeCommand.getServings());
        assertEquals(SOURCE, recipeCommand.getSource());
        assertEquals(URL, recipeCommand.getUrl());
        assertEquals(2, recipeCommand.getCategories().size());
        assertEquals(2, recipeCommand.getIngredients().size());
        assertEquals(NOTES_ID, recipeCommand.getNotes().getId());
    }
}