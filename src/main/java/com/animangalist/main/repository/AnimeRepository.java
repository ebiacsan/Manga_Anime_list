package com.animangalist.main.repository;

import com.animangalist.main.entity.AnimeEntity;
import com.animangalist.main.types.GenreTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimeRepository extends JpaRepository<AnimeEntity, Long> {

    Optional<AnimeEntity> findAnimeEntityById(Long id);

    List<AnimeEntity> findAllByGenero (GenreTypes genero);
}