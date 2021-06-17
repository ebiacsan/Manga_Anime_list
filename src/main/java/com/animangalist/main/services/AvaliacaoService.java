package com.animangalist.main.services;

import com.animangalist.main.dto.AvaliacaoDTO;
import com.animangalist.main.entity.AvaliacaoEntity;
import com.animangalist.main.entity.ObraEntity;
import com.animangalist.main.entity.UsuarioEntity;
import com.animangalist.main.repository.AnimeRepository;
import com.animangalist.main.repository.AvaliacaoRepository;
import com.animangalist.main.repository.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private AnimeRepository animeRepository;

    @Autowired
    private MangaRepository mangaRepository;

    @Autowired
    private UsuarioService usuarioService;

    public void cadastrarAvaliacao(AvaliacaoDTO avaliacaoDTO) throws Exception {

        AvaliacaoEntity avaliacaoEntity = new AvaliacaoEntity();

        UsuarioEntity usuario = usuarioService.buscarUsuarioPorId(avaliacaoDTO.getIdUsuario());
        Optional obraOpcional = animeRepository.findById(avaliacaoDTO.getIdObra());

        if(obraOpcional.isEmpty()){
            obraOpcional = mangaRepository.findById(avaliacaoDTO.getIdObra());
        }

        if(obraOpcional.isEmpty()){
            throw new Exception("Não foi possivel encontrar obra com id indicado");
        }

        avaliacaoEntity.setObra((ObraEntity) obraOpcional.get());
        avaliacaoEntity.setUsuario(usuario);
        avaliacaoEntity.setDescricao(avaliacaoDTO.getDescricao());
        avaliacaoEntity.setNota(avaliacaoDTO.getNota());
        avaliacaoRepository.save(avaliacaoEntity);
    }


    public AvaliacaoEntity buscarAvaliacaoPorId(Long id) throws Exception {
        return this.avaliacaoRepository.findById(id)
                .orElseThrow(() -> new Exception("Não foi possível encontrar a avaliação"));
    }

    public void deletarAvaliacaoPorId(Long id){
        this.avaliacaoRepository.deleteById(id);
    }

    public void editarAvaliacao( @Valid  AvaliacaoDTO avaliacaoNova, Long id) throws Exception{
        AvaliacaoEntity avaliacaoAntiga = this.buscarAvaliacaoPorId(id);
        avaliacaoAntiga.setDescricao(avaliacaoNova.getDescricao());
        avaliacaoAntiga.setNota(avaliacaoNova.getNota());
        this.avaliacaoRepository.save(avaliacaoAntiga);
    }
}
