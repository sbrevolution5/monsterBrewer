package sb.monsterBrewer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.monsterBrewer.models.Action;

public interface ActionRepository extends JpaRepository<Action, Long> {
}