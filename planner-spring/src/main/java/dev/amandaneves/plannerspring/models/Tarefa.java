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
    @JoinColumn(name = "categoria_id", nullable = false, referencedColumnName = "id")
    private Categoria categoria;

    @Column(nullable = false, length = 120)
    private String descricao;

    @Column(nullable = false)
    private Long ordem;

    @Column(name = "data_vencimento", nullable = false)
    private LocalDate dataVencimento;

    @Column
    private String hora;

    @Column(nullable = false, columnDefinition = "int default 0")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean concluida;

    @Column(nullable = false, columnDefinition = "int default 0")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean notificacao;

    @Column(nullable = false, columnDefinition = "int default 0")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean repeticao;

    @OneToMany(mappedBy = "tarefa")
    private Collection<TarefaItem> itens = new ArrayList<>();

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

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
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

    public boolean isNotificacao() {
        return notificacao;
    }

    public void setNotificacao(boolean notificacao) {
        this.notificacao = notificacao;
    }

    public boolean isRepeticao() {
        return repeticao;
    }

    public void setRepeticao(boolean repeticao) {
        this.repeticao = repeticao;
    }

    public Collection<TarefaItem> getItens() {
        return itens;
    }

    public void setItens(Collection<TarefaItem> itens) {
        this.itens = itens;
    }
}
