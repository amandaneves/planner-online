package dev.amandaneves.plannerspring.services;

import dev.amandaneves.plannerspring.models.Categoria;
import dev.amandaneves.plannerspring.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Transactional
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll(Sort.by(Sort.Direction.ASC, "createdAt"));
    }

    public Optional<Categoria> findById(UUID id) {
        return categoriaRepository.findById(id);
    }

    public boolean existsByDescricao(String descricao) {
        return categoriaRepository.existsByDescricao(descricao);
    }

    @Transactional
    public void delete(Categoria categoria) {
        categoriaRepository.delete(categoria);
    }
}
