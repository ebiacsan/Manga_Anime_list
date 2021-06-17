package com.animangalist.main.services;

import com.animangalist.main.entity.MangaEntity;
import com.animangalist.main.repository.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void deletarMangaPorId(Long id){
        this.mangaRepository.deleteById(id);
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
