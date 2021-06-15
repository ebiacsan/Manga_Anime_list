package com.animangalist.main.service;

import com.animangalist.main.Repository.AnimeRepository;
import com.animangalist.main.dto.request.AnimeDataRequestDTO;
import com.animangalist.main.dto.response.AnimeListResponseDTO;
import com.animangalist.main.dto.response.AnimeResposneDTO;
import com.animangalist.main.entity.AnimeEntity;
import com.animangalist.main.types.GenreTypes;
import com.animangalist.main.types.StatusTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    public void registration(AnimeDataRequestDTO dataDTO) throws Exception {
        if (dataDTO == null) throw new Exception();
        AnimeEntity anime = new AnimeEntity();
        anime.setId(dataDTO.getAnimeId());
        anime.setObra(dataDTO.getObra());
        anime.setDirecao(dataDTO.getDirecao());
        anime.setEstudio(dataDTO.getEstudio());
        anime.setQuantidadeEpisodios(dataDTO.getQuantidadeEpisodios());

        animeRepository.save(anime);
    }

    public AnimeResposneDTO animeById(Long id) throws Exception {
        AnimeResposneDTO anime = animeRepository.findAnimeEntityById(id);
        if (anime == null) throw new Exception();

        return anime;
    }

    public AnimeListResponseDTO animeListByGenre(GenreTypes genero) throws Exception {
        List<AnimeResposneDTO> anime = animeRepository.findByGenre(genero);
        //anime = anime.stream().filter(e -> e.getGenero().equals(genero)).collect(Collectors.toList()); se nao estiver filtrado por genero utilizar isso aqui
        if (anime == null) throw new Exception();
        OrdemAlfabetica(anime);

        return new AnimeListResponseDTO(anime);
    }

    public AnimeListResponseDTO animeListAlphaOrder() throws Exception {
        List<AnimeResposneDTO> anime = animeRepository.findAllAnime();
        if (anime == null) throw new Exception();
        OrdemAlfabetica(anime);

        return new AnimeListResponseDTO(anime);
    }

    public AnimeListResponseDTO animeListByStatus(StatusTypes status) throws Exception {
        List<AnimeResposneDTO> anime = animeRepository.findAllAnime();
        if (anime == null) {
            throw new Exception();
        }
        anime = anime.stream().filter(e -> e.getObra().getStatus().equals(status)).collect(Collectors.toList()); //filtrando os animes pelo status fornecido
        OrdemAlfabetica(anime);

        return new AnimeListResponseDTO(anime);
    }

    public AnimeListResponseDTO animeListByAutor(String autor) throws Exception {
        List<AnimeResposneDTO> anime = animeRepository.findAllAnime();
        if (anime == null) throw new Exception();
        anime = anime.stream().filter(e -> e.getObra().getAutor().equals(autor)).collect(Collectors.toList());
        OrdemAlfabetica(anime);

        return new AnimeListResponseDTO(anime);
    }


    public AnimeListResponseDTO animeListByYear(Integer ano) throws Exception {
        List<AnimeResposneDTO> anime = animeRepository.findAllAnime();
        if (anime == null) throw new Exception();
        anime = anime.stream().filter(e -> e.getObra().getLancamento().equals(ano)).collect(Collectors.toList());
        OrdemAlfabetica(anime);

        return new AnimeListResponseDTO(anime);
    }

    public void dataUpdate(AnimeDataRequestDTO dataDTO) throws Exception {
        AnimeEntity anime = animeRepository.findById(dataDTO.getAnimeId())
                .orElseThrow(Exception::new);
        dataUpdate(anime, dataDTO);
    }

    public void delete(Long id) throws Exception {
        AnimeEntity anime = animeRepository.findById(id).get();
        if (anime == null) throw new Exception();

        animeRepository.delete(anime);
    }

    private List<AnimeResposneDTO> OrdemAlfabetica(List<AnimeResposneDTO> anime) {
        anime.sort(new Comparator<AnimeResposneDTO>() {     //nao sei se esse metodo de ordenar funciona
            @Override
            public int compare(AnimeResposneDTO o1, AnimeResposneDTO o2) {
                return o1.getObra().getTitulo().compareTo(o2.getObra().getTitulo());
            }
        });

        return anime;
    }

    private void dataUpdate(AnimeEntity anime, AnimeDataRequestDTO dataDTO) {
        anime.setId(dataDTO.getAnimeId());
        anime.setDirecao(dataDTO.getDirecao());
        anime.setEstudio(dataDTO.getEstudio());
        anime.setQuantidadeEpisodios(dataDTO.getQuantidadeEpisodios());
        anime.setObra(dataDTO.getObra());

        animeRepository.save(anime);
    }
}
