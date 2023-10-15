package dev.amandaneves.plannerspring.services;

import dev.amandaneves.plannerspring.models.Tarefa;
import dev.amandaneves.plannerspring.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class TarefaService {

    @Autowired
    TarefaRepository tarefaRepository;

    @Transactional
    public Tarefa save(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> findAll() {
        return tarefaRepository.findAll(Sort.by(Sort.Direction.ASC, "createdAt"));
    }

    public Optional<Tarefa> findById(UUID id) {
        return tarefaRepository.findById(id);
    }

    @Transactional
    public void delete(Tarefa tarefa) {
        tarefaRepository.delete(tarefa);
    }
}
