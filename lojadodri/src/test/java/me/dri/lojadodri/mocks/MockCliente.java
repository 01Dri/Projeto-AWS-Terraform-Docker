package me.dri.lojadodri.mocks;

import me.dri.lojadodri.models.Cliente;
import me.dri.lojadodri.models.ClienteLogin;
import me.dri.lojadodri.models.dto.ClienteDTO;

import java.util.Date;

public class MockCliente {


    public Cliente mockEntity(Integer id) {
        Cliente cliente = new Cliente();
        cliente.setId(id.longValue());
        cliente.setNome("Nome Test " + id);
        cliente.setEndereco("Endereco Test " + id);
        cliente.setSobrenome("Sobrenome Test " + id);
        cliente.setCpf("Cpf Test " + id);
        cliente.setData_nascimento(new Date());
        cliente.setClienteLogin(mockClienteLogin(cliente));
        return cliente;
    }

    public ClienteDTO mockEntityDTO(Integer id, Cliente cliente) {
        return new ClienteDTO(
                id.longValue(), cliente.getNome(), cliente.getSobrenome(),
                cliente.getCpf(), cliente.getEndereco(), cliente.getData_nascimento(),
                cliente.getClienteLogin().getUsername(), cliente.getClienteLogin().getPassword());

    }

    public ClienteLogin mockClienteLogin(Cliente cliente) {
        ClienteLogin clienteLogin = new ClienteLogin();
        clienteLogin.setCliente(cliente);
        clienteLogin.setUsername("dri");
        clienteLogin.setPassword("teste123");
        return clienteLogin;
    }
}
