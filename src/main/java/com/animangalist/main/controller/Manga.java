package com.animangalist.main.controller;


import com.animangalist.main.Obra;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manga")
public class Manga extends Obra {
    //int capitulos;
    //String artistas; //mangaka

    @PostMapping
    public void cadastrar(){
    }

    @GetMapping
    public void buscar(){
    }

    @PutMapping
    public void alterarDados(){
    }

    @DeleteMapping
    public void remover(){
    }

}
