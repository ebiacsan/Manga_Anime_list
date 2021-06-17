package com.animangalist.main.controller;

import com.animangalist.main.entity.AnimeEntity;
import com.animangalist.main.entity.ObraEntity;
import com.animangalist.main.services.AnimeService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/anime")
public class AnimeController extends AbstractController{

    @Autowired
    private AnimeService animeService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody AnimeEntity anime) throws Exception {
        return buildResponse(() -> animeService.cadastrarAnime(anime));
    }

    @GetMapping
    public ResponseEntity buscarTodos() {
        return buildResponse(() -> animeService.buscarTodosAnimes());
    }

    @GetMapping("/ordem")
    public ResponseEntity buscarEmOrdemAlfabetica() {
        return buildResponse(() -> {
                    return animeService.buscarTodosAnimes()
                            .stream()
                            .sorted(Comparator.comparing(ObraEntity::getTitulo))
                            .collect(Collectors.toList());
                }
        );
    }

    @GetMapping("/genero/{idGenero}")
    public ResponseEntity buscarPorGenero(@PathVariable("idGenero") Integer idGenero) {
        return buildResponse(() -> animeService.buscarPorGenero(idGenero));
    }

    @GetMapping("/status/{idStatus}")
    public ResponseEntity buscarPorStatus(@PathVariable("idStatus") Integer idStatus) {
        return buildResponse(() -> animeService.buscarPorGenero(idStatus));
    }

    @GetMapping("/autor")
    public ResponseEntity buscarPorNome(@RequestParam("nome") String nome) {
        return buildResponse(() -> animeService.buscarPorAutor(nome));
    }

    @GetMapping("/lancamento")
    public ResponseEntity buscarPorAno(@RequestParam("ano") Integer ano) {
        return buildResponse(() -> animeService.buscarPorAnoDePublicacao(ano == null ? LocalDate.now().getYear() : ano));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable("id") Long id) {
        return buildResponse(() -> animeService.buscarAnimePorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarDadosPorId(@PathVariable("id") Long id, @RequestBody AnimeEntity anime) {
        return buildResponse(() -> animeService.editarAnime(anime, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarPorId(@PathVariable("id") Long id) {
        return buildResponse(() -> animeService.deletarAnimePorId(id));
    }

}
