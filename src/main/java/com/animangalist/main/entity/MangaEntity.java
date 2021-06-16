package com.animangalist.main.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class MangaEntity extends ObraEntity implements Serializable {
    //TODO acho que os valores podem ser private pq nao pertencem a mais nada
    //TODO Usar Integer no lugar de int, tem mais funcionalidade


    @Column(name = "MANGAKA")
    public String mangakas;

    @Column(name = "CAPITULOS")
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
