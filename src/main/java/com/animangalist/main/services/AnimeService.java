package com.animangalist.main.services;

import com.animangalist.main.entity.AnimeEntity;
import com.animangalist.main.repository.AnimeRepository;
import com.animangalist.main.types.GenreTypes;
import com.animangalist.main.types.StatusTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    public void cadastrarAnime( @Valid AnimeEntity anime){
        this.animeRepository.save(anime);
    }

    public List<AnimeEntity> buscarTodosAnimes(){
        return this.animeRepository.findAll();
    }

    public AnimeEntity buscarAnimePorId(Long id) throws Exception {
        return this.animeRepository.findById(id).
                orElseThrow(() -> new Exception("Não foi possível encontrar anime por ID"));
    }

    public List<AnimeEntity> buscarPorGenero(Integer idGenero){
        return this.animeRepository.findAllByGenero(GenreTypes.getById(idGenero));
    }

    public List<AnimeEntity> buscarPorStatus(Integer idStatus){
        return this.animeRepository.findAllByStatus(StatusTypes.getById(idStatus));
    }

    public List<AnimeEntity> buscarPorAutor(String nomeAutor){
        return this.animeRepository.findAllByAutorLike(nomeAutor);
    }

    public List<AnimeEntity> buscarPorAnoDePublicacao(Integer ano){
        return this.buscarTodosAnimes().stream()
                .filter(a -> a.getLancamento().getYear() == ano)
                .collect(Collectors.toList());
    }


    public void deletarAnimePorId(Long id){
        this.animeRepository.deleteById(id);
    }

    public void editarAnime(@Valid AnimeEntity novosDadosAnime, Long id) throws Exception {
        AnimeEntity animeAntigo = this.buscarAnimePorId(id);

        animeAntigo.setDirecao(novosDadosAnime.getDirecao());
        animeAntigo.setEstudio(novosDadosAnime.getEstudio());
        animeAntigo.setDescricao(novosDadosAnime.getDescricao());
        animeAntigo.setQuantidadeEpisodios(novosDadosAnime.getQuantidadeEpisodios());
        animeAntigo.setStatus(novosDadosAnime.getStatus());
        animeAntigo.setTitulo(novosDadosAnime.getTitulo());
        animeAntigo.setGenero(novosDadosAnime.getGenero());
    }
}
