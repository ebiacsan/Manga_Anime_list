package com.animangalist.main.entity;

import com.animangalist.main.entity.ObraEntity;
import com.animangalist.main.entity.UsuarioEntity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "TB_AVALIACAO")
public class AvaliacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_AVALIACAO")
    private Long idAvaliacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_USUARIO")
    private UsuarioEntity usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_OBRA")
    private ObraEntity obra;

    @Column(name = "NOTA_AVALIACAO")
    @NotNull(message = "nota é obrigatório")
    @Min(value = 0, message = "a nossa não pode ser inferior a 0")
    private Double nota;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "DTH_AVALIACAO")
    private LocalDateTime dataAvalicao;

    public Long getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Long idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public ObraEntity getObra() {
        return obra;
    }

    public void setObra(ObraEntity obra) {
        this.obra = obra;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataAvalicao() {
        return dataAvalicao;
    }

    public void setDataAvalicao(LocalDateTime dataAvalicao) {
        this.dataAvalicao = dataAvalicao;
    }

    @PrePersist
    public void salvarDados(){
        if(Objects.isNull(this.dataAvalicao)){
            this.dataAvalicao = LocalDateTime.now();
        }
    }
}
