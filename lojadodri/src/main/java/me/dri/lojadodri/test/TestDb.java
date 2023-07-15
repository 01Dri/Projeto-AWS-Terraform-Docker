package me.dri.lojadodri.test;

import me.dri.lojadodri.models.Cliente;
import me.dri.lojadodri.models.ClienteLogin;
import me.dri.lojadodri.repositories.ClienteLoginRepository;
import me.dri.lojadodri.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class TestDb  implements CommandLineRunner {

    @Autowired
    ClienteRepository repository;

    @Autowired
    ClienteLoginRepository loginRepository;


    @Override
    public void run(String... args) throws Exception {
        Cliente cliente = new Cliente(null, "123141234235", "Diego", "Henrique", "enderecoo", new Date());
        repository.save(cliente);
        ClienteLogin clienteLogin = new ClienteLogin();
        clienteLogin.setCliente(cliente);
        clienteLogin.setUsername("diegoteste");
        clienteLogin.setPassword("teste123");
        loginRepository.save(clienteLogin);
        cliente.setClienteLogin(clienteLogin);
        repository.save(cliente);
    }
}
