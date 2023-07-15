package me.dri.lojadodri.services;


import me.dri.lojadodri.models.Cliente;
import me.dri.lojadodri.models.ClienteLogin;
import me.dri.lojadodri.repositories.ClienteLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteLoginService {

    @Autowired
    private ClienteLoginRepository repository;

    public Cliente login(String username, String password) {
        var result = repository.findByUsername(username);
        if (result.get().getPassword().equals(password)) {
            return result.get().getCliente();
        }
        return null;
    }


}
