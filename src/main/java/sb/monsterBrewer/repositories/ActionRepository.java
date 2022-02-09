package sb.monsterBrewer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.monsterBrewer.models.Action;

public interface ActionRepository<Action, ID> extends JpaRepository<Action, ID> {
}