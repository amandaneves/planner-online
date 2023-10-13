package dev.amandaneves.plannerspring.controllers;

import dev.amandaneves.plannerspring.dtos.TarefaDto;
import dev.amandaneves.plannerspring.models.Categoria;
import dev.amandaneves.plannerspring.models.Tarefa;
import dev.amandaneves.plannerspring.services.CategoriaService;
import dev.amandaneves.plannerspring.services.TarefaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    TarefaService tarefaService;

    @Autowired
    CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Object> saveTarefa(@RequestBody @Valid TarefaDto tarefaDto) {
        var tarefa = new Tarefa();
        BeanUtils.copyProperties(tarefaDto, tarefa);

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        tarefa.setData(LocalDate.parse(tarefaDto.getData(), pattern));

        if (tarefaDto.getCategoriaId() != null) {
            Optional<Categoria> categoriaOptional = categoriaService.findById(tarefaDto.getCategoriaId());
            if (!categoriaOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada.");
            }

            tarefa.setCategoria(categoriaOptional.get());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.save(tarefa));
    }

    @GetMapping
    public ResponseEntity<Object> getAllTarefas() {
        return ResponseEntity.status(HttpStatus.OK).body(tarefaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTarefa(@PathVariable(value = "id") UUID id) {
        Optional<Tarefa> tarefaOptional = tarefaService.findById(id);
        if(!tarefaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(tarefaOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTarefa(@PathVariable(value = "id") UUID id) {
        Optional<Tarefa> tarefaOptional = tarefaService.findById(id);
        if(!tarefaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada.");
        }
        tarefaService.delete(tarefaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Tarefa excluída com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTarefa(@PathVariable(value = "id") UUID id, @RequestBody @Valid TarefaDto tarefaDto) {
        Optional<Tarefa> tarefaOptional = tarefaService.findById(id);
        if (!tarefaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada.");
        }

        var tarefa = new Tarefa();
        BeanUtils.copyProperties(tarefaDto, tarefa);
        tarefa.setId(tarefaOptional.get().getId());

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        tarefa.setData(LocalDate.parse(tarefaDto.getData(), pattern));

        if (tarefaDto.getCategoriaId() != null) {
            Optional<Categoria> categoriaOptional = categoriaService.findById(tarefaDto.getCategoriaId());
            if (!categoriaOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada.");
            }

            tarefa.setCategoria(categoriaOptional.get());
        }

        return ResponseEntity.status(HttpStatus.OK).body(tarefaService.save(tarefa));
    }
}
