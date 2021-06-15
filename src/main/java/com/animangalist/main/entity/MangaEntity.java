package com.animangalist.main.entity;
import com.animangalist.main.ObraEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_MANGA")
public class MangaEntity implements Serializable {
    //TODO acho que os valores podem ser private pq nao pertencem a mais nada
    //TODO Usar Integer no lugar de int, tem mais funcionalidade

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_MANGA")
    public Long id;

    @Column(name = "MANGAKA")
    public String mangakas;

    @Column(name = "CAPITULOS")
    private int capitulos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TB_OBRA")
    private ObraEntity obra;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public ObraEntity getObra() {
        return obra;
    }

    public void setObra(ObraEntity obra) {
        this.obra = obra;
    }

    //int capitulos;
    //String artistas; //mangaka
}
