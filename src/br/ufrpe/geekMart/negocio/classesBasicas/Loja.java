package br.ufrpe.geekMart.negocio.classesBasicas;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Loja implements Serializable {
    private Cliente cliente;
    private String nome, descricao, telefone;
    private String categoria;
    private CategoriasEnum categoriasEnum;
    private ArrayList<Anuncio> anuncios = new ArrayList<>();
    private transient Image image;


    public Loja(){

    }

    public Loja(String nome, String telefone, String descricao,/*String categoria,*/ CategoriasEnum categoriasEnum,
                Cliente cliente, Image image){
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.categoriasEnum = categoriasEnum;
        this.cliente = cliente;
        this.anuncios = anuncios;
        this.telefone = telefone;
        this.image = image;
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        image = SwingFXUtils.toFXImage(ImageIO.read(s), null);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", s);
    }

    public CategoriasEnum getCategoriasEnum() {
        return categoriasEnum;
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


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
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
