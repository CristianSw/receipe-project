package receipe.receipeproject.repositories;

import org.springframework.data.repository.CrudRepository;
import receipe.receipeproject.domain.Category;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
