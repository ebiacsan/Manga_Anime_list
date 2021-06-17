package com.animangalist.main.controller;

import com.animangalist.main.Obra;
import com.animangalist.main.entity.AnimeEntity;
import com.animangalist.main.types.GenreTypes;
import com.animangalist.main.types.StatusTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/anime")
public class AnimeController {
//TODO Mudar nome da classe para AnimeController

    @Autowired
    private AnimeService animeService;
//    int episodios;
//    String estudio;
//    String direcao;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody AnimeEntity anime) throws Exception {
        animeService.registration(anime);
        return ResponseEntity.ok().build();
    }

//    @GetMapping("/{id}") //é anime/id ou anime/{id}?? se vc quiser que ele passe na url vai ser {id}
//    public ResponseEntity<AnimeResposneDTO> buscarPorId(@PathVariable Long id) throws Exception {
//        return ResponseEntity.ok(animeService.animeById(id));
//    }

//    @GetMapping("/ordem")
//    public ResponseEntity<AnimeListResponseDTO> buscarEmOrdemAlfa() throws Exception {
//        return ResponseEntity.ok(animeService.animeListAlphaOrder());
//    }

//    @GetMapping("/genero/{genero}")
////    public ResponseEntity<AnimeListResponseDTO> buscarPorGenero(@PathVariable GenreTypes genero) throws Exception {
////        return ResponseEntity.ok(animeService.animeListByGenre(genero));
////    }

//    @GetMapping("/status/{status}")
//    public ResponseEntity<AnimeListResponseDTO> buscarPorStatus(@PathVariable StatusTypes status) throws Exception {
//        return ResponseEntity.ok(animeService.animeListByStatus(status));
//    }

//    @GetMapping("/Autor/{Autor}")
//    public ResponseEntity<AnimeListResponseDTO> buscarPorAutor(@PathVariable String autor) throws Exception {
//        return ResponseEntity.ok(animeService.animeListByAutor(autor));
//    }

//    @GetMapping("/ano/{ano}")
//    public ResponseEntity<AnimeListResponseDTO> buscarPorAno(@PathVariable Integer ano) throws Exception {
//        return ResponseEntity.ok(animeService.animeListByYear(ano));
//    }

    @PutMapping("/update")
    public ResponseEntity<?> alterarDados(@RequestBody AnimeDataRequestDTO dataDTO) throws Exception { //continua void pq nao tem a necessidade de retornar nada
        animeService.dataUpdate(dataDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) throws Exception {
        animeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
