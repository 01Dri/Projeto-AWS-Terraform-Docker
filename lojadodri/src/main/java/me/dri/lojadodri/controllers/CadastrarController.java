package me.dri.lojadodri.controllers;

import me.dri.lojadodri.models.dto.ClienteDTO;
import me.dri.lojadodri.models.dto.ClienteLoginDTO;
import me.dri.lojadodri.services.CadastrarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/auth")
public class CadastrarController {


    @Autowired
    private CadastrarServices services;

    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteDTO> cadastrar(@RequestBody ClienteDTO cliente, @RequestBody ClienteLoginDTO clienteLoginDTO) {
        var result = new ClienteDTO(null, cliente.cpf(), cliente.nome(),cliente.sobrenome(), cliente.endereco(), cliente.data_nascimento());
        var resultLogin = new ClienteLoginDTO(clienteLoginDTO.username(), clienteLoginDTO.password());
        return ResponseEntity.ok().body(services.cadastrar(result, resultLogin));


    }
}
