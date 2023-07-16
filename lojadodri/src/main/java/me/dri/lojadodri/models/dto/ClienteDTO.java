package me.dri.lojadodri.models.dto;

import java.util.Date;

public record ClienteDTO (Long id, String cpf ,
                          String nome, String sobrenome,
                          String endereco, Date data_nascimento,
                          String username, String password) {

}

