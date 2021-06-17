package com.animangalist.main.controller;

import com.animangalist.main.entity.AnimeEntity;
import com.animangalist.main.entity.MangaEntity;
import com.animangalist.main.entity.ObraEntity;
import com.animangalist.main.services.AnimeService;
import com.animangalist.main.services.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/manga")
public class MangaController extends AbstractController{

    @Autowired
    private MangaService mangaService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody MangaEntity manga) {
        return buildResponse(() -> mangaService.cadastrarManga(manga));
    }

    @GetMapping("/ordem")
    public ResponseEntity buscarEmOrdemAlfabetica() {
        return buildResponse(() -> {
                    return mangaService.buscarTodosMangas()
                            .stream()
                            .sorted(Comparator.comparing(ObraEntity::getTitulo))
                            .collect(Collectors.toList());
                }
        );
    }


    @GetMapping("/genero/{idGenero}")
    public ResponseEntity buscarPorGenero(@PathVariable("idGenero") Integer idGenero) {
        return buildResponse(() -> mangaService.buscarPorGenero(idGenero));
    }

    @GetMapping("/status/{idStatus}")
    public ResponseEntity buscarPorStatus(@PathVariable("idStatus") Integer idStatus) {
        return buildResponse(() -> mangaService.buscarPorGenero(idStatus));
    }

    @GetMapping("/autor")
    public ResponseEntity buscarPorNome(@RequestParam(value = "nome", defaultValue = "") String nome) {
        return buildResponse(() -> mangaService.buscarPorAutor(nome));
    }

    @GetMapping("/lancamento")
    public ResponseEntity buscarPorAno(@RequestParam(value = "ano") Integer ano) {
        return buildResponse(() -> mangaService.buscarPorAnoDePublicacao(ano == null ? LocalDate.now().getYear() : ano));
    }

    @GetMapping
    public ResponseEntity buscarTodos() {
        return buildResponse(() -> mangaService.buscarTodosMangas());
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable("id") Long id) {
        return buildResponse(() -> mangaService.buscarAnimePorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarDadosPorId(@PathVariable("id") Long id, @RequestBody MangaEntity manga) {
        return buildResponse(() -> mangaService.editarManga(manga, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarPorId(@PathVariable("id") Long id) {
        return buildResponse(() -> mangaService.deletarMangaPorId(id));
    }

}
