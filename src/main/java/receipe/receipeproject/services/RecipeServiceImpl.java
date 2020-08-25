package receipe.receipeproject.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import receipe.receipeproject.commands.RecipeCommand;
import receipe.receipeproject.converters.RecipeCommandToRecipe;
import receipe.receipeproject.converters.RecipeToRecipeCommand;
import receipe.receipeproject.domain.Recipes;
import receipe.receipeproject.repositories.RecipeRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipes> getRecipes() {
        log.debug("I am in Recipe service");
        Set<Recipes> recipesSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipesSet::add);
        return recipesSet;
    }

    @Override
    public Recipes findById(Long l) {

        Optional<Recipes> recipeOptional = recipeRepository.findById(l);

        if (!recipeOptional.isPresent()) {
            throw new RuntimeException("Recipe Not Found!");
        }

        return recipeOptional.get();
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipes(RecipeCommand command) {
        Recipes detachedRecipe = recipeCommandToRecipe.convert(command);
        Recipes savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved recipe ID" + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }

}



