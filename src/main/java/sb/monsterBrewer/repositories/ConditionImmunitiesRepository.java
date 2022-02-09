package sb.monsterBrewer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.monsterBrewer.models.ConditionImmunities;

public interface ConditionImmunitiesRepository<ConditionImmunities, ID> extends JpaRepository<ConditionImmunities, ID> {
}