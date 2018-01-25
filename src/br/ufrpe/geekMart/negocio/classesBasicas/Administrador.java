package br.ufrpe.geekMart.negocio.classesBasicas;

public class Administrador extends Usuario {
    private boolean adm = true;

    public Administrador(){

    }
    public Administrador(String nome, String cpf, String email, String senha, boolean adm, boolean ativo) {
        super(nome, cpf, email, senha,adm, ativo);

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
