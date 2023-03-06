package br.com.maddytec.cliente.dto;

public class LoginResponse {

    private String nome;


    public LoginResponse(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
