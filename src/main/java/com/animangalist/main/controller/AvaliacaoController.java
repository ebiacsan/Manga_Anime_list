package com.animangalist.main.controller;

import com.animangalist.main.dto.AvaliacaoDTO;
import com.animangalist.main.entity.UsuarioEntity;
import com.animangalist.main.services.AvaliacaoService;
import com.animangalist.main.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController extends AbstractController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody AvaliacaoDTO avaliacao) throws Exception {
        return buildResponse(() -> avaliacaoService.cadastrarAvaliacao(avaliacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable("id") Long id) {
        return buildResponse(() -> avaliacaoService.buscarAvaliacaoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarDadosPorId(@PathVariable("id") Long id, @RequestBody AvaliacaoDTO avaliacao) {
        return buildResponse(() -> avaliacaoService.editarAvaliacao(avaliacao, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarPorId(@PathVariable("id") Long id) {
        return buildResponse(() -> avaliacaoService.deletarAvaliacaoPorId(id));
    }

}
