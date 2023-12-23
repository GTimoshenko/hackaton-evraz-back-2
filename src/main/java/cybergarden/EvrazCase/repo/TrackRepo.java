package cybergarden.EvrazCase.repo;

import cybergarden.EvrazCase.entity.TrackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepo extends JpaRepository<TrackEntity, Long> {
}
