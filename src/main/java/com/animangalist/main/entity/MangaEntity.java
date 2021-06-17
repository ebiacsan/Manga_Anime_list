package com.animangalist.main.entity;

import com.animangalist.main.types.ObraTypes;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class MangaEntity extends ObraEntity implements Serializable {
    //TODO acho que os valores podem ser private pq nao pertencem a mais nada
    //TODO Usar Integer no lugar de int, tem mais funcionalidade


    @Column(name = "MANGAKA")
    public String mangakas;

    @Column(name = "CAPITULOS")
    @Min(value = 1, message = "a quantidade de capitulos deve ser maior ou igual a 1")
    @NotNull(message = "quantidade de capítulos é obrigatório")
    private int capitulos;

    public String getMangakas() {
        return mangakas;
    }

    public void setMangakas(String mangakas) {
        this.mangakas = mangakas;
    }

    public int getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(int capitulos) {
        this.capitulos = capitulos;
    }
}
