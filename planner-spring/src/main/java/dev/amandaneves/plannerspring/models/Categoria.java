package dev.amandaneves.plannerspring.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "categorias")
public class Categoria extends DataCadastro {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 50)
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private Collection<Tarefa> tarefas = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Collection<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(Collection<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
}
