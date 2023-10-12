package dev.amandaneves.plannerspring.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "metas")
public class Meta extends DataCadastro {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "objetivo_id", nullable = false, referencedColumnName = "id")
    private Objetivo objetivo;

    @Column(nullable = false, length = 130)
    private String descricao;

    @Column(nullable = false, columnDefinition = "int default 0")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean concluida;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}
