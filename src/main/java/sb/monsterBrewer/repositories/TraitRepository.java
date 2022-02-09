package sb.monsterBrewer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.monsterBrewer.models.Trait;

public interface TraitRepository extends JpaRepository<Trait, Long> {
}