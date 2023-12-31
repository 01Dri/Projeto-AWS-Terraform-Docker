package me.dri.lojadodri.controllers;

import me.dri.lojadodri.models.Cliente;
import me.dri.lojadodri.models.dto.ClienteDTO;
import me.dri.lojadodri.services.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteServices services;

    @GetMapping (value = "/clientesAll")
    public ResponseEntity<List<ClienteDTO>> findAll() {
        var result = services.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping (value = "find/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(services.findById(id));
    }

}
