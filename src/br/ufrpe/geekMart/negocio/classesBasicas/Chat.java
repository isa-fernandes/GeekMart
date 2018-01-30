package br.ufrpe.geekMart.negocio.classesBasicas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Chat implements Serializable {

    private Cliente usuarioCliente;
    private Cliente usuarioVendedor;
    private ArrayList<String> msgCliente;
    private ArrayList<String> msgVendedor;
    private Anuncio anuncio;

    public Chat(){

    }

    public Chat(Cliente usuarioCliente, Cliente usuarioVendedor, Anuncio anuncio ){
        this.usuarioCliente = usuarioCliente;
        this.usuarioVendedor = usuarioVendedor;
        this.anuncio = anuncio;
        this.msgCliente = new ArrayList<>();
        this.msgVendedor = new ArrayList<>();
    }

    public int getQuantidadeMsgCliente() {
        return this.msgCliente.size();
    }

    public int getQuantidadeMsgVendedor() {
        return this.msgVendedor.size();
    }

    public Cliente getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(Cliente usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public Cliente getUsuarioVendedor() {
        return usuarioVendedor;
    }

    public void setUsuarioVendedor(Cliente usuarioVendedor) {
        this.usuarioVendedor = usuarioVendedor;
    }

    public ArrayList<String> getMsgCliente() {
        return msgCliente;
    }

    public void setMsgCliente(ArrayList<String> msgCliente) {
        this.msgCliente = msgCliente;
    }

    public ArrayList<String> getMsgVendedor() {
        return msgVendedor;
    }

    public void setMsgVendedor(ArrayList<String> msgVendedor) {
        this.msgVendedor = msgVendedor;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chat)) return false;
        Chat chat = (Chat) o;
        return Objects.equals(getUsuarioCliente(), chat.getUsuarioCliente()) &&
                Objects.equals(getUsuarioVendedor(), chat.getUsuarioVendedor()) &&
                Objects.equals(getAnuncio(), chat.getAnuncio());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUsuarioCliente(), getUsuarioVendedor(), getAnuncio());
    }



}
