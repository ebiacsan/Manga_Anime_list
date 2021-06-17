package com.animangalist.main.services;

import com.animangalist.main.entity.MangaEntity;
import com.animangalist.main.repository.MangaRepository;
import com.animangalist.main.types.GenreTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MangaService {

    @Autowired
    private MangaRepository mangaRepository;

    public void cadastrarManga(MangaEntity manga){
        this.mangaRepository.save(manga);
    }

    public List<MangaEntity> buscarTodosMangas(){
        return this.mangaRepository.findAll();
    }

    public List<MangaEntity> buscarMangaPorId(Long id) {
        return this.mangaRepository.findById(id).stream().collect(Collectors.toList());
    }

    public void deletarMangaPorId(Long id){
        this.mangaRepository.deleteById(id);
    }

    public void deletarTodos(){
        this.mangaRepository.deleteAll();
    }

    public List<MangaEntity> buscarTodosPorGenero (GenreTypes genero) {
        return this.mangaRepository.findByGenero(genero);
    }

    public List<MangaEntity> buscarTodosPorAno (Integer ano) {
        return this.mangaRepository.findByLancamento(ano);
    }

    public void editarManga(MangaEntity novosDadosManga, Long id){
        MangaEntity mangaAntigo = (MangaEntity) this.buscarTodosMangas();

        mangaAntigo.setMangakas(novosDadosManga.getMangakas());
        mangaAntigo.setCapitulos(novosDadosManga.getCapitulos());
        mangaAntigo.setDescricao(novosDadosManga.getDescricao());
        mangaAntigo.setStatus(novosDadosManga.getStatus());
        mangaAntigo.setGenero(novosDadosManga.getGenero());
    }
}
