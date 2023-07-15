package me.dri.lojadodri.services;


import me.dri.lojadodri.models.Cliente;
import me.dri.lojadodri.models.ClienteLogin;
import me.dri.lojadodri.models.dto.ClienteDTO;
import me.dri.lojadodri.models.dto.ClienteLoginDTO;
import me.dri.lojadodri.repositories.ClienteLoginRepository;
import me.dri.lojadodri.repositories.ClienteRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service

public class CadastrarServices {


    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteLoginRepository clienteLoginRepository;


    public ClienteDTO cadastrar(ClienteDTO clienteDTO, ClienteLoginDTO clienteLoginDTO) {
        ClienteDTO clienteDTO1 = new ClienteDTO(null, clienteDTO.cpf(), clienteDTO.nome(), clienteDTO.sobrenome(),
                clienteDTO.endereco(), clienteDTO.data_nascimento());
        ClienteLoginDTO clienteLoginDTO1 = new ClienteLoginDTO(clienteLoginDTO.username(), clienteLoginDTO.password());

        var clienteData = new DozerBeanMapper().map(clienteDTO1, Cliente.class);
        var clienteLoginData = new DozerBeanMapper().map(clienteLoginDTO1, ClienteLogin.class);

        repository.save(clienteData);
        clienteLoginRepository.save(clienteLoginData);
        return clienteDTO1;



    }

}
