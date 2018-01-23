package br.ufrpe.geekMart.exceptions;

public class NaoEncontradoException extends Exception {
    private String texto;

    public NaoEncontradoException(String texto) {
        super("O(a) " + texto + " não foi encontrado(a).");
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
