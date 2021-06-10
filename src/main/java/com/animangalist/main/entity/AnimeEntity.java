package com.animangalist.main.entity;

import javax.persistence.*;

@Entity
@Table(name = "TB_ANIME")
public class AnimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ANIME")
    //open var id : Long? = null;
    public Long id;

    @Column(name = "QTD_EPISODIOS")
    public Long quantidadeEpisodios;

    @Column(name = "ESTUDIO")
    public String estudio;

    @Column(name = "DIRECAO")
    public String direcao;

}
