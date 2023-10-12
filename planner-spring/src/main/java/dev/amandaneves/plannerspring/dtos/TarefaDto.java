package dev.amandaneves.plannerspring.dtos;

import dev.amandaneves.plannerspring.models.Categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TarefaDto {

    @NotBlank
    @Size(max = 50)
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
