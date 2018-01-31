package br.ufrpe.geekMart.dados;

import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import br.ufrpe.geekMart.negocio.classesBasicas.EnumCategorias;
import br.ufrpe.geekMart.negocio.classesBasicas.Loja;

import java.util.ArrayList;

public interface IRepositorioLoja {
    void cadastrarLoja( Loja c);
    Loja procurarLoja(String titulo);
    ArrayList<Loja> procurarLojaPorCliente (Cliente cliente) throws ParametroNullException;
    void removerLoja(String nomeDaLoja,String cpf);
    boolean existeLoja(String titulo);
    void alterarLoja (String cpf, Loja loja);
    Loja procurarLojaPorCategoria (EnumCategorias categoria) throws ParametroNullException, NaoExisteException;
    Loja[] listarLoja();
    int getProxima();
    void salvarArquivo();
    ArrayList<Loja> buscarLojaPorTitulo(String palavra);
    ArrayList<Loja> buscarLojaPorCategoria(String categoria);
    void alterarAnuncioNaLoja (String nomeAntigo, Anuncio anuncio);
    void removerAnuncioDaLoja (String anuncio);
    Loja getMemoryCard();
    void setMemoryCard(Loja memoryCard);
}
