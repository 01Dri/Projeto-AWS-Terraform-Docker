package me.dri.lojadodri.services;


import me.dri.lojadodri.exception.ex.ResourceNotFoundEx;
import me.dri.lojadodri.models.Cliente;
import me.dri.lojadodri.models.dto.ClienteDTO;
import me.dri.lojadodri.repositories.ClienteRepository;
import me.dri.lojadodri.utils.ConvertEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServices {

    @Autowired
    private ClienteRepository repository;



    public List<ClienteDTO> findAll() {
        List<Cliente> clientesFromDB = repository.findAll();
        if (clientesFromDB.isEmpty()) {
            throw new ResourceNotFoundEx("List content not found");
        }
       return ConvertEntity.convertyListEntityForListClienteDTO(clientesFromDB);
    }

    public ClienteDTO findById(Long id) {
        var result = repository.findById(id).orElseThrow(() -> new ResourceNotFoundEx("Id not found!"));
        return ConvertEntity.convertyEntityForClienteDTO(result);
    }


}
