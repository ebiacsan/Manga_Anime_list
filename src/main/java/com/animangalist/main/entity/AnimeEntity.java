package com.animangalist.main.entity;

import com.animangalist.main.types.ObraTypes;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class AnimeEntity extends ObraEntity {

    @Column(name = "QTD_EPISODIOS")
    @Min(1)
    @NotNull(message = "quantidade de episódios é obrigatório")
    private Long quantidadeEpisodios;

    @Column(name = "ESTUDIO")
    private String estudio;

    @Column(name = "DIRECAO")
    private String direcao;

    public Long getQuantidadeEpisodios() {
        return quantidadeEpisodios;
    }

    public void setQuantidadeEpisodios(Long quantidadeEpisodios) {
        this.quantidadeEpisodios = quantidadeEpisodios;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }


}
