package com.animangalist.main.service;

import com.animangalist.main.Repository.MangaRepository;
import com.animangalist.main.dto.request.MangaDataRequestDTO;
import com.animangalist.main.dto.response.MangaListResponseDTO;
import com.animangalist.main.dto.response.MangaResponseDTO;
import com.animangalist.main.entity.MangaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MangaService {
    @Autowired
    MangaRepository mangaRepository;

    public void registration(MangaDataRequestDTO dataDTO) throws Exception {
        if (dataDTO == null) throw new Exception();
        MangaEntity manga = new MangaEntity();
        manga.setId(dataDTO.getMangaId());
        manga.setMangakas(dataDTO.getMangakas());
        manga.setCapitulos(dataDTO.getCapitulos());

        mangaRepository.save(manga);
    }

//    public MangaListResponseDTO mangaList() throws Exception {
//        List<MangaResponseDTO> manga = mangaRepository.findAllManga();
//        if (manga == null) throw new Exception();
//        OrdemAlfabetica(manga);
//
//        return new MangaListResponseDTO(manga);
//    }

    public void dataUpdate(MangaDataRequestDTO dataDTO) throws Exception {
        MangaEntity manga = mangaRepository.findById(dataDTO.getMangaId())
                .orElseThrow(Exception::new);
        dataUpdate(manga, dataDTO);
    }

    public void delete(Long id) throws Exception {
        MangaEntity manga = mangaRepository.findById(id).get();
        if (manga == null) throw new Exception();

        mangaRepository.delete(manga);
    }

    private List<MangaResponseDTO> ordemAlfabetica(List<MangaResponseDTO> manga) {
        return  manga
                .stream()
                .sorted(Comparator.comparing((o) -> o.getObra().getTitulo()))
                .collect(Collectors.toList());
    }


    private void dataUpdate(MangaEntity manga, MangaDataRequestDTO dataDTO) {
        manga.setId(dataDTO.getMangaId());
        manga.setCapitulos(dataDTO.getCapitulos());
        manga.setMangakas(dataDTO.getMangakas());

        mangaRepository.save(manga);
    }
}
