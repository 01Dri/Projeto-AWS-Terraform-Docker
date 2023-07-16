package me.dri.lojadodri.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String nome;
    private String  sobrenome;
    private String endereco;
    private Date data_nascimento;

    @OneToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "cliente_login_id")
    private ClienteLogin clienteLogin;

    public Cliente() {

    }

    public Cliente(Long id, String cpf, String nome, String sobrenome, String endereco, Date data_nascimento) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.data_nascimento = data_nascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public ClienteLogin getClienteLogin() {
        return clienteLogin;
    }

    public void setClienteLogin(ClienteLogin clienteLogin) {
        this.clienteLogin = clienteLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
