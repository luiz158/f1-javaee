package br.com.ibsoft.saudefamilia.dao.produces;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DaoProduces {

    @SuppressWarnings("unused")
    @PersistenceContext(unitName = "f1-javaee")
    @Produces
    private EntityManager entityManager;

}
