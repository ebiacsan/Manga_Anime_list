package com.animangalist.main.controller;

import com.animangalist.main.Obra;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/anime")
public class Anime extends Obra {
//    int episodios;
//    String estudio;
//    String direcao;

    @PostMapping
    public void cadastrar(){

    }

    @GetMapping("/id") //é anime/id ou anime/{id}??
    public void buscarPorId(){
    }

    @GetMapping("/ordem")
    public void buscarEmOrdemAlfa(){
    }

    @GetMapping("/genero")
    public void buscarPorGenero(){
    }

    @GetMapping("/status")
    public void buscarPorStatus(){
    }

    @GetMapping("/Autor")
    public void buscarPorAutor(){
    }

    @GetMapping("/ano")
    public void buscarPorAno(){
    }

    @PutMapping("/{id}")
    public void alterarDados(){
    }

    @DeleteMapping("/{id}")
    public void remover(){
    }


}
