package com.animangalist.main.entity;

import com.animangalist.main.types.GenreTypes;
import com.animangalist.main.types.ObraTypes;
import com.animangalist.main.types.StatusTypes;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TB_OBRA")
public class ObraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_OBRA")
    private Long id;

    @Column(name = "GENERO")
    @NotNull(message = "genero é obrigatório")
    private GenreTypes genero;

    @Column(name = "TITULO")
    @NotBlank(message = "titulo é obrigatório")
    private String titulo;

    @Column(name = "DESCRICAO", length = 1000)
    @NotBlank(message = "descrição é obrigatório")
    private String descricao;

    @Column(name = "STATUS")
    @NotNull(message = "status é obrigatório")
    private StatusTypes status;

    @Column(name = "AUTOR")
    @NotBlank(message = "autor é obrigatório")
    private String autor;

    @Column(name = "TIPO")
    private ObraTypes tipo;

    @Column(name = "LANCAMENTO")
    private LocalDateTime lancamento;

    @OneToMany(mappedBy = "obra", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AvaliacaoEntity> avaliacoes;

    public List<AvaliacaoEntity> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<AvaliacaoEntity> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GenreTypes getGenero() {
        return genero;
    }

    public void setGenero(GenreTypes genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusTypes getStatus() {
        return status;
    }

    public void setStatus(StatusTypes status) {
        this.status = status;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public ObraTypes getTipo() {
        return tipo;
    }

    public void setTipo(ObraTypes tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getLancamento() {
        return lancamento;
    }

    public void setLancamento(LocalDateTime lancamento) {
        this.lancamento = lancamento;
    }

    @PrePersist
    @PreUpdate
    public void prePersist() {

        if(this.lancamento == null)
            this.lancamento = LocalDateTime.now();

        if(this instanceof AnimeEntity)
            this.tipo = ObraTypes.ANIME;

        if(this instanceof MangaEntity)
            this.tipo = ObraTypes.MANGA;

    }
}
