package br.ufrpe.geekMart.dados;

import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;

public interface IRepositorioAnuncio {
    void cadastrarAnuncio (Anuncio c);
    Anuncio[] getAnunciosCategoria (String categoria);
    Anuncio[] getAnunciosCategoria (int categoria);
    Anuncio procurarAnuncio (String titulo) throws ParametroNullException, NaoExisteException;
    void removerAnuncio (String titulo) throws ParametroNullException, NaoExisteException;
    boolean existe (String titulo);
    void alterarAnuncio (String nomeAntigo, Anuncio anuncio) throws ParametroNullException, NaoExisteException;

}
