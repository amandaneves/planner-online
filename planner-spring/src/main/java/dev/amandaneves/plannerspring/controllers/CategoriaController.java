package dev.amandaneves.plannerspring.controllers;

import dev.amandaneves.plannerspring.dtos.CategoriaDto;
import dev.amandaneves.plannerspring.models.Categoria;
import dev.amandaneves.plannerspring.services.CategoriaService;
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
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Object> saveCategoria(@RequestBody @Valid CategoriaDto categoriaDto) {
        if(categoriaService.existsByDescricao(categoriaDto.getDescricao())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Categoria já existe!");
        }

        var categoria = new Categoria();
        BeanUtils.copyProperties(categoriaDto, categoria);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
    }

    @GetMapping
    public ResponseEntity<Object> getAllCategorias() {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategoria(@PathVariable(value = "id") UUID id) {
        Optional<Categoria> categoriaOptional = categoriaService.findById(id);
        if(!categoriaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(categoriaOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategoria(@PathVariable(value = "id") UUID id) {
        Optional<Categoria> categoriaOptional = categoriaService.findById(id);
        if(!categoriaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada.");
        }
        categoriaService.delete(categoriaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Categoria excluída com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCategoria(@PathVariable(value = "id") UUID id, @RequestBody @Valid CategoriaDto categoriaDto) {
        Optional<Categoria> categoriaOptional = categoriaService.findById(id);
        if(!categoriaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada.");
        }

        var categoria = new Categoria();
        BeanUtils.copyProperties(categoriaDto, categoria);
        categoria.setId(categoriaOptional.get().getId());

        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.save(categoria));
    }
}
