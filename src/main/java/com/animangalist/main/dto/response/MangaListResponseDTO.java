package com.animangalist.main.dto.response;

import java.util.List;

public class MangaListResponseDTO {
    private List<MangaResponseDTO> response;

    public MangaListResponseDTO(List<MangaResponseDTO> response) {
        this.response = response;
    }

    public List<MangaResponseDTO> getResponse() {
        return response;
    }

    public void setResponse(List<MangaResponseDTO> response) {
        this.response = response;
    }
}
