package com.animangalist.main.entity;


import javax.persistence.*;

@Entity
@Table(name = "TB_MANGA")
public class MangaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_MANGA")
    public Long id;

    @Column(name = "MANGAKA")
    public String mangakas;

    //int capitulos;
    //String artistas; //mangaka
}
