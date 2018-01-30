package br.ufrpe.geekMart.negocio.classesBasicas;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Loja implements Serializable {
    private String cpfCliente;
    private String nome, descricao, telefone;
    private EnumCategorias categoria;
    private ArrayList<Anuncio> anuncios = new ArrayList<>();
    private transient Image image;


    public Loja(){

    }

    public Loja(String nome, String telefone, String descricao, EnumCategorias categoria, String cpfCliente) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.cpfCliente = cpfCliente;
        this.telefone = telefone;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        if (image != null) {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", s);
        }
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
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


    public void setCpfCliente(String cliente){
        this.cpfCliente = cliente;
    }

    public String getCpfCliente() {
        return this.cpfCliente;
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

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
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
        return Objects.equals(getCpfCliente(), loja.getCpfCliente()) &&
                Objects.equals(getNome(), loja.getNome());
    }


    @Override
    public int hashCode() {

        return Objects.hash(getCpfCliente(), getNome());
    }
}
