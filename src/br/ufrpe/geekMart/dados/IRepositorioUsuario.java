package br.ufrpe.geekMart.dados;

import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import br.ufrpe.geekMart.negocio.classesBasicas.Usuario;

public interface IRepositorioUsuario {
    void cadastrarUsuario(Usuario c);
    Usuario buscarUsuario(String cpf) throws ParametroNullException, NaoExisteException;
    boolean existeUsuario(String cpf);
    void alterarUsuario(Usuario usuario,Usuario usuarioNovo);
    Usuario[] listarUsuarios();
    int getProxima();
    void salvarArquivo();
    Cliente getMemoryCard();
    void setMemoryCard(Cliente memoryCard);
}
