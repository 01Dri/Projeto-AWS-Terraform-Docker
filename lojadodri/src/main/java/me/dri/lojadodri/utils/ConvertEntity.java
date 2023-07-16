package me.dri.lojadodri.utils;

import me.dri.lojadodri.models.Cliente;
import me.dri.lojadodri.models.dto.ClienteDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertEntity {


    public static ClienteDTO convertyEntityForClienteDTO(Cliente cliente) {
        return new ClienteDTO(cliente.getId(), cliente.getCpf(), cliente.getNome(), cliente.getSobrenome(), cliente.getEndereco(),
                cliente.getData_nascimento(), cliente.getClienteLogin().getUsername(), cliente.getClienteLogin().getPassword());
    }

    public static List<ClienteDTO> convertyListEntityForListClienteDTO(List<Cliente> clientes) {
        return  clientes.stream().map(cliente ->
                new ClienteDTO(cliente.getId(), cliente.getCpf(), cliente.getNome(), cliente.getSobrenome(), cliente.getEndereco(),
                        cliente.getData_nascimento(), cliente.getClienteLogin().getUsername(), cliente.getClienteLogin().getPassword())).collect(Collectors.toList());

    }
}
