package receipe.receipeproject.services;

import receipe.receipeproject.domain.Recipes;

import java.util.Set;

public interface RecipeService {
    Set<Recipes> getRecipes();
    Recipes findById(Long id);
}
