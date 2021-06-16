package com.animangalist.main.dto.response;

import com.animangalist.main.controller.AnimeController;
import com.animangalist.main.entity.AnimeEntity;

import java.util.List;

public class AnimeListResponseDTO {
    private List<AnimeResposneDTO> response;

    public AnimeListResponseDTO(List<AnimeResposneDTO> response) {
        this.response = response;
    }

    public List<AnimeResposneDTO> getResponse() {
        return response;
    }

    public void setResponse(List<AnimeResposneDTO> response) {
        this.response = response;
    }
}
