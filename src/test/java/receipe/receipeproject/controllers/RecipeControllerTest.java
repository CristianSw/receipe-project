package receipe.receipeproject.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import receipe.receipeproject.domain.Recipes;
import receipe.receipeproject.services.RecipeService;


import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class RecipeControllerTest {


    @Mock
    RecipeService recipeService;
    RecipeController recipeController;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        recipeController = new RecipeController(recipeService);
    }

    @Test
    void showById() throws Exception {
        Recipes recipes = new Recipes();
        recipes.setId(1L);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
        when(recipeService.findById(anyLong())).thenReturn(recipes);

        mockMvc.perform(get("/recipe/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("/recipe/show"));
    }
    @Test
    void testGetRecipe() throws Exception {
        Recipes recipes = new Recipes();
        recipes.setId(1L);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
        when(recipeService.findById(anyLong())).thenReturn(recipes);

        mockMvc.perform(get("/recipe/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("/recipe/show"))
                .andExpect(model().attributeExists("recipes"));
    }
}