package mk.dmt.transbeat.repository;

import com.bezkoder.spring.files.csv.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}
