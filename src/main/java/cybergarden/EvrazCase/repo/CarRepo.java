package cybergarden.EvrazCase.repo;

import cybergarden.EvrazCase.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<CarEntity, Long> {
}
