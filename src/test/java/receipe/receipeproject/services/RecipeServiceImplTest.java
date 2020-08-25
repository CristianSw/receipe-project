package receipe.receipeproject.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import receipe.receipeproject.commands.RecipeCommand;
import receipe.receipeproject.converters.RecipeCommandToRecipe;
import receipe.receipeproject.converters.RecipeToRecipeCommand;
import receipe.receipeproject.domain.Recipes;
import receipe.receipeproject.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;
    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;
    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    void getRecipesById() {
        Recipes recipes = new Recipes();
        recipes.setId(1L);
        Optional<Recipes> recipeOptional = Optional.of(recipes);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipes recipeReturned = recipeService.findById(1L);
        assertNotNull(recipeReturned, "Null recipe returned");
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    @Test
    void getRecipes() {
        Recipes recipe1 = new Recipes();
        HashSet<Recipes> recipesData = new HashSet<>();
        recipesData.add(recipe1);

        when(recipeRepository.findAll()).thenReturn(recipesData);
        Set<Recipes> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    void saveRecipe() {
        //todo
    }
}