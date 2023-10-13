package dev.amandaneves.plannerspring.services;

import dev.amandaneves.plannerspring.models.TarefaItem;
import dev.amandaneves.plannerspring.repositories.TarefaItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TarefaItemService {

    @Autowired
    TarefaItemRepository tarefaItemRepository;

    @Transactional
    public TarefaItem save(TarefaItem tarefaItem) {
        return tarefaItemRepository.save(tarefaItem);
    }

    public List<TarefaItem> findAll() {
        return tarefaItemRepository.findAll();
    }

    public Optional<TarefaItem> findById(UUID id) {
        return tarefaItemRepository.findById(id);
    }

    @Transactional
    public void delete(TarefaItem tarefaItem) {
        tarefaItemRepository.delete(tarefaItem);
    }
}
