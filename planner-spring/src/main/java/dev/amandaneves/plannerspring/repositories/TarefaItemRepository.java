package dev.amandaneves.plannerspring.repositories;

import dev.amandaneves.plannerspring.models.TarefaItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TarefaItemRepository extends JpaRepository<TarefaItem, UUID> {
}
