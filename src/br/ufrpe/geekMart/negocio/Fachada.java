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
            throws NaoExisteException,ParametroNullException, JaExisteException {
        return this.cadastroUsuario.buscarUsuario(cpf);
    }

    public void removerUsuario (String cpf) throws ParametroNullException, NaoExisteException {
        this.cadastroUsuario.removerUsuario(cpf);
    }

    public boolean existeUsuario(String cpf){
        return this.cadastroUsuario.existeUsuario(cpf);
    }

    public  void alterarUsuario(Usuario usuario, Usuario usuarioNovo)
            throws ParametroNullException, NaoExisteException {
        this.cadastroUsuario.alterarUsuario(usuario,usuarioNovo);
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

    public void cadastrarAnuncio (Anuncio anuncio) throws ParametroNullException, JaExisteException {
        this.cadastroAnuncio.cadastrarAnuncio(anuncio);
    }

    /*public Anuncio[] getAnunciosCategoria (String categoria) {
        return this.cadastroAnuncio.getAnunciosCategoria(categoria);
    }

    public Anuncio[] getAnunciosCategoria (int categoria){
        return cadastroAnuncio.getAnunciosCategoria(categoria);
    }*/

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

    public void removerAnuncio (String titulo,String cpf) throws ParametroNullException, NaoExisteException {
        this.cadastroAnuncio.removerAnuncio(titulo,cpf);
    }

    public void alterarAnuncio (String nomeAntigo, Anuncio anuncio)
            throws ParametroNullException, NaoExisteException {
        this.cadastroAnuncio.alterarAnuncio(nomeAntigo, anuncio);
    }

    public ArrayList<String> listarCategorias(){
        return cadastroAnuncio.listarCategorias();
    }

    public Anuncio[] listarAnuncios(){
        return this.cadastroAnuncio.listarAnuncios();
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

    public Loja buscarLojaPorCategoria (Categorias categoria)
            throws ParametroNullException, NaoExisteException {
        return this.cadastroLoja.procurarLojaPorCategoria(categoria);
    }

    public ArrayList<Loja> buscarLojaPorCliente (Cliente cliente) throws ParametroNullException {
        return this.cadastroLoja.procurarLojaPorCliente(cliente);
    }

    public void removerLoja (String nomeDaLoja,String cpf) throws ParametroNullException, NaoExisteException {
        this.cadastroLoja.removerLoja(nomeDaLoja,cpf);
    }

    public void alterarLoja (String nomeAntigo, Loja loja)
            throws ParametroNullException, NaoExisteException {
        this.cadastroLoja.alterarLoja(nomeAntigo, loja);
    }
    public  boolean existeLoja(String titulo) throws ParametroNullException{
        return this.cadastroLoja.existeLoja(titulo);
    }

}
