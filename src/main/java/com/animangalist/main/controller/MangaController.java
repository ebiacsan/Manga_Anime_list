package com.animangalist.main.controller;


import com.animangalist.main.Obra;
import com.animangalist.main.dto.request.MangaDataRequestDTO;
import com.animangalist.main.dto.response.MangaListResponseDTO;
import com.animangalist.main.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manga")
public class MangaController {
    //TODO Mudar nome da classe para MangaController

    @Autowired
    MangaService mangaService;
    //int capitulos;
    //String artistas; //mangaka

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody MangaDataRequestDTO dataDTO) throws Exception {
        mangaService.registration(dataDTO);
        return ResponseEntity.ok().build();
    }

//    @GetMapping("/buscar")
//    public ResponseEntity<MangaListResponseDTO> buscar() throws Exception { //buscando todos os animes e já retorna em ordem alfabeteica
//        return ResponseEntity.ok(mangaService.mangaList());
//    }

    @PutMapping("/update")
    public ResponseEntity<?> alterarDados(@RequestBody MangaDataRequestDTO dataDTO) throws Exception {
        mangaService.dataUpdate(dataDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) throws Exception {
        mangaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
