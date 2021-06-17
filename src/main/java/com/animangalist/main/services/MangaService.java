package com.animangalist.main.services;

import com.animangalist.main.entity.AnimeEntity;
import com.animangalist.main.entity.MangaEntity;
import com.animangalist.main.repository.MangaRepository;
import com.animangalist.main.types.GenreTypes;
import com.animangalist.main.types.StatusTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MangaService {

    @Autowired
    private MangaRepository mangaRepository;

    public void cadastrarManga( @Valid MangaEntity manga){
        this.mangaRepository.save(manga);
    }

    public List<MangaEntity> buscarTodosMangas(){
        return this.mangaRepository.findAll();
    }

    public MangaEntity buscarAnimePorId(Long id) throws Exception {
        return this.mangaRepository.findById(id).
                orElseThrow(() -> new Exception("Não foi possível encontrar manga por ID"));
    }

    public void deletarMangaPorId(Long id){
        this.mangaRepository.deleteById(id);
    }

    public void editarManga( @Valid MangaEntity novosDadosManga, Long id) throws Exception {
        MangaEntity mangaAntigo = this.buscarAnimePorId(id);

        mangaAntigo.setMangakas(novosDadosManga.getMangakas());
        mangaAntigo.setCapitulos(novosDadosManga.getCapitulos());
        mangaAntigo.setDescricao(novosDadosManga.getDescricao());
        mangaAntigo.setStatus(novosDadosManga.getStatus());
        mangaAntigo.setGenero(novosDadosManga.getGenero());
    }

    public List<MangaEntity> buscarPorGenero(Integer idGenero){
        return this.mangaRepository.findAllByGenero(GenreTypes.getById(idGenero));
    }

    public List<MangaEntity> buscarPorStatus(Integer idStatus){
        return this.mangaRepository.findAllByStatus(StatusTypes.getById(idStatus));
    }

    public List<MangaEntity> buscarPorAutor(String nomeAutor){
        return this.mangaRepository.findAllByAutorLike(nomeAutor);
    }

    public List<MangaEntity> buscarPorAnoDePublicacao(Integer ano){
        return this.buscarTodosMangas().stream()
                .filter(a -> a.getLancamento().getYear() == ano)
                .collect(Collectors.toList());
    }

}
