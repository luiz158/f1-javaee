/**
 * Copyright (c) 2011-2012, IBSOFT.
 * All rights reserved.
 */
package br.com.ibsoft.f1.service.test;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.ibsoft.f1.entity.Piloto;
import br.com.ibsoft.f1.exception.F1Exception;
import br.com.ibsoft.f1.repository.PilotoRepository;
import br.com.ibsoft.f1.service.PilotoService;
import br.com.ibsoft.f1.service.bean.PilotoServiceBean;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
public class PilotoServiceTest implements Serializable {

    private static final long serialVersionUID = 1L;

    private PilotoService service;
    @Mock
    private PilotoRepository PilotoRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new PilotoServiceBean(PilotoRepository);
    }

    @Test
    public void deveChamarPersistDePilotoRepository() throws F1Exception {
        // dado
        Piloto Piloto = new Piloto();
        Piloto.setNome("Force India");

        // quando
        service.salvarPiloto(Piloto);

        // verifique
        verify(PilotoRepository).persist(Piloto);
    }

    @Test
    public void deveChamarUpdateDePilotoRepository() throws F1Exception {
        // dado
        Piloto Piloto = new Piloto();
        Piloto.setId(12L);
        Piloto.setNome("Force India");

        // quando
        service.atualizarPiloto(Piloto);

        // verifique
        verify(PilotoRepository).update(Piloto);
    }

    @Test
    public void naoDeveChamarUpdateDePilotoRepositoryComIdNull() throws F1Exception {
        // dado
        Piloto Piloto = new Piloto();
        Piloto.setId(null);
        Piloto.setNome("Force India");

        // quando
        service.atualizarPiloto(Piloto);

        // verifique
        verify(PilotoRepository, times(0)).update(Piloto);
    }

    @Test
    public void deveBuscarPilotoPorId() {
        // dado
        Long id = 12L;
        Piloto Piloto = new Piloto(id, "mercedes");
        when(PilotoRepository.findById(Piloto.class, id)).thenReturn(Piloto);

        // quando
        Piloto PilotoActual = service.buscarPiloto(id);

        // verifique
        assertEquals(Piloto, PilotoActual);
    }

    @Test
    public void deveListarTodasPilotosComPaginacao() {
        // dado
        Integer firstResult = 0, maxResults = 1;
        Piloto Piloto = new Piloto(12L, "mercedes");
        List<Piloto> Pilotos = Arrays.asList(Piloto);
        when(PilotoRepository.find(null, Piloto.class, firstResult, maxResults)).thenReturn(Pilotos);

        // quando
        List<Piloto> PilotosActual = service.listarPilotos(firstResult, maxResults);

        // verifique
        assertThat(PilotosActual, hasItem(Piloto));
    }

    @Test
    public void deveListarNoMaximo50Pilotos() {
        // dado
        Integer firstResult = 0, maxResults = 51;

        // quando
        service.listarPilotos(firstResult, maxResults);

        // verifique
        verify(PilotoRepository).find(null, Piloto.class, firstResult, new Integer(50));
    }

    @Test
    public void firstResultDaListaDePilotosTemDefaultZero() {
        // dado
        Integer firstResult = -1, maxResults = 1;

        // quando
        service.listarPilotos(firstResult, maxResults);

        // verifique
        verify(PilotoRepository).find(null, Piloto.class, new Integer(0), maxResults);
    }

    @Test
    public void maxResultsDaListaDePilotosTemDefault50() {
        // dado
        Integer firstResult = 0, maxResults = null;

        // quando
        service.listarPilotos(firstResult, maxResults);

        // verifique
        verify(PilotoRepository).find(null, Piloto.class, firstResult, new Integer(50));
    }
}
