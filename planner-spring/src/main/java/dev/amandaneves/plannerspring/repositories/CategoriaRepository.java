package dev.amandaneves.plannerspring.repositories;

import dev.amandaneves.plannerspring.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {

    boolean existsByDescricao(String descricao);

}
