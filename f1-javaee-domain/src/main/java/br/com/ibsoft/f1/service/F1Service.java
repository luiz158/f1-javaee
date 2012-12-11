package br.com.ibsoft.f1.service;

import java.io.Serializable;
import java.util.List;

import br.com.ibsoft.f1.entity.EquipeTemporada;
import br.com.ibsoft.f1.entity.PilotoTemporada;
import br.com.ibsoft.f1.entity.Temporada;
import br.com.ibsoft.f1.exception.F1Exception;

/**
 * 
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
public interface F1Service extends Serializable {

    /**
     * @param EquipeTemporada
     */
    EquipeTemporada salvarEquipeTemporada(EquipeTemporada EquipeTemporada) throws F1Exception;

    /**
     * @param EquipeTemporada
     */
    EquipeTemporada atualizarEquipeTemporada(EquipeTemporada EquipeTemporada) throws F1Exception;

    /**
     * @param id
     * @return
     */
    EquipeTemporada buscarEquipeTemporada(Long id);

    /**
     * @param firstResult
     * @param maxResults
     * @return
     */
    List<EquipeTemporada> listarEquipeTemporada(Integer firstResult, Integer maxResults);

    /**
     * 
     * @param piloto
     * @return
     * @throws F1Exception
     */
    PilotoTemporada salvarPilotoTemporada(PilotoTemporada piloto) throws F1Exception;

    /**
     * 
     * @param piloto
     * @return
     * @throws F1Exception
     */
    PilotoTemporada atualizarPilotoTemporada(PilotoTemporada piloto) throws F1Exception;

    /**
     * 
     * @param id
     * @return
     */
    PilotoTemporada buscarPilotoTemporada(Long id);

    /**
     * 
     * @param firstResult
     * @param maxResults
     * @return
     */
    List<PilotoTemporada> listarPilotoTemporada(Integer firstResult, Integer maxResults);

    /**
     * 
     * @param temporada
     * @return
     * @throws F1Exception
     */
    Temporada salvarTemporada(Temporada temporada) throws F1Exception;

    /**
     * 
     * @param temporada
     * @return
     * @throws F1Exception
     */
    Temporada atualizarTemporada(Temporada temporada) throws F1Exception;

    /**
     * 
     * @param id
     * @return
     */
    Temporada buscarTemporada(Long id);

    /**
     * 
     * @param firstResult
     * @param maxResults
     * @return
     */
    List<Temporada> listarTemporada(Integer firstResult, Integer maxResults);

    /**
     * 
     * @param ano
     * @return
     */
    Temporada buscarTemporadaPorAno(Integer ano);

}
