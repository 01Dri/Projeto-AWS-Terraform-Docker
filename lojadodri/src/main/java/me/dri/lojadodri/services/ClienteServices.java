package me.dri.lojadodri.services;


import me.dri.lojadodri.models.Cliente;
import me.dri.lojadodri.models.dto.ClienteDTO;
import me.dri.lojadodri.repositories.ClienteRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServices {

    @Autowired
    private ClienteRepository repository;



    public List<ClienteDTO> findAll() {
        List<Cliente> clientesFromDB = repository.findAll();
        return clientesFromDB.stream().map(cliente ->
                new ClienteDTO(cliente.getId(), cliente.getCpf(),
                        cliente.getNome(), cliente.getSobrenome(),
                        cliente.getEndereco(), cliente.getData_nascimento(),
                        cliente.getClienteLogin().getUsername(),
                        cliente.getClienteLogin().getPassword())).toList();
    }

}
