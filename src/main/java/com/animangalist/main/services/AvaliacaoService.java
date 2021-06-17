package com.animangalist.main.services;

import com.animangalist.main.entity.AvaliacaoEntity;
import com.animangalist.main.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public void criarAvaliacao(AvaliacaoEntity avaliacao){
        this.avaliacaoRepository.save(avaliacao);
    }

    public AvaliacaoEntity buscarAvaliacaoPorId(Long id) throws Exception {
        return this.avaliacaoRepository.findById(id)
                .orElseThrow(() -> new Exception("Não foi possível encontrar a avaliação"));
    }

    public void deletarAvaliacaoPorId(Long id){
        this.avaliacaoRepository.deleteById(id);
    }

    public void editarAvaliacao(AvaliacaoEntity avaliacaoNova, Long id) throws Exception{
        AvaliacaoEntity avaliacaoAntiga = this.buscarAvaliacaoPorId(id);
        avaliacaoAntiga.setDescricao(avaliacaoNova.getDescricao());
        avaliacaoAntiga.setNota(avaliacaoNova.getNota());
        this.avaliacaoRepository.save(avaliacaoAntiga);
    }
}
