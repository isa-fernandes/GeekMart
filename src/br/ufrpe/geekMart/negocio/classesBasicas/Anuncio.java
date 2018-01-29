package br.ufrpe.geekMart.negocio.classesBasicas;

import javafx.scene.image.Image;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Anuncio {
    private Cliente cliente;
    private String preco, telefone;
    private String titulo;
    private String descricao;
    private EnumCategorias categoria;
    private EnumEstados estado;
    private LocalDate data, dataFim;
    private boolean ativo;
    private int estrelas[] = {1,2,3,4,5};
    private double estrela = 0;
    private int quantidadeAvaliacoes = 0;
    private ArrayList<String> comentarios = new ArrayList<>();
    private int quantidadeProdutos;
    private ArrayList<Chat> chat;
    private ArrayList<Image> imagens = new ArrayList<>();

    public Anuncio(){

    }

    public Anuncio (Cliente cliente, String preco, String titulo, String descricao, EnumCategorias categoria,
                    EnumEstados estado, int quantidadeProdutos, String telefone, Image prim, Image seg, Image ter) {
        this.cliente = cliente;
        this.preco = preco;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.estado = estado;
        this.data = LocalDate.now();
        this.dataFim = data.plusDays(45);
        this.quantidadeProdutos = quantidadeProdutos;
        this.categoria=categoria;
        this.comentarios = new ArrayList<>();
        this.chat = new ArrayList<>();
        this.telefone=telefone;
        this.imagens.clear();
        this.imagens.add(prim);
        this.imagens.add(seg);
        this.imagens.add(ter);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getQuantidadeProdutos() {
        return quantidadeProdutos;
    }

    public void setQuantidadeProdutos(int quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int[] getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(int[] estrelas) {
        this.estrelas = estrelas;
    }

    public double getEstrela() {
        return estrela;
    }

    public void setEstrela(double estrela) {
        this.estrela = estrela;
    }

    public ArrayList<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<String> comentarios) {
        this.comentarios = comentarios;
    }


    public ArrayList<Chat> getChat() {
        return chat;
    }

    public void setChat(ArrayList<Chat> chat) {
        this.chat = chat;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EnumCategorias getCategoria() {
        return categoria;
    }

    public void setCategoria(EnumCategorias categoria) {
        this.categoria = categoria;
    }

    public EnumEstados getEstado() {
        return estado;
    }

    public void setEstado(EnumEstados estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public LocalDate getData() {
        return data;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    public void setData () {
        if (this.data == null) {
            this.data = LocalDate.now();
        }
    }

    public int getQuantidadeAvaliacoes() {
        return quantidadeAvaliacoes;
    }

    public void setQuantidadeAvaliacoes(int quantidadeAvaliacoes) {
        this.quantidadeAvaliacoes = quantidadeAvaliacoes;
    }

    public int getQuantidadeChats() {
        return this.chat.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Anuncio)) return false;
        Anuncio anuncio = (Anuncio) o;
        return getQuantidadeProdutos() == anuncio.getQuantidadeProdutos() &&
                Objects.equals(getCliente(), anuncio.getCliente()) &&
                Objects.equals(getTitulo(), anuncio.getTitulo()) &&
                Objects.equals(getComentarios(), anuncio.getComentarios());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCliente(), getTitulo());
    }

    @Override
    public String toString() {
        return titulo;
    }
}
