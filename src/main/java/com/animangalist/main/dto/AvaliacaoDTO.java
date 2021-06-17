package com.animangalist.main.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AvaliacaoDTO {

    @NotNull(message = "é necessário informar o usuário")
    private Long idUsuario;

    @NotNull(message = "é necessário indicar a obra")
    private Long idObra;

    @NotNull(message = "nota é obrigatório")
    @Min(value = 0, message = "nota dever ser maior ou igual a 0")
    @Max(value = 10, message = "A maior nota possivel é 10")
    private Double nota;

    private String descricao;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdObra() {
        return idObra;
    }

    public void setIdObra(Long idObra) {
        this.idObra = idObra;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
