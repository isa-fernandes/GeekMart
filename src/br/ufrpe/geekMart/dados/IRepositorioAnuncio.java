package br.ufrpe.geekMart.dados;

import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;

public interface IRepositorioAnuncio {
    void cadastrarAnuncio (Anuncio c);
    Anuncio[] getAnunciosCategoria (String categoria);
    Anuncio[] getAnunciosCategoria (int categoria);
    Anuncio procurarAnuncio (String titulo);
    void removerAnuncio (String titulo);
    boolean existe (String titulo);
    void alterarAnuncio (Anuncio anuncio);

}
