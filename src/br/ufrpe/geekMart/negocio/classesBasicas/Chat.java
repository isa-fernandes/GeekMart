package br.ufrpe.geekMart.negocio.classesBasicas;

import java.util.ArrayList;
import java.util.Objects;

public class Chat {

    private Cliente usuarioCliente;
    private Cliente usuarioVendedor;
    private ArrayList<String> msgCliente = new ArrayList<>();
    private ArrayList<String> msgVendedor = new ArrayList<>();
    private int quantidadeMsgCliente = 0;
    private int quantidadeMsgVendedor = 0;
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
        return quantidadeMsgCliente;
    }

    public void setQuantidadeMsgCliente(int quantidadeMsgCliente) {
        this.quantidadeMsgCliente = quantidadeMsgCliente;
    }

    public int getQuantidadeMsgVendedor() {
        return quantidadeMsgVendedor;
    }

    public void setQuantidadeMsgVendedor(int quantidadeMsgVendedor) {
        this.quantidadeMsgVendedor = quantidadeMsgVendedor;
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
