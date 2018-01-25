package br.ufrpe.geekMart.exceptions;

public class LoginSemSucessoException extends Exception {
    private String cpf, senha;

    public LoginSemSucessoException(String cpf, String senha) {
        super("Senha ou CPF incorretos");
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }
}
