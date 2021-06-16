package com.animangalist.main.Repository;

import com.animangalist.main.entity.ObraEntity;
import com.animangalist.main.dto.response.AnimeResposneDTO;
import com.animangalist.main.entity.AnimeEntity;
import com.animangalist.main.types.GenreTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimeRepository extends JpaRepository<AnimeEntity, Long> {

    Optional<AnimeEntity> findAnimeEntityById(Long id);

    List<AnimeEntity> findAll();

    List<AnimeEntity> findAllByGenero (GenreTypes genero);
}