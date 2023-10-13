package dev.amandaneves.plannerspring.controllers;

import dev.amandaneves.plannerspring.dtos.TarefaItemDto;
import dev.amandaneves.plannerspring.models.Tarefa;
import dev.amandaneves.plannerspring.models.TarefaItem;
import dev.amandaneves.plannerspring.services.TarefaItemService;
import dev.amandaneves.plannerspring.services.TarefaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/tarefa-itens")
public class TarefaItemController {

    @Autowired
    TarefaItemService tarefaItemService;

    @Autowired
    TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<Object> saveTarefaItem(@RequestBody @Valid TarefaItemDto tarefaItemDto) {
        Optional<Tarefa> tarefaOptional = tarefaService.findById(tarefaItemDto.getTarefaId());
        if(!tarefaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada.");
        }

        var tarefaItem = new TarefaItem();
        tarefaItem.setDescricao(tarefaItemDto.getDescricao());
        tarefaItem.setTarefa(tarefaOptional.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaItemService.save(tarefaItem));
    }

    @GetMapping
    public ResponseEntity<Object> getAllTarefasItens() {
        return ResponseEntity.status(HttpStatus.OK).body(tarefaItemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTarefaItem(@PathVariable(value = "id") UUID id) {
        Optional<TarefaItem> tarefaItemOptional = tarefaItemService.findById(id);
        if(!tarefaItemOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Subtarefa não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(tarefaItemOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTarefaItem(@PathVariable(value = "id") UUID id) {
        Optional<TarefaItem> tarefaItemOptional = tarefaItemService.findById(id);
        if(!tarefaItemOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Subtarefa não encontrada.");
        }
        tarefaItemService.delete(tarefaItemOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Subtarefa excluída com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTarefaItem(@PathVariable(value = "id") UUID id, @RequestBody @Valid TarefaItemDto tarefaItemDto) {
        Optional<TarefaItem> tarefaItemOptional = tarefaItemService.findById(id);
        if(!tarefaItemOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Subtarefa não encontrada.");
        }

        Optional<Tarefa> tarefaOptional = tarefaService.findById(tarefaItemDto.getTarefaId());
        if(!tarefaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada.");
        }

        var tarefaItem = new TarefaItem();
        BeanUtils.copyProperties(tarefaItemDto, tarefaItem);
        tarefaItem.setId(tarefaItemOptional.get().getId());
        tarefaItem.setTarefa(tarefaOptional.get());

        return ResponseEntity.status(HttpStatus.OK).body(tarefaItemService.save(tarefaItem));
    }

}
