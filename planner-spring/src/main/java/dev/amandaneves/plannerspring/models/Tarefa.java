package dev.amandaneves.plannerspring.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "tarefas")
public class Tarefa extends DataCadastro {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private Categoria categoria;

    @Column(nullable = false, length = 150)
    private String descricao;

    @Column(nullable = false)
    private Long ordem;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column
    private String hora;

    @Column(nullable = false, columnDefinition = "int default 0")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean concluida;

    @Column(nullable = false, columnDefinition = "int default 0")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean notificar;

    @Column(nullable = false, columnDefinition = "int default 0")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean repetir;

    @OneToMany(mappedBy = "tarefa")
    private Collection<TarefaItem> itens  = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getOrdem() {
        return ordem;
    }

    public void setOrdem(Long ordem) {
        this.ordem = ordem;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public boolean isNotificar() {
        return notificar;
    }

    public void setNotificar(boolean notificar) {
        this.notificar = notificar;
    }

    public boolean isRepetir() {
        return repetir;
    }

    public void setRepetir(boolean repetir) {
        this.repetir = repetir;
    }

    public Collection<TarefaItem> getItens() {
        return itens;
    }

    public void setItens(Collection<TarefaItem> itens) {
        this.itens = itens;
    }
}
