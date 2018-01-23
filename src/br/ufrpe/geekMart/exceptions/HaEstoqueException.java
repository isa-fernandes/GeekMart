package br.ufrpe.geekMart.exceptions;

import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;

public class HaEstoqueException extends Exception {
    private Anuncio anuncio;

    public HaEstoqueException(Anuncio anuncio) {
        super("Ainda há produtos em estoque do anúncio " + anuncio + ".");
        this.anuncio = anuncio;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }
}
