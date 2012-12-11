/**
 * Copyright (c) 2011-2012, IBSOFT.
 * All rights reserved.
 */
package br.com.ibsoft.saudefamilia.dao.bean;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.ibsoft.dao.bean.HibernateDaoBean;
import br.com.ibsoft.f1.entity.Piloto;
import br.com.ibsoft.saudefamilia.cartao.dao.PilotoDao;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
public class PilotoHibernateDaoBean extends HibernateDaoBean<Piloto> implements PilotoDao {

    private static final long serialVersionUID = 1L;

    /**
     * @param entityManager
     */
    @Inject
    public PilotoHibernateDaoBean(EntityManager entityManager) {
        super(entityManager);
    }

}
