package br.ufrpe.geekMart.dados;

import br.ufrpe.geekMart.negocio.classesBasicas.Loja;

public interface IRepositorioLoja {
    void cadastrar( Loja c);
    Loja procurar(String num);
    void remover(String num);
    boolean existe(String titulo);
    void duplicaArrayLojas();
    void alterarLoja (String cpf, Loja loja);
    boolean existeCpf (String titulo);
}
