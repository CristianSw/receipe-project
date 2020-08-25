package receipe.receipeproject.converters;

import com.sun.istack.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import receipe.receipeproject.commands.RecipeCommand;
import receipe.receipeproject.domain.Recipes;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipes> {
    private final CategoryCommandToCategory categoryConverter;
    private final IngredientCommandToIngredient ingredientConverter;
    private final NotesCommandToNotes notesConverter;

    public RecipeCommandToRecipe(CategoryCommandToCategory categorConverter, IngredientCommandToIngredient ingredientConverter, NotesCommandToNotes notesConverter) {
        this.categoryConverter = categorConverter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipes convert(RecipeCommand source) {
        if (source == null) {
            return null;
        }
        final Recipes recipes = new Recipes();
        recipes.setId(source.getId());
        recipes.setDescription(source.getDescription());
        recipes.setPrepTime(source.getPrepTime());
        recipes.setCockTime(source.getCockTime());
        recipes.setServings(source.getServings());
        recipes.setSource(source.getSource());
        recipes.setUrl(source.getUrl());
        recipes.setDirections(source.getDirections());
        recipes.setDifficulty(source.getDifficulty());
        recipes.setNotes(notesConverter.convert(source.getNotes()));
        if (source.getCategories() != null && source.getCategories().size() > 0) {
            source.getCategories()
                    .forEach(category -> recipes.getCategories().add(categoryConverter.convert(category)));
        }
        if (source.getIngredients() != null && source.getIngredients().size() > 0) {
            source.getIngredients()
                    .forEach(ingredient -> recipes.getIngredients().add(ingredientConverter.convert(ingredient)));
        }
        return recipes;
    }
}
