package com.animangalist.main.services;

import com.animangalist.main.entity.AnimeEntity;
import com.animangalist.main.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    public void cadastrarAnime(AnimeEntity anime){
        this.animeRepository.save(anime);
    }

    public List<AnimeEntity> buscarTodosAnimes(){
        return this.animeRepository.findAll();
    }

    public void deletarAnimePorId(Long id){
        this.animeRepository.deleteById(id);
    }

    public void editarAnime(AnimeEntity novosDadosAnime, Long id){
        AnimeEntity animeAntigo = (AnimeEntity) this.buscarTodosAnimes();

        animeAntigo.setDirecao(novosDadosAnime.getDirecao());
        animeAntigo.setEstudio(novosDadosAnime.getEstudio());
        animeAntigo.setDescricao(novosDadosAnime.getDescricao());
        animeAntigo.setQuantidadeEpisodios(novosDadosAnime.getQuantidadeEpisodios());
        animeAntigo.setStatus(novosDadosAnime.getStatus());
        animeAntigo.setTitulo(novosDadosAnime.getTitulo());
        animeAntigo.setGenero(novosDadosAnime.getGenero());
    }
}
