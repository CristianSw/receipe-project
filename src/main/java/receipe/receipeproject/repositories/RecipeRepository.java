package receipe.receipeproject.repositories;

import org.springframework.data.repository.CrudRepository;
import receipe.receipeproject.domain.Recipes;

public interface RecipeRepository extends CrudRepository<Recipes,Long> {
}
