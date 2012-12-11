/**
 * Copyright (c) 2011-2012, IBSOFT.
 * All rights reserved.
 */
package br.com.ibsoft.f1.service.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.ibsoft.f1.entity.EquipeTemporada;
import br.com.ibsoft.f1.entity.PilotoTemporada;
import br.com.ibsoft.f1.entity.Temporada;
import br.com.ibsoft.f1.exception.F1Exception;
import br.com.ibsoft.f1.repository.TemporadaRepository;
import br.com.ibsoft.f1.service.F1Service;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
@Stateless
public class F1ServiceBean implements F1Service {

    private static final long serialVersionUID = 1L;

    @Inject
    private TemporadaRepository temporadaRepository;

    public F1ServiceBean() {
        super();
    }

    public F1ServiceBean(TemporadaRepository temporadaRepository) {
        super();
        this.temporadaRepository = temporadaRepository;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.EquipeTemporadaService#salvarEquipeTemporada
     * (br.com.ibsoft.f1. entity.EquipeTemporada)
     */
    @Override
    public EquipeTemporada salvarEquipeTemporada(EquipeTemporada equipe) throws F1Exception {
        return temporadaRepository.persistEquipe(equipe);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.EquipeTemporadaService#atualizarEquipeTemporada
     * (br.com.ibsoft. f1.entity.EquipeTemporada)
     */
    @Override
    public EquipeTemporada atualizarEquipeTemporada(EquipeTemporada equipe) throws F1Exception {
        if (equipe == null || equipe.getId() == null) {
            return null;
        }
        return temporadaRepository.updateEquipe(equipe);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.EquipeTemporadaService#buscarEquipeTemporada
     * (java.lang.Long)
     */
    @Override
    public EquipeTemporada buscarEquipeTemporada(Long id) {
        return temporadaRepository.findEquipeById(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.F1Service#listarEquipeTemporada(java.lang.Integer
     * , java.lang.Integer)
     */
    @Override
    public List<EquipeTemporada> listarEquipeTemporada(Integer firstResult, Integer maxResults) {
        validarAjustarParamsPaginacao(firstResult, maxResults);
        return temporadaRepository.findEquipeTemporada(null, firstResult, maxResults);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.F1Service#salvarPilotoTemporada(br.com.ibsoft
     * .f1.entity.PilotoTemporada)
     */
    @Override
    public PilotoTemporada salvarPilotoTemporada(PilotoTemporada piloto) throws F1Exception {
        return temporadaRepository.persistPiloto(piloto);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.F1Service#atualizarPilotoTemporada(br.com.ibsoft
     * .f1.entity.PilotoTemporada)
     */
    @Override
    public PilotoTemporada atualizarPilotoTemporada(PilotoTemporada piloto) throws F1Exception {
        if (piloto == null || piloto.getId() == null) {
            return null;
        }
        return temporadaRepository.updatePiloto(piloto);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.F1Service#buscarPilotoTemporada(java.lang.Long)
     */
    @Override
    public PilotoTemporada buscarPilotoTemporada(Long id) {
        return temporadaRepository.findPilotoById(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.F1Service#listarPilotoTemporada(java.lang.Integer
     * , java.lang.Integer)
     */
    @Override
    public List<PilotoTemporada> listarPilotoTemporada(Integer firstResult, Integer maxResults) {
        validarAjustarParamsPaginacao(firstResult, maxResults);
        return temporadaRepository.findPilotoTemporada(null, firstResult, maxResults);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.F1Service#salvarTemporada(br.com.ibsoft.f1.entity
     * .Temporada)
     */
    @Override
    public Temporada salvarTemporada(Temporada temporada) throws F1Exception {
        return temporadaRepository.persistTemporada(temporada);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.F1Service#atualizarTemporada(br.com.ibsoft.f1
     * .entity.Temporada)
     */
    @Override
    public Temporada atualizarTemporada(Temporada temporada) throws F1Exception {
        if (temporada == null || temporada.getId() == null) {
            return null;
        }
        return temporadaRepository.updateTemporada(temporada);
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.service.F1Service#buscarTemporada(java.lang.Long)
     */
    @Override
    public Temporada buscarTemporada(Long id) {
        return temporadaRepository.findTemporadaById(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.F1Service#listarTemporada(java.lang.Integer,
     * java.lang.Integer)
     */
    @Override
    public List<Temporada> listarTemporada(Integer firstResult, Integer maxResults) {
        validarAjustarParamsPaginacao(firstResult, maxResults);
        return temporadaRepository.findTemporada(null, firstResult, maxResults);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.F1Service#buscarTemporadaPorAno(java.lang.Integer
     * )
     */
    @Override
    public Temporada buscarTemporadaPorAno(Integer ano) {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("ano", ano);
        List<Temporada> ts = temporadaRepository.findTemporada(params, 0, 2);
        // TODO Implementar tratamento para quando resultado da consulta tiver
        // mais de 1 valor, pois eh incorreto
        return ts != null && ts.size() > 0 ? ts.get(0) : null;
    }

    private void validarAjustarParamsPaginacao(Integer firstResult, Integer maxResults) {
        if (maxResults == null || maxResults < 0 || maxResults > 50) {
            maxResults = 50;
        }
        if (firstResult == null || firstResult < 0) {
            firstResult = 0;
        }
    }

}
