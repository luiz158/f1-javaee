/**
 * Copyright (c) 2011-2012, IBSOFT.
 * All rights reserved.
 */
package br.com.ibsoft.f1.repository.bean;

import javax.inject.Inject;

import br.com.ibsoft.f1.entity.Piloto;
import br.com.ibsoft.f1.repository.PilotoRepository;
import br.com.ibsoft.repository.bean.RepositoryBean;
import br.com.ibsoft.saudefamilia.cartao.dao.PilotoDao;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
public class PilotoRepositoryBean extends RepositoryBean<Piloto> implements PilotoRepository {

    private static final long serialVersionUID = 1L;

    /**
     * @param daoPrincipal
     */
    @Inject
    public PilotoRepositoryBean(PilotoDao PilotoDao) {
        super(PilotoDao);
    }

}
