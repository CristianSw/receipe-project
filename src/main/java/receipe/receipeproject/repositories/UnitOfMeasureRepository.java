package receipe.receipeproject.repositories;

import org.springframework.data.repository.CrudRepository;
import receipe.receipeproject.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure,Long> {
    Optional<UnitOfMeasure> findByDescription(String description);
}
