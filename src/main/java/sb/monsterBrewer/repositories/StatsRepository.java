package sb.monsterBrewer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.monsterBrewer.models.Stats;

public interface StatsRepository extends JpaRepository<Stats, Long> {
}