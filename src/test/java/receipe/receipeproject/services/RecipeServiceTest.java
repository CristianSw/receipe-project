package receipe.receipeproject.services;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import receipe.receipeproject.commands.RecipeCommand;
import receipe.receipeproject.converters.RecipeCommandToRecipe;
import receipe.receipeproject.converters.RecipeToRecipeCommand;
import receipe.receipeproject.domain.Recipes;
import receipe.receipeproject.repositories.RecipeRepository;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class RecipeServiceTest {
    public static final String DESCRIPTION = "Description 1";

    @Autowired
    RecipeService recipeService;
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;
    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Transactional
    @Test
    public void saveOfDescription() throws Exception {
        //given
        Iterable<Recipes> recipes = recipeRepository.findAll();
        Recipes testRecipe = recipes.iterator().next();
        RecipeCommand testRecipeCommand = recipeToRecipeCommand.convert(testRecipe);

        //when
        testRecipeCommand.setDescription(DESCRIPTION);
        RecipeCommand savedRecipeCommand = recipeService.saveRecipes(testRecipeCommand);

        //then
        assertEquals(DESCRIPTION, savedRecipeCommand.getDescription());
        assertEquals(testRecipeCommand.getId(), savedRecipeCommand.getId());
        assertEquals(testRecipe.getCategories().size(), savedRecipeCommand.getCategories().size());
        assertEquals(testRecipe.getIngredients().size(), savedRecipeCommand.getIngredients().size());
    }

}