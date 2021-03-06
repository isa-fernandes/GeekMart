package br.ufrpe.geekMart.negocio;

import br.ufrpe.geekMart.exceptions.*;
import br.ufrpe.geekMart.negocio.classesBasicas.*;

import java.util.ArrayList;

public class Fachada {
    private ControladorAnuncio cadastroAnuncio;
    private static Fachada instancia;
    private ControladorUsuario cadastroUsuario;
    private ControladorLoja cadastroLoja;



    private Fachada() {
        this.cadastroAnuncio = ControladorAnuncio.getInstancia();
        this.cadastroLoja = ControladorLoja.getInstancia();
        this.cadastroUsuario = ControladorUsuario.getInstancia();

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
            throws NaoExisteException,ParametroNullException {
        return this.cadastroUsuario.buscarUsuario(cpf);
    }

    public boolean existeUsuario(String cpf){
        return this.cadastroUsuario.existeUsuario(cpf);
    }

    public  void alterarUsuario(Usuario usuario, Usuario usuarioNovo)
            throws ParametroNullException, NaoExisteException {
        this.cadastroUsuario.alterarUsuario(usuario,usuarioNovo);
    }

    public void salvarMemoryCardCliente(Cliente cliente){
        this.cadastroUsuario.salvarMemoryCardCliente(cliente);
    }

    public Cliente loadMemoryCardCliente(){
        return this.cadastroUsuario.loadMemoryCardCliente();
    }



    //ADM

    public void admBloquearDesbloquearUsuario (String cpf)
            throws ParametroNullException, NaoExisteException {
        this.cadastroUsuario.admBloquearDesbloquearUsuario(cpf);
    }
    public Usuario[] listarUsuarios(){
        return  this.cadastroUsuario.listarUsuarios();
    }

    public int getProximaUsuario(){
        return this.cadastroUsuario.getProxima();
    }
    public int getProximaLoja(){
        return this.cadastroLoja.getProxima();
    }
    public int getProximaAnuncio(){
        return this.cadastroAnuncio.getProxima();
    }


    //LOGIN

    public boolean autenticarLogin(String senha, String cpf)
            throws ParametroNullException, NaoExisteException, LoginSemSucessoException {
        return this.cadastroUsuario.autenticarLogin(senha,cpf);
    }

    // ANUNCIO

    public ArrayList<Anuncio> buscarAnuncioPorCategoriaOrdenadoPeloPreco(String categoria) {
        return  this.cadastroAnuncio.buscarAnuncioPorCategoriaOrdenadoPeloPreco(categoria);
    }

    public ArrayList<Anuncio> buscarAnuncioPorTituloOrdenadoPeloPreco(String palavra) {
        return  this.cadastroAnuncio.buscarAnuncioPorTituloOrdenadoPeloPreco(palavra);
    }

    public void cadastrarAnuncio (Anuncio anuncio) throws ParametroNullException, JaExisteException {
        this.cadastroAnuncio.cadastrarAnuncio(anuncio);
    }

    public void adicionarAnuncio (Anuncio anuncio)
            throws ParametroNullException, JaExisteException {
        this.cadastroAnuncio.cadastrarAnuncio(anuncio);
    }

    public void expirarAnuncio(Anuncio c) throws ParametroNullException,
            DataExpirarNaoChegouException, NaoExisteException {
        this.cadastroAnuncio.expirarAnuncio(c);
    }

    public void desativarAnuncioSemEstoque(Anuncio c)
            throws ParametroNullException, HaEstoqueException, NaoExisteException {
        this.cadastroAnuncio.desativarAnuncioSemEstoque(c);
    }

    public void incluirComentario(Anuncio c , String s) throws ParametroNullException, NaoExisteException {
        this.cadastroAnuncio.incluirComentario(c,s);
    }

    public void avaliarProduto(Anuncio c , int i) throws ParametroNullException, NaoExisteException {
        this.cadastroAnuncio.avaliarProduto(c,i);
    }

    public void criarChat(Cliente comprador , Cliente vendedor, Anuncio anuncio)
            throws ParametroNullException, NaoExisteException {
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
        return this.cadastroAnuncio.procurarAnuncio(titulo);
    }

    public void removerAnuncio (Anuncio anuncio,String cpf) throws ParametroNullException, NaoExisteException {
        this.cadastroAnuncio.removerAnuncio(anuncio,cpf);
    }

    public void alterarAnuncio (String nomeAntigo, Anuncio anuncio)
            throws ParametroNullException, NaoExisteException {
        this.cadastroAnuncio.alterarAnuncio(nomeAntigo, anuncio);
    }


    public Anuncio[] listarAnuncios(){
        return this.cadastroAnuncio.listarAnuncios();
    }

    public void saveMemoryCardAnuncio(Anuncio anuncio){
        this.cadastroAnuncio.saveMemoryCardAnuncio(anuncio);
    }

    public Anuncio loadMemoryCardAnuncio(){
        return this.cadastroAnuncio.loadMemoryCardAnuncio();
    }


    // LOJA

    public Loja[] listarLojas(){
        return this.cadastroLoja.listarLojas();
    }

    public void cadastrarLoja( Loja c) throws ParametroNullException, JaExisteException{
        this.cadastroLoja.cadastrarLoja(c);
    }

    public void novaLoja (Loja loja) throws ParametroNullException, JaExisteException{
        this.cadastroLoja.cadastrarLoja(loja);
    }

    public Loja buscarLoja (String nome) throws ParametroNullException, NaoExisteException {
        return this.cadastroLoja.procurarLoja(nome);
    }

    public Loja buscarLojaPorCategoria (EnumCategorias categoria)
            throws ParametroNullException, NaoExisteException {
        return this.cadastroLoja.procurarLojaPorCategoria(categoria);
    }

    public ArrayList<Loja> buscarLojaPorCliente (Cliente cliente) throws ParametroNullException {
        return this.cadastroLoja.procurarLojaPorCliente(cliente);
    }

    public void removerLoja (Loja loja,String cpf) throws ParametroNullException, NaoExisteException {
        this.cadastroLoja.removerLoja(loja,cpf);
    }

    public void alterarLoja (String nomeAntigo, Loja loja)
            throws ParametroNullException, NaoExisteException {
        this.cadastroLoja.alterarLoja(nomeAntigo, loja);
    }

    public void alterarAnuncioNaLoja (String nomeAntigo, Anuncio anuncio) throws ParametroNullException {
        this.cadastroLoja.alterarAnuncioNaLoja(nomeAntigo, anuncio);
    }

    public void removerAnuncioDaLoja (String anuncio) throws ParametroNullException {
        this.cadastroLoja.removerAnuncioDaLoja(anuncio);
    }

    public  boolean existeLoja(String titulo) throws ParametroNullException{
        return this.cadastroLoja.existeLoja(titulo);
    }

    public ArrayList<Loja> buscarLojaPorTitulo(String palavra) {
        return this.cadastroLoja.buscarLojaPorTitulo(palavra);
    }
    public ArrayList<Loja> buscarLojaPorCategoria(String categoria) {
        return this.cadastroLoja.buscarLojaPorCategoria(categoria);
    }

    public void salvarArquivo() {
        this.cadastroLoja.salvarArquivo();
        this.cadastroAnuncio.salvarArquivo();
        this.cadastroUsuario.salvarArquivo();
    }

    public void saveMemoryCardLoja(Loja loja){
        this.cadastroLoja.saveMemoryCardLoja(loja);
    }

    public Loja loadMemoryCardLoja(){
        return this.cadastroLoja.loadMemoryCardLoja();
    }

}
