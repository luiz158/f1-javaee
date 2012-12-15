/**
 * Copyright (c) 2011-2012, IBSOFT.
 * All rights reserved.
 */
package br.com.ibsoft.f1.rs.bean;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response.Status;

import br.com.ibsoft.f1.entity.Equipe;
import br.com.ibsoft.f1.exception.F1Exception;
import br.com.ibsoft.f1.rs.EquipeResource;
import br.com.ibsoft.f1.rs.exception.F1ExceptionRest;
import br.com.ibsoft.f1.service.EquipeService;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
public class EquipeResourceBean implements EquipeResource {

    private static final long serialVersionUID = 5481252114941052436L;

    @Inject
    private EquipeService equipeService;

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.rs.EquipeResource#listarEquipes(java.lang.Integer,
     * java.lang.Integer)
     */
    @Override
    public List<Equipe> listarEquipes(Integer first, Integer max) throws F1ExceptionRest {
        List<Equipe> equipes = equipeService.listarEquipes(first, max);
        if (equipes == null || equipes.size() == 0) {
            throw new F1ExceptionRest(Status.NO_CONTENT.getStatusCode());
        }
        return equipes;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.rs.EquipeResource#buscarEquipePorId(java.lang.Long)
     */
    @Override
    public Equipe buscarEquipePorId(Long id) throws F1ExceptionRest {
        Equipe equipe = equipeService.buscarEquipe(id);
        if (equipe == null) {
            throw new F1ExceptionRest(Status.NO_CONTENT.getStatusCode());
        }
        return equipe;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.rs.EquipeResource#salvarEquipe(br.com.ibsoft.f1.entity
     * .Equipe)
     */
    @Override
    public Equipe salvarEquipe(Equipe equipe) throws F1ExceptionRest {
        try {
            equipe = equipeService.salvarEquipe(equipe);
        } catch (F1Exception e) {
            throw new F1ExceptionRest(e.getMessage());
        }
        return equipe;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.rs.EquipeResource#atualizarEquipe(br.com.ibsoft.f1.entity
     * .Equipe)
     */
    @Override
    public Equipe atualizarEquipe(Equipe equipe) throws F1ExceptionRest {
        try {
            equipe = equipeService.atualizarEquipe(equipe);
        } catch (F1Exception e) {
            throw new F1ExceptionRest(e.getMessage());
        }
        return equipe;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.rs.EquipeResource#deletarEquipe(java.lang.Long)
     */
    @Override
    public void deletarEquipe(Long id) throws F1ExceptionRest {
        try {
            equipeService.deletarEquipe(id);
        } catch (F1Exception e) {
            throw new F1ExceptionRest(e.getMessage());
        }
    }
}
