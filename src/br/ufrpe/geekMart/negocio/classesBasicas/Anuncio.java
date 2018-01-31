package br.ufrpe.geekMart.negocio.classesBasicas;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Anuncio implements Serializable {
    private String cpfCliente;
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
    private transient ArrayList<Image> imagens = new ArrayList<>();
    private transient Image imagem1, imagem2, imagem3;

    public Anuncio(){

    }

    public Anuncio (String cliente, String preco, String titulo, String descricao, EnumCategorias categoria,
                    EnumEstados estado, int quantidadeProdutos, String telefone, Image imagem1, Image imagem2, Image imagem3) {
        this.cpfCliente = cliente;
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
        this.imagem1=imagem1;
        this.imagem2=imagem2;
        this.imagem3=imagem3;
        /*this.imagens.add(prim);
        this.imagens.add(seg);
        this.imagens.add(ter);*/
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.imagem1 = SwingFXUtils.toFXImage(ImageIO.read(s), null);
        this.imagem2 = SwingFXUtils.toFXImage(ImageIO.read(s), null);
        this.imagem3 = SwingFXUtils.toFXImage(ImageIO.read(s), null);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        ImageIO.write(SwingFXUtils.fromFXImage(imagem1, null), "png", s);
        ImageIO.write(SwingFXUtils.fromFXImage(imagem2, null), "png", s);
        ImageIO.write(SwingFXUtils.fromFXImage(imagem3, null), "png", s);
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

    public String getCpfCliente() {
        return cpfCliente;
    }
    public LocalDate getData() {
        return data;
    }
    public void setCpfCliente(String cpfCliente){
        this.cpfCliente = cpfCliente;
    }
    public void setData () {
        if (this.data == null) {
            this.data = LocalDate.now();
        }
    }

    public ArrayList<Image> getImagens() {
        return imagens;
    }

    public void setImagens(ArrayList<Image> imagens) {
        this.imagens = imagens;
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
                Objects.equals(getCpfCliente(), anuncio.getCpfCliente()) &&
                Objects.equals(getTitulo(), anuncio.getTitulo()) &&
                Objects.equals(getComentarios(), anuncio.getComentarios());
    }

    public Image getImagem1() {
        return imagem1;
    }

    public void setImagem1(Image imagem1) {
        this.imagem1 = imagem1;
    }

    public Image getImagem2() {
        return imagem2;
    }

    public void setImagem2(Image imagem2) {
        this.imagem2 = imagem2;
    }

    public Image getImagem3() {
        return imagem3;
    }

    public void setImagem3(Image imagem3) {
        this.imagem3 = imagem3;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCpfCliente(), getTitulo());
    }

    @Override
    public String toString() {
        return titulo;
    }
}
