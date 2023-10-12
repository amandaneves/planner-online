package dev.amandaneves.plannerspring.repositories;

import dev.amandaneves.plannerspring.models.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TarefaRepository extends JpaRepository<Tarefa, UUID> {
}
