package mk.dmt.transbeat.repository;

import mk.dmt.transbeat.entity.TransportServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportServiceRepository extends JpaRepository<TransportServiceEntity, Long> {
}
