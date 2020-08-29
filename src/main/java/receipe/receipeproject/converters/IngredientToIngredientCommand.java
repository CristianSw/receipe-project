package receipe.receipeproject.converters;

import com.sun.istack.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import receipe.receipeproject.commands.IngredientCommand;
import receipe.receipeproject.domain.Ingredient;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;

    public IngredientToIngredientCommand(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        if (source == null) {
            return null;
        }
        final IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(source.getId());
        ingredientCommand.setDescription(source.getDescription());
        ingredientCommand.setAmount(source.getAmount());
        ingredientCommand.setUnitOfMeasure(source.getUom());
        return ingredientCommand;
    }
}
