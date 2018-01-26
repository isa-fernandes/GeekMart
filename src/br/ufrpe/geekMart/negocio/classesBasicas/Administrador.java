package br.ufrpe.geekMart.negocio.classesBasicas;

public class Administrador extends Usuario {
    String telefone;

    public Administrador(){

    }
    public Administrador(String nome, String cpf, String email, String senha, boolean adm, boolean ativo,String telefone) {
        super(nome, cpf, email, senha,adm, ativo);

        this.nome=nome;
        this.cpf=cpf;
        this.email=email;
        this.senha=senha;
        this.adm=adm;
        this.ativo=ativo;
        this.telefone=telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nCpf: " + cpf + "\nEmail: " + email;
    }

    @Override
    public boolean isAdm() {
        return adm;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
