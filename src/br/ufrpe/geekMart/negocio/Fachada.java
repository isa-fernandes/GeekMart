package br.ufrpe.geekMart.negocio;

import br.ufrpe.geekMart.dados.IRepositorioAnuncio;
import br.ufrpe.geekMart.dados.IRepositorioLoja;
import br.ufrpe.geekMart.dados.IRepositorioUsuario;
import br.ufrpe.geekMart.exceptions.JaExisteException;
import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.classesBasicas.*;

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

    public void cadastrarUsuario  (Usuario user) throws NaoExisteException,ParametroNullException, JaExisteException {
        this.cadastroUsuario.cadastrarUsuario(user);
    }

    public Usuario buscaUsuario (String cpf) throws NaoExisteException,ParametroNullException, JaExisteException {
        return this.repositorioUsuario.buscarUsuario(cpf);
    }

    public void removerUsuario (String cpf){
        this.cadastroUsuario.removerUsuario(cpf);
    }

    //ADM

    public void admBloquearDesbloquearUsuario (String cpf) throws ParametroNullException, NaoExisteException {
        this.cadastroUsuario.admBloquearDesbloquearUsuario(cpf);
    }


    //LOGIN

    public boolean autenticarLogin(String senha, String cpf) throws ParametroNullException, NaoExisteException {
        return this.cadastroUsuario.autenticarLogin(senha,cpf);
    }

    // ANUNCIO

    public void adicionarAnuncio (Anuncio anuncio) {
        this.cadastroAnuncio.cadastrarAnuncio(anuncio);
    }

    public void expirarAnuncio(Anuncio c){
        this.cadastroAnuncio.expirarAnuncio(c);
    }

    public void desativarAnuncioSemEstoque(Anuncio c){
        this.cadastroAnuncio.desativarAnuncioSemEstoque(c);
    }

    public void incluirComentario(Anuncio c , String s){
        this.cadastroAnuncio.incluirComentario(c,s);
    }

    public void avaliarProduto(Anuncio c , int i){
        this.cadastroAnuncio.avaliarProduto(c,i);
    }

    public void criarChat(Cliente comprador , Cliente vendedor, Anuncio anuncio){
        this.cadastroAnuncio.criarChat(comprador,vendedor,anuncio);
    }

    public void enviarChatParaVendedor(Cliente comprador , Cliente vendedor, Anuncio anuncio, String msg){
        this.cadastroAnuncio.enviarChatParaVendedor(comprador,vendedor,anuncio,msg);
    }

    public void enviarChatParaCliente(Cliente comprador , Cliente vendedor, Anuncio anuncio, String msg){
        this.cadastroAnuncio.enviarChatParaCliente(comprador,vendedor,anuncio,msg);
    }
    public Anuncio procurarAnuncio (String titulo){
        return this.repositorioAnuncio.procurarAnuncio(titulo);
    }
    public void removerAnuncio (String titulo){
        this.repositorioAnuncio.removerAnuncio(titulo);
    }
    public void alterarAnuncio (Anuncio anuncio){
        this.repositorioAnuncio.alterarAnuncio(anuncio);
    }



    // LOJA

    public void novaLoja (String cpf, Loja loja) {
        this.cadastroLoja.cadastrarLoja(cpf, loja);
    }

    public Loja buscarLoja (String nome) {
        return this.repositorioLoja.procurarLoja(nome);
    }

    public Loja buscarLojaPorCategoria (Categorias categoria) {
        return this.repositorioLoja.procurarLojaPorCategoria(categoria);
    }

    public Loja buscarLojaPorCliente (Cliente cliente) {
        return this.repositorioLoja.procurarLojaPorCliente(cliente);
    }

    public void removerLoja (String cpf) {
        this.repositorioLoja.removerLoja(cpf);
    }

    public void alterarLoja (String cpf, Loja loja) {
        this.repositorioLoja.alterarLoja(cpf, loja);
    }

}
