package com.animangalist.main.controller;

import com.animangalist.main.entity.AnimeEntity;
import com.animangalist.main.entity.UsuarioEntity;
import com.animangalist.main.services.AnimeService;
import com.animangalist.main.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends AbstractController{

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody UsuarioEntity anime) throws Exception {
        return buildResponse(() -> usuarioService.criarUsuario(anime));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable("id") Long id) {
        return buildResponse(() -> usuarioService.buscarUsuarioPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarDadosPorId(@PathVariable("id") Long id, @RequestBody UsuarioEntity anime) {
        return buildResponse(() -> usuarioService.editarUsuario(anime, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarPorId(@PathVariable("id") Long id) {
        return buildResponse(() -> usuarioService.deletarUsuarioPorId(id));
    }

}
