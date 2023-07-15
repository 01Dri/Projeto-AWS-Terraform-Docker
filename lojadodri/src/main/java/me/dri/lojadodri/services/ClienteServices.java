package me.dri.lojadodri.services;


import me.dri.lojadodri.models.Cliente;
import me.dri.lojadodri.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServices {

    @Autowired
    private ClienteRepository repository;



    public List<Cliente> findAll() {
        return repository.findAll();
    }
    public Cliente findById(Long id) {
        return repository.findById(id).orElseThrow(null);
    }


}
