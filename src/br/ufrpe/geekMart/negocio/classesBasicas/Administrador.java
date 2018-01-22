package br.ufrpe.geekMart.negocio.classesBasicas;

public class Administrador extends Usuario {
    private boolean adm = false;

    public Administrador(){

    }
    public Administrador(String nome, String cpf, String email, String senha, boolean adm) {
        super(nome, cpf, email, senha,adm);

        this.setAdm(this.adm);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nCpf: " + cpf + "\nEmail: " + email;
    }

    @Override
    public boolean isAdm() {
        return adm;
    }


}
