package receipe.receipeproject.services;

import org.springframework.stereotype.Service;
import receipe.receipeproject.domain.Recipes;
import receipe.receipeproject.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipes> getRecipes() {
        Set<Recipes> recipesSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipesSet::add);
        return recipesSet;
    }
}
