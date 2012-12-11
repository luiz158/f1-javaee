/**
 * Copyright (c) 2011-2012, IBSOFT.
 * All rights reserved.
 */
package br.com.ibsoft.saudefamilia.dao.bean;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.ibsoft.dao.bean.HibernateDaoBean;
import br.com.ibsoft.f1.entity.Equipe;
import br.com.ibsoft.saudefamilia.cartao.dao.EquipeDao;

public class EquipeHibernateDaoBean extends HibernateDaoBean<Equipe> implements EquipeDao {

    private static final long serialVersionUID = 1L;

    @Inject
    public EquipeHibernateDaoBean(EntityManager entityManager) {
        super(entityManager);
    }

}
