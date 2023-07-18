package me.dri.lojadodri.unittests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import me.dri.lojadodri.mocks.MockCliente;
import me.dri.lojadodri.models.Cliente;
import me.dri.lojadodri.repositories.ClienteRepository;
import me.dri.lojadodri.services.ClienteServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Test;

import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClienteServicesTests {

    MockCliente input;

    @InjectMocks
    private ClienteServices services;

    @Mock
    ClienteRepository repository;

    @BeforeEach
    void setupMocks() throws Exception {
        input = new MockCliente();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById() {
        Cliente cliente = input.mockEntity(1);
        Cliente persisted = cliente;
        when(repository.findById(cliente.getId())).thenReturn(Optional.of(persisted));

        var result = services.findById(1L);
        assertEquals("Nome Test 1", result.nome());
    }


}
