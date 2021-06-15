package com.animangalist.main.entity;

import com.animangalist.main.ObraEntity;

import javax.persistence.*;

@Entity
@Table(name = "TB_ANIME")
public class AnimeEntity extends ObraEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //acho que se usar generationType.Identity ele fica auto implementavel no banco
    @Column(name = "ID_ANIME")
    //open var id : Long? = null;
    public Long id;

    @Column(name = "QTD_EPISODIOS")
    public Long quantidadeEpisodios;

    @Column(name = "ESTUDIO")
    public String estudio;

    @Column(name = "DIRECAO")
    public String direcao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "TB_OBRA")
    private ObraEntity obra;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
