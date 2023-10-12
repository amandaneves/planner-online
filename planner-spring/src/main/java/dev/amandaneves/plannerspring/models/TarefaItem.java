package dev.amandaneves.plannerspring.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tarefa_itens")
public class TarefaItem extends DataCadastro {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "tarefa_id", nullable = false, referencedColumnName = "id")
    private Tarefa tarefa;

    @Column(nullable = false)
    private String descricao;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
