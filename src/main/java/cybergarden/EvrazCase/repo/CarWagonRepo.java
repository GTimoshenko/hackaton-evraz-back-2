package cybergarden.EvrazCase.repo;

import cybergarden.EvrazCase.entity.CarWagonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarWagonRepo extends JpaRepository<CarWagonEntity, Long> {
}
