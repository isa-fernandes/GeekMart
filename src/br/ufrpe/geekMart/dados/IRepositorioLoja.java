package br.ufrpe.geekMart.dados;

import br.ufrpe.geekMart.exceptions.JaExisteException;
import br.ufrpe.geekMart.exceptions.NaoEncontradoException;
import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.classesBasicas.Categorias;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import br.ufrpe.geekMart.negocio.classesBasicas.Loja;

import java.util.ArrayList;

public interface IRepositorioLoja {
    void cadastrarLoja( Loja c);
    Loja procurarLoja(String titulo);
    ArrayList<Loja> procurarLojaPorCliente (Cliente cliente) throws ParametroNullException;
    //Loja procurarLojaPorCategoria (Categorias categoria) throws ParametroNullException, NaoExisteException;
    void removerLoja(String nomeDaLoja,String cpf);
    boolean existeLoja(String titulo);
    void alterarLoja (String cpf, Loja loja);
    Loja[] listarLoja();
    int getProxima();
    void salvarArquivo();
}
