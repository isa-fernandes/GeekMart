package br.ufrpe.geekMart.dados;

import br.ufrpe.geekMart.negocio.classesBasicas.Categorias;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import br.ufrpe.geekMart.negocio.classesBasicas.Loja;

public interface IRepositorioLoja {
    void cadastrarLoja( Loja c);
    Loja procurarLoja(String titulo);
    Loja procurarLojaPorCliente (Cliente cliente);
    Loja procurarLojaPorCategoria (Categorias categoria);
    void removerLoja(String num);
    boolean existeLoja(String titulo);
    void alterarLoja (String cpf, Loja loja);
    boolean existeCpf (String titulo);
}
