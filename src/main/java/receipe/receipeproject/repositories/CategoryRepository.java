package receipe.receipeproject.repositories;

import org.springframework.data.repository.CrudRepository;
import receipe.receipeproject.domain.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,Long> {
    Optional<Category> findByDescription(String description);
}
