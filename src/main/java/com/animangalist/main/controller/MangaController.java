package com.animangalist.main.controller;

import com.animangalist.main.Obra;
import com.animangalist.main.entity.MangaEntity;
import com.animangalist.main.services.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @GetMapping("/buscar")
//    public ResponseEntity<MangaListResponseDTO> buscar() throws Exception { //buscando todos os animes e já retorna em ordem alfabeteica
//        return ResponseEntity.ok(mangaService.mangaList());
//    }

//    @PutMapping("/update")
//    public ResponseEntity<?> alterarDados(@RequestBody MangaDataRequestDTO dataDTO) throws Exception {
//        mangaService.dataUpdate(dataDTO);
//        return ResponseEntity.ok().build();
//    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> remover(@PathVariable Long id) throws Exception {
//        mangaService.delete(id);
//        return ResponseEntity.ok().build();
//    }

}
