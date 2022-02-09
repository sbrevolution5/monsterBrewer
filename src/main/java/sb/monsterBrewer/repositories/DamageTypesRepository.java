package sb.monsterBrewer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.monsterBrewer.models.DamageTypes;

public interface DamageTypesRepository<DamageTypes, ID> extends JpaRepository<DamageTypes, ID> {
}