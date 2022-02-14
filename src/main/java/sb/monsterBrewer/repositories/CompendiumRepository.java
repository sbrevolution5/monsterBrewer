package sb.monsterBrewer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.monsterBrewer.models.Compendium;

public interface CompendiumRepository extends JpaRepository<Compendium, Long> {
}