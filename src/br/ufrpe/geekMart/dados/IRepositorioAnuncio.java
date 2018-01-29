package br.ufrpe.geekMart.dados;

import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;

public interface IRepositorioAnuncio {
    void cadastrarAnuncio (Anuncio c);
    //Anuncio[] getAnunciosCategoria (String categoria);
    //Anuncio[] getAnunciosCategoria (int categoria);
    Anuncio procurarAnuncio (String titulo);
    void removerAnuncio (String titulo,String cpf);
    boolean existe (String titulo);
    void alterarAnuncio (String nomeAntigo, Anuncio anuncio);
    Anuncio[] listarAnuncios();
    int getProxima();
    void salvarArquivo();

}
