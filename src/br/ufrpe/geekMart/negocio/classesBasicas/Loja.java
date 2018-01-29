package br.ufrpe.geekMart.negocio.classesBasicas;

import java.util.ArrayList;
import java.util.Objects;

public class Loja {
    private Cliente cliente;
    private String nome, descricao, telefone;
    private EnumCategorias categoria;
    private ArrayList<Anuncio> anuncios = new ArrayList<>();



    public Loja(){

    }

    public Loja(String nome, String telefone, String descricao, EnumCategorias categoria, Cliente cliente){
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.cliente = cliente;
        this.anuncios = anuncios;
        this.telefone = telefone;

    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setAnuncios(ArrayList<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }


    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return this.cliente;
    }


    public EnumCategorias getCategoria() {
        return categoria;
    }

    public void setCategoria(EnumCategorias categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Anuncio> getAnuncios() {
        return anuncios;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loja)) return false;
        Loja loja = (Loja) o;
        return Objects.equals(getCliente(), loja.getCliente()) &&
                Objects.equals(getNome(), loja.getNome());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCliente(), getNome());
    }
}
