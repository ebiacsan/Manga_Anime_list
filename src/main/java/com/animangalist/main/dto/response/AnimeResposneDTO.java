package com.animangalist.main.dto.response;

import com.animangalist.main.entity.ObraEntity;

public class AnimeResposneDTO {
    //TODO acho que tem que fazer um joincollum pra pegar as coisas das obras
    //TODO passar uma onbra aqui dentro

    private Long animeId;
    private Long quantidadeEpisodios;
    private String estudio;
    private String direcao;
    private ObraEntity obra;

    public AnimeResposneDTO(Long animeId, Long quantidadeEpisodios, String estudio, String direcao, ObraEntity obra) {
        this.animeId = animeId;
        this.quantidadeEpisodios = quantidadeEpisodios;
        this.estudio = estudio;
        this.direcao = direcao;
        this.obra = obra;
    }

    public Long getAnimeId() {
        return animeId;
    }

    public void setAnimeId(Long animeId) {
        this.animeId = animeId;
    }

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

    public ObraEntity getObra() {
        return obra;
    }

    public void setObra(ObraEntity obra) {
        this.obra = obra;
    }
}
