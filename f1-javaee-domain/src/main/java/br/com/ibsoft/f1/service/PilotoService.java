package br.com.ibsoft.f1.service;

import java.io.Serializable;
import java.util.List;

import br.com.ibsoft.f1.entity.Piloto;
import br.com.ibsoft.f1.exception.F1Exception;

public interface PilotoService extends Serializable {

    /**
     * @param Piloto
     */
    Piloto salvarPiloto(Piloto Piloto) throws F1Exception;

    /**
     * @param Piloto
     */
    Piloto atualizarPiloto(Piloto Piloto) throws F1Exception;

    /**
     * @param id
     * @return
     */
    Piloto buscarPiloto(Long id);

    /**
     * @param firstResult
     * @param maxResults
     * @return
     */
    List<Piloto> listarPilotos(Integer firstResult, Integer maxResults);
}
