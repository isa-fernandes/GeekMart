package br.ufrpe.geekMart.negocio;

import br.ufrpe.geekMart.dados.IRepositorioAnuncio;
import br.ufrpe.geekMart.dados.IRepositorioLoja;
import br.ufrpe.geekMart.dados.IRepositorioUsuario;
import br.ufrpe.geekMart.exceptions.*;
import br.ufrpe.geekMart.negocio.classesBasicas.*;

import java.util.ArrayList;

public class Fachada {
    private ControladorAnuncio cadastroAnuncio;
    private static Fachada instancia;
    private ControladorUsuario cadastroUsuario;
    private ControladorLoja cadastroLoja;
    private IRepositorioUsuario repositorioUsuario;
    private IRepositorioAnuncio repositorioAnuncio;
    private IRepositorioLoja repositorioLoja;


    private Fachada() {
        this.cadastroAnuncio = ControladorAnuncio.getInstancia();
        this.cadastroLoja = ControladorLoja.getInstancia();
        this.cadastroUsuario = ControladorUsuario.getInstancia();
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioAnuncio = repositorioAnuncio;
        this.repositorioLoja = repositorioLoja;


    }

    public static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }


    // USUARIO

    public void cadastrarUsuario  (Usuario user)
            throws NaoExisteException,ParametroNullException, JaExisteException {
        this.cadastroUsuario.cadastrarUsuario(user);
    }

    public Usuario buscaUsuario (String cpf)
            throws NaoExisteException,ParametroNullException, JaExisteException {
        return this.repositorioUsuario.buscarUsuario(cpf);
    }

    public void removerUsuario (String cpf) throws ParametroNullException, NaoExisteException {
        this.cadastroUsuario.removerUsuario(cpf);
    }

    //ADM

    public void admBloquearDesbloquearUsuario (String cpf)
            throws ParametroNullException, NaoExisteException {
        this.cadastroUsuario.admBloquearDesbloquearUsuario(cpf);
    }


    //LOGIN

    public boolean autenticarLogin(String senha, String cpf)
            throws ParametroNullException, NaoExisteException {
        return this.cadastroUsuario.autenticarLogin(senha,cpf);
    }

    // ANUNCIO

    public void adicionarAnuncio (Anuncio anuncio)
            throws ParametroNullException, JaExisteException {
        this.cadastroAnuncio.cadastrarAnuncio(anuncio);
    }

    public void expirarAnuncio(Anuncio c) throws ParametroNullException,
            DataExpirarNaoChegouException, NaoExisteException {
        this.cadastroAnuncio.expirarAnuncio(c);
    }

    public void desativarAnuncioSemEstoque(Anuncio c)
            throws ParametroNullException, HaEstoqueException {
        this.cadastroAnuncio.desativarAnuncioSemEstoque(c);
    }

    public void incluirComentario(Anuncio c , String s) throws ParametroNullException {
        this.cadastroAnuncio.incluirComentario(c,s);
    }

    public void avaliarProduto(Anuncio c , int i) throws ParametroNullException {
        this.cadastroAnuncio.avaliarProduto(c,i);
    }

    public void criarChat(Cliente comprador , Cliente vendedor, Anuncio anuncio)
            throws ParametroNullException {
        this.cadastroAnuncio.criarChat(comprador,vendedor,anuncio);
    }

    public void enviarChatParaVendedor(Cliente comprador , Cliente vendedor, Anuncio anuncio, String msg)
            throws ParametroNullException, NaoEncontradoException {
        this.cadastroAnuncio.enviarChatParaVendedor(comprador,vendedor,anuncio,msg);
    }

    public void enviarChatParaCliente(Cliente comprador , Cliente vendedor, Anuncio anuncio, String msg)
            throws ParametroNullException, NaoEncontradoException {
        this.cadastroAnuncio.enviarChatParaCliente(comprador,vendedor,anuncio,msg);
    }

    public Anuncio procurarAnuncio (String titulo)
            throws ParametroNullException, NaoExisteException {
        return this.repositorioAnuncio.procurarAnuncio(titulo);
    }

    public void removerAnuncio (String titulo) throws ParametroNullException, NaoExisteException {
        this.repositorioAnuncio.removerAnuncio(titulo);
    }

    public void alterarAnuncio (String nomeAntigo, Anuncio anuncio)
            throws ParametroNullException, NaoExisteException {
        this.repositorioAnuncio.alterarAnuncio(nomeAntigo, anuncio);
    }



    // LOJA

    public void novaLoja (Loja loja) throws ParametroNullException, JaExisteException{
        this.repositorioLoja.cadastrarLoja(loja);
    }

    public Loja buscarLoja (String nome) throws ParametroNullException, NaoExisteException {
        return this.repositorioLoja.procurarLoja(nome);
    }

    public Loja buscarLojaPorCategoria (Categorias categoria)
            throws ParametroNullException, NaoExisteException {
        return this.repositorioLoja.procurarLojaPorCategoria(categoria);
    }

    public ArrayList<Loja> buscarLojaPorCliente (Cliente cliente) throws ParametroNullException {
        return this.repositorioLoja.procurarLojaPorCliente(cliente);
    }

    public void removerLoja (Loja loja) throws ParametroNullException, NaoExisteException {
        this.repositorioLoja.removerLoja(loja);
    }

    public void alterarLoja (String nomeAntigo, Loja loja)
            throws ParametroNullException, NaoExisteException {
        this.repositorioLoja.alterarLoja(nomeAntigo, loja);
    }

}
