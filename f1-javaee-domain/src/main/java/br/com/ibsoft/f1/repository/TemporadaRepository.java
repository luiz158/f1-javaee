package br.com.ibsoft.f1.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import br.com.ibsoft.f1.entity.EquipeTemporada;
import br.com.ibsoft.f1.entity.PilotoTemporada;
import br.com.ibsoft.f1.entity.Temporada;

public interface TemporadaRepository extends Serializable {

    PilotoTemporada persistPiloto(PilotoTemporada piloto);

    PilotoTemporada updatePiloto(PilotoTemporada piloto);

    PilotoTemporada findPilotoById(Long id);

    List<PilotoTemporada> findPilotoTemporada(Map<String, Object> queryParameters, Integer firstResult,
            Integer maxResults);

    EquipeTemporada persistEquipe(EquipeTemporada equipe);

    EquipeTemporada updateEquipe(EquipeTemporada equipe);

    EquipeTemporada findEquipeById(Long id);

    List<EquipeTemporada> findEquipeTemporada(Map<String, Object> queryParameters, Integer firstResult,
            Integer maxResults);

    Temporada persistTemporada(Temporada temporada);

    Temporada updateTemporada(Temporada temporada);

    Temporada findTemporadaById(Long id);

    List<Temporada> findTemporada(Map<String, Object> queryParameters, Integer firstResult, Integer maxResults);

}
