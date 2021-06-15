package com.animangalist.main.Repository;

import com.animangalist.main.ObraEntity;
import com.animangalist.main.dto.response.AnimeResposneDTO;
import com.animangalist.main.entity.AnimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeRepository extends JpaRepository<AnimeEntity, Long> {
    AnimeResposneDTO findAnimeEntityById(Long id); //TODO fazer joincollum com atributos de Obra

    @Query(value = "SELECT NEW com.animangalist.main.dto.response.AnimeResposneDTO(D.id, AUD.quantidadeEpisodios, AUD.estudio, AUD.direcao, D.lancamento, D.autor, D.descricao, D.nota, D.status, D.titulo, D.tipo, D.genero) FROM AnimeEntity AUD JOIN AUD.obra D WHERE AUD.id=:id")
    List<AnimeResposneDTO> findAnimeEntityByObra(ObraEntity obra); //tODO fazer joincollum do genero

    List<AnimeResposneDTO> findAllAnime();
}
