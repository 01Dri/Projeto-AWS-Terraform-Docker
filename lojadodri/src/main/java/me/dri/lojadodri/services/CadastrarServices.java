package me.dri.lojadodri.services;


import me.dri.lojadodri.models.Cliente;
import me.dri.lojadodri.models.ClienteLogin;
import me.dri.lojadodri.models.dto.CadastroContaUsuarioDTO;
import me.dri.lojadodri.models.dto.ClienteDTO;
import me.dri.lojadodri.repositories.ClienteLoginRepository;
import me.dri.lojadodri.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CadastrarServices {


    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteLoginRepository clienteLoginRepository;


    public CadastroContaUsuarioDTO cadastrarConta(ClienteDTO clienteDTO) {
        return salvarEntidadesConvertidasDb(clienteDTO);

    }


    public CadastroContaUsuarioDTO salvarEntidadesConvertidasDb(ClienteDTO clienteDTO) {

        var result = new CadastroContaUsuarioDTO(
                clienteDTO.cpf(), clienteDTO.nome(), clienteDTO.sobrenome(), clienteDTO.endereco(), clienteDTO.data_nascimento(),
                clienteDTO.username(), clienteDTO.password());

        var dataResultCliente = new Cliente(null, result.cpf(), result.nome(), result.sobrenome(), result.endereco(), result.data_nascimento());
        var dataResultClienteLogin = new ClienteLogin(null, result.username(), result.password());

        repository.save(dataResultCliente);
        clienteLoginRepository.save(dataResultClienteLogin);

        dataResultClienteLogin.setCliente(dataResultCliente);
        dataResultCliente.setClienteLogin(dataResultClienteLogin);


        repository.save(dataResultCliente);
        clienteLoginRepository.save(dataResultClienteLogin);

        return result;
    }




}
