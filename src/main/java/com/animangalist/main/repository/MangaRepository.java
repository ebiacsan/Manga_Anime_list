package com.animangalist.main.repository;

import com.animangalist.main.entity.MangaEntity;
import com.animangalist.main.types.GenreTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MangaRepository extends JpaRepository<MangaEntity, Long> {
    List<MangaEntity> findByGenero (GenreTypes genero);

    List<MangaEntity> findByLancamento (Integer ano);
}
