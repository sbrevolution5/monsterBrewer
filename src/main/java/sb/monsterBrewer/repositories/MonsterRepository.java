package sb.monsterBrewer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.monsterBrewer.models.Monster;

public interface MonsterRepository extends JpaRepository<Monster, Long> {

}
