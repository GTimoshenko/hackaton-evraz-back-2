package cybergarden.EvrazCase.repo;

import cybergarden.EvrazCase.entity.DestinationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestRepo extends JpaRepository<DestinationEntity, Long> {
}
