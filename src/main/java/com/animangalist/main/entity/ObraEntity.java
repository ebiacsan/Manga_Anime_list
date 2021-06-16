package com.animangalist.main.entity;

import com.animangalist.main.types.GenreTypes;
import com.animangalist.main.types.ObraTypes;
import com.animangalist.main.types.StatusTypes;

import javax.persistence.*;

@Entity
@Table(name = "TB_OBRA")
public class ObraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_OBRA")
    private Long id;

    @Column(name = "GENERO")
    private GenreTypes genero;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "STATUS")
    private StatusTypes status;

    @Column(name = "AUTOR")
    private String autor;

    @Column(name = "TIPO")
    private ObraTypes tipo;

    @Column(name = "LANCAMENTO")
    private Integer lancamento;

    @Column(name = "NOTA")
    private Integer nota;

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

    public Integer getLancamento() {
        return lancamento;
    }

    public void setLancamento(Integer lancamento) {
        this.lancamento = lancamento;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }
}
