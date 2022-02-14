package sb.monsterBrewer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.monsterBrewer.models.Reaction;

public interface ReactionRepository extends JpaRepository<Reaction, Long> {
}