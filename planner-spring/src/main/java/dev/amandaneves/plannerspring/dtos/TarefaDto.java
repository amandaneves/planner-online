package dev.amandaneves.plannerspring.dtos;

import dev.amandaneves.plannerspring.models.TarefaItem;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class TarefaDto {

    @NotBlank
    @Size(max = 150)
    private String descricao;
    private UUID categoriaId;
    @NotNull
    private Long ordem;
    @NotBlank
    private String data;
    private String hora;
    private boolean concluida;
    private boolean notificar;
    private boolean repetir;
    private Collection<TarefaItem> itens = new ArrayList<>();

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public UUID getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(UUID categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Long getOrdem() {
        return ordem;
    }

    public void setOrdem(Long ordem) {
        this.ordem = ordem;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
