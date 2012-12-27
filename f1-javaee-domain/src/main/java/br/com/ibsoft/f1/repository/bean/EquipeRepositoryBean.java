/**
 * Copyright (c) 2011-2012, IBSOFT.
 * All rights reserved.
 */
package br.com.ibsoft.f1.repository.bean;

import javax.inject.Inject;

import br.com.ibsoft.f1.entity.Equipe;
import br.com.ibsoft.f1.repository.EquipeRepository;
import br.com.ibsoft.repository.bean.BaseRepositoryBean;
import br.com.ibsoft.saudefamilia.cartao.dao.EquipeDao;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
public class EquipeRepositoryBean extends BaseRepositoryBean<Equipe> implements EquipeRepository {

    private static final long serialVersionUID = 1L;

    /**
     * @param repositoryPrincipal
     */
    @Inject
    public EquipeRepositoryBean(EquipeDao equipeDao) {
        super(equipeDao);
    }

}
