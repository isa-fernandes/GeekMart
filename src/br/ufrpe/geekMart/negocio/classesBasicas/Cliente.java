package br.ufrpe.geekMart.negocio.classesBasicas;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Usuario implements Serializable {
    private String telefone;
    private Endereco endereco = new Endereco();
    private ArrayList<Anuncio> anuncios = new ArrayList<>();
    private ArrayList<Loja> lojas = new ArrayList<>();


    public Cliente(){

    }

    public Cliente (String nome, String email, String cpf, String telefone, Endereco endereco, String senha,
                    boolean adm, boolean ativo){
        super(nome, email, cpf, senha,adm,ativo);


        this.telefone = telefone;
        this.endereco = endereco;/*new Endereco(endereco.getLogradouro(), endereco.getNumero(), endereco.getBairro(),
                endereco.getCidade(), endereco.getEstado(), endereco.getCep(),
                endereco.getComplemento())*/;
        this.anuncios = anuncios;
        this.lojas = lojas;

    }

    public void setAnuncios(ArrayList<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }

    public ArrayList<Loja> getLojas() {
        return lojas;
    }

    public void setLojas(ArrayList<Loja> lojas) {
        this.lojas = lojas;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Anuncio> getAnuncios() {
        return this.anuncios;
    }

    public int getAnuncioPorTitulo (String nome) {
        int m = -1;
        for (int i = 0; i < this.anuncios.size(); i++) {
            if (this.anuncios.get(i).getTitulo().equals(nome)) {
                m = i;
            }
        }
        return m;
    }

    public int getLojaPorTitulo (String nome) {
        int m = -1;
        for (int i = 0; i < this.lojas.size(); i++) {
            if (this.lojas.get(i).getNome().equals(nome)) {
                m = i;
            }
        }
        return m;
    }

    public ArrayList<Anuncio> listarAnuncios(){
        return anuncios;
    }

    public void setAnuncios (Anuncio anuncios) {
        this.anuncios.add(anuncios);
    }

    @Override
    public boolean isAdm() {
        return adm;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "telefone='" + telefone + '\'' +
                ", endereco=" + endereco +
                ", anuncios=" + anuncios +
                ", lojas=" + lojas +
                ", ativo=" + ativo +
                ", adm=" + adm +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
