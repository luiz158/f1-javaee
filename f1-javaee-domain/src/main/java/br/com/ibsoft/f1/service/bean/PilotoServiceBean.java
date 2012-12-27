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
    private PilotoRepository pilotoRepository;

    public PilotoServiceBean() {
        super();
    }

    public PilotoServiceBean(PilotoRepository pilotoRepository) {
        super();
        this.pilotoRepository = pilotoRepository;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.PilotoService#salvarPiloto(br.com.ibsoft.f1.
     * entity.Piloto)
     */
    @Override
    public Piloto salvarPiloto(Piloto piloto) throws F1Exception {
        validar(piloto);
        return pilotoRepository.persist(piloto);
    }

    private void validar(Piloto piloto) throws F1Exception {
        if (piloto == null) {
            throw new F1Exception("error.piloto.nulo");
        }
        if (piloto.getNome() == null) {
            throw new F1Exception("error.piloto.nome.nulo");
        }
        if (piloto.getDataNascimento() == null) {
            throw new F1Exception("error.piloto.data_nascimento.nulo");
        }
        if (piloto.getLicensa() == null) {
            throw new F1Exception("error.piloto.licensa.nulo");
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.PilotoService#atualizarPiloto(br.com.ibsoft.
     * f1.entity.Piloto)
     */
    @Override
    public Piloto atualizarPiloto(Piloto piloto) throws F1Exception {
        validar(piloto);
        if (piloto.getId() == null) {
            return null;
        }
        return pilotoRepository.update(piloto);
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.service.PilotoService#buscarPiloto(java.lang.Long)
     */
    @Override
    public Piloto buscarPiloto(Long id) {
        return pilotoRepository.findById(Piloto.class, id);
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
        return pilotoRepository.find(null, Piloto.class, firstResult, maxResults);
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.service.PilotoService#deletarPiloto(java.lang.Long)
     */
    @Override
    public void deletarPiloto(Long id) throws F1Exception {
        Piloto piloto = buscarPiloto(id);
        if (piloto != null) {
            pilotoRepository.remove(piloto);
        }
    }

}
