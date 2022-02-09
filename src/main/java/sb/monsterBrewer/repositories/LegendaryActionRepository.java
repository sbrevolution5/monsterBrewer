package sb.monsterBrewer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.monsterBrewer.models.LegendaryAction;

public interface LegendaryActionRepository extends JpaRepository<LegendaryAction, Long> {
}