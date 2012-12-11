/**
 * Copyright (c) 2011-2012, IBSOFT.
 * All rights reserved.
 */
package br.com.ibsoft.f1.service.test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.ibsoft.f1.entity.Equipe;
import br.com.ibsoft.f1.exception.F1Exception;
import br.com.ibsoft.f1.repository.EquipeRepository;
import br.com.ibsoft.f1.service.EquipeService;
import br.com.ibsoft.f1.service.bean.EquipeServiceBean;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
public class EquipeServiceTest implements Serializable {

    private static final long serialVersionUID = 1L;

    private EquipeService service;
    @Mock
    private EquipeRepository equipeRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new EquipeServiceBean(equipeRepository);
    }

    @Test
    public void deveChamarPersistDeEquipeRepository() throws F1Exception {
        // dado
        Equipe equipe = new Equipe();
        equipe.setNome("Force India");

        // quando
        service.salvarEquipe(equipe);

        // verifique
        verify(equipeRepository).persist(equipe);
    }

    @Test
    public void deveChamarUpdateDeEquipeRepository() throws F1Exception {
        // dado
        Equipe equipe = new Equipe();
        equipe.setId(12L);
        equipe.setNome("Force India");

        // quando
        service.atualizarEquipe(equipe);

        // verifique
        verify(equipeRepository).update(equipe);
    }

    @Test
    public void naoDeveChamarUpdateDeEquipeRepositoryComIdNull() throws F1Exception {
        // dado
        Equipe equipe = new Equipe();
        equipe.setId(null);
        equipe.setNome("Force India");

        // quando
        service.atualizarEquipe(equipe);

        // verifique
        verify(equipeRepository, times(0)).update(equipe);
    }

    @Test
    public void deveBuscarEquipePorId() {
        // dado
        Long id = 12L;
        Equipe equipe = new Equipe(id, "mercedes");
        when(equipeRepository.findById(Equipe.class, id)).thenReturn(equipe);

        // quando
        Equipe equipeActual = service.buscarEquipe(id);

        // verifique
        assertEquals(equipe, equipeActual);
    }

    @Test
    public void deveListarTodasEquipesComPaginacao() {
        // dado
        Integer firstResult = 0, maxResults = 1;
        Equipe equipe = new Equipe(12L, "mercedes");
        List<Equipe> equipes = Arrays.asList(equipe);
        when(equipeRepository.find(null, Equipe.class, firstResult, maxResults)).thenReturn(equipes);

        // quando
        List<Equipe> equipesActual = service.listarEquipes(firstResult, maxResults);

        // verifique
        assertThat(equipesActual, hasItem(equipe));
    }

    @Test
    public void deveListarNoMaximo50Equipes() {
        // dado
        Integer firstResult = 0, maxResults = 51;

        // quando
        service.listarEquipes(firstResult, maxResults);

        // verifique
        verify(equipeRepository).find(null, Equipe.class, firstResult, new Integer(50));
    }

    @Test
    public void firstResultDaListaDeEquipesTemDefaultZero() {
        // dado
        Integer firstResult = -1, maxResults = 1;

        // quando
        service.listarEquipes(firstResult, maxResults);

        // verifique
        verify(equipeRepository).find(null, Equipe.class, new Integer(0), maxResults);
    }

    @Test
    public void maxResultsDaListaDeEquipesTemDefault50() {
        // dado
        Integer firstResult = 0, maxResults = null;

        // quando
        service.listarEquipes(firstResult, maxResults);

        // verifique
        verify(equipeRepository).find(null, Equipe.class, firstResult, new Integer(50));
    }
}
