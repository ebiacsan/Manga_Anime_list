package com.animangalist.main.controller;

import com.animangalist.main.Obra;
import com.animangalist.main.entity.MangaEntity;
import com.animangalist.main.services.MangaService;
import com.animangalist.main.types.GenreTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manga")
public class MangaController {
    //TODO Mudar nome da classe para MangaController

    @Autowired
    private MangaService mangaService;


    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody MangaEntity manga) throws Exception {
        mangaService.cadastrarManga(manga);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscar() throws Exception { //buscando todos os animes e já retorna em ordem alfabeteica
        return ResponseEntity.ok(mangaService.buscarTodosMangas());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(mangaService.buscarMangaPorId(id));
    }

    @GetMapping("/buscar/{genero}")
    public ResponseEntity<?> buscarPorGenero(@PathVariable GenreTypes genero) throws Exception {
        return ResponseEntity.ok(mangaService.buscarTodosPorGenero(genero));
    }

    @GetMapping("/buscar/ano/{ano}")
    public ResponseEntity<?> buscarPorAno(@PathVariable Integer ano) throws Exception {
        return ResponseEntity.ok(mangaService.buscarTodosPorAno(ano));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> alterarDados(@RequestBody  MangaEntity manga, @PathVariable Long id) throws Exception {
        mangaService.editarManga(manga, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) throws Exception {
        mangaService.deletarMangaPorId(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<?> removerTudo() throws Exception {
        mangaService.deletarTodos();
        return ResponseEntity.ok().build();
    }
}
