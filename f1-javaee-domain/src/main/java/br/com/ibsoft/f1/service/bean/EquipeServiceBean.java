/**
 * Copyright (c) 2011-2012, IBSOFT.
 * All rights reserved.
 */
package br.com.ibsoft.f1.service.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.ibsoft.f1.entity.Equipe;
import br.com.ibsoft.f1.exception.F1Exception;
import br.com.ibsoft.f1.repository.EquipeRepository;
import br.com.ibsoft.f1.service.EquipeService;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
@Stateless
public class EquipeServiceBean implements EquipeService {

    private static final long serialVersionUID = 1L;

    @Inject
    private EquipeRepository equipeRepository;

    public EquipeServiceBean() {
        super();
    }

    public EquipeServiceBean(EquipeRepository equipeRepository) {
        super();
        this.equipeRepository = equipeRepository;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.EquipeService#salvarEquipe(br.com.ibsoft.f1.
     * entity.Equipe)
     */
    @Override
    public Equipe salvarEquipe(Equipe equipe) throws F1Exception {
        return equipeRepository.persist(equipe);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.EquipeService#atualizarEquipe(br.com.ibsoft.
     * f1.entity.Equipe)
     */
    @Override
    public Equipe atualizarEquipe(Equipe equipe) throws F1Exception {
        if (equipe == null || equipe.getId() == null) {
            return null;
        }
        return equipeRepository.update(equipe);
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.service.EquipeService#buscarEquipe(java.lang.Long)
     */
    @Override
    public Equipe buscarEquipe(Long id) {
        return equipeRepository.findById(Equipe.class, id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.EquipeService#listarEquipe(java.lang.Integer,
     * java.lang.Integer)
     */
    @Override
    public List<Equipe> listarEquipes(Integer firstResult, Integer maxResults) {
        if (maxResults == null || maxResults < 0 || maxResults > 50) {
            maxResults = 50;
        }
        if (firstResult == null || firstResult < 0) {
            firstResult = 0;
        }
        return equipeRepository.find(null, Equipe.class, firstResult, maxResults);
    }

}
