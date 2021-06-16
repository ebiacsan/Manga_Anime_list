package com.animangalist.main.Repository;

import com.animangalist.main.dto.response.MangaResponseDTO;
import com.animangalist.main.entity.MangaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MangaRepository extends JpaRepository<MangaEntity, Long> {
    List<MangaEntity> findAll();
}
