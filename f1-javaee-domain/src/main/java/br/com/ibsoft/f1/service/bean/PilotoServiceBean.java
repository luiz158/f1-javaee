/**
 * Copyright (c) 2011-2012, IBSOFT.
 * All rights reserved.
 */
package br.com.ibsoft.f1.service.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.ibsoft.f1.entity.Piloto;
import br.com.ibsoft.f1.exception.F1Exception;
import br.com.ibsoft.f1.repository.PilotoRepository;
import br.com.ibsoft.f1.service.PilotoService;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
@Stateless
public class PilotoServiceBean implements PilotoService {

    private static final long serialVersionUID = 1L;

    @Inject
    private PilotoRepository PilotoRepository;

    public PilotoServiceBean() {
        super();
    }

    public PilotoServiceBean(PilotoRepository PilotoRepository) {
        super();
        this.PilotoRepository = PilotoRepository;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.PilotoService#salvarPiloto(br.com.ibsoft.f1.
     * entity.Piloto)
     */
    @Override
    public Piloto salvarPiloto(Piloto Piloto) throws F1Exception {
        return PilotoRepository.persist(Piloto);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.PilotoService#atualizarPiloto(br.com.ibsoft.
     * f1.entity.Piloto)
     */
    @Override
    public Piloto atualizarPiloto(Piloto Piloto) throws F1Exception {
        if (Piloto == null || Piloto.getId() == null) {
            return null;
        }
        return PilotoRepository.update(Piloto);
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.service.PilotoService#buscarPiloto(java.lang.Long)
     */
    @Override
    public Piloto buscarPiloto(Long id) {
        return PilotoRepository.findById(Piloto.class, id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.PilotoService#listarPiloto(java.lang.Integer,
     * java.lang.Integer)
     */
    @Override
    public List<Piloto> listarPilotos(Integer firstResult, Integer maxResults) {
        if (maxResults == null || maxResults < 0 || maxResults > 50) {
            maxResults = 50;
        }
        if (firstResult == null || firstResult < 0) {
            firstResult = 0;
        }
        return PilotoRepository.find(null, Piloto.class, firstResult, maxResults);
    }

}
