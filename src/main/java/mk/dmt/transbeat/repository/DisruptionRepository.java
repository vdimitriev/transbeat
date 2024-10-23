package mk.dmt.transbeat.repository;

import mk.dmt.transbeat.entity.DisruptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisruptionRepository extends JpaRepository<DisruptionEntity, Long>  {
}
