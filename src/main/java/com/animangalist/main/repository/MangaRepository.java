package com.animangalist.main.repository;

import com.animangalist.main.entity.AnimeEntity;
import com.animangalist.main.entity.MangaEntity;
import com.animangalist.main.types.GenreTypes;
import com.animangalist.main.types.StatusTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MangaRepository extends JpaRepository<MangaEntity, Long> {
    List<MangaEntity> findAllByGenero (GenreTypes genero);
    List<MangaEntity> findAllByStatus (StatusTypes status);
    List<MangaEntity> findAllByAutorLike (String autor);
}
