package com.animangalist.main.dto.request;

import com.animangalist.main.entity.ObraEntity;

public class MangaDataRequestDTO {
    private Long mangaId;
    private String mangakas;
    private Integer capitulos;
    private ObraEntity obra;

    public MangaDataRequestDTO(Long mangaId, String mangakas, Integer capitulos, ObraEntity obra) {
        this.mangaId = mangaId;
        this.mangakas = mangakas;
        this.capitulos = capitulos;
        this.obra = obra;
    }

    public Long getMangaId() {
        return mangaId;
    }

    public void setMangaId(Long mangaId) {
        this.mangaId = mangaId;
    }

    public String getMangakas() {
        return mangakas;
    }

    public void setMangakas(String mangakas) {
        this.mangakas = mangakas;
    }

    public Integer getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(Integer capitulos) {
        this.capitulos = capitulos;
    }

    public ObraEntity getObra() {
        return obra;
    }

    public void setObra(ObraEntity obra) {
        this.obra = obra;
    }
}
