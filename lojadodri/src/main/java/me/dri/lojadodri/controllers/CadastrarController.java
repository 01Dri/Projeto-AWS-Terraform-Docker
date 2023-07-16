package me.dri.lojadodri.controllers;

import me.dri.lojadodri.models.Cliente;
import me.dri.lojadodri.models.dto.CadastroContaUsuarioDTO;
import me.dri.lojadodri.models.dto.ClienteDTO;
import me.dri.lojadodri.repositories.ClienteRepository;
import me.dri.lojadodri.services.CadastrarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class CadastrarController {


    @Autowired
    private CadastrarServices services;

    @Autowired
    private ClienteRepository repository;

    @PostMapping(value = "/cadastrar/conta/v1")
    public ResponseEntity<CadastroContaUsuarioDTO> cadastrarUsuario(@RequestBody ClienteDTO clienteDTO) {
        var result = services.cadastrarConta(clienteDTO);
        return ResponseEntity.ok().body(result);
    }

}
