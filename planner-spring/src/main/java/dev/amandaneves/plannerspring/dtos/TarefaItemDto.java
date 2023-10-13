package dev.amandaneves.plannerspring.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

public class TarefaItemDto {

    @NotBlank
    @Size(max = 150)
    private String descricao;
    @NotNull
    private UUID tarefaId;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public UUID getTarefaId() {
        return tarefaId;
    }

    public void setTarefaId(UUID tarefaId) {
        this.tarefaId = tarefaId;
    }
}
