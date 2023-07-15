package me.dri.lojadodri.controllers;

import me.dri.lojadodri.models.Cliente;
import me.dri.lojadodri.models.ClienteLogin;
import me.dri.lojadodri.services.ClienteLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login")
public class LoginController {


    @Autowired
    private ClienteLoginService service;
    @GetMapping
    public ResponseEntity<Cliente> login(@RequestBody ClienteLogin username) {
        return ResponseEntity.ok().body(service.login(username.getUsername(), username.getPassword()));
    }
}
