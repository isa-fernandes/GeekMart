package br.ufrpe.geekMart.negocio;

import br.ufrpe.geekMart.dados.IRepositorioAnuncio;
import br.ufrpe.geekMart.dados.RepositorioAnuncio;
import br.ufrpe.geekMart.exceptions.*;
import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;
import br.ufrpe.geekMart.negocio.classesBasicas.Categorias;
import br.ufrpe.geekMart.negocio.classesBasicas.Chat;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;

public class ControladorAnuncio {
    private static ControladorAnuncio instancia;
    private IRepositorioAnuncio repositorio;

    private ControladorAnuncio() {
        this.repositorio = RepositorioAnuncio.getInstancia();
    }
    public static ControladorAnuncio getInstancia() {
        if (instancia == null) {
            instancia = new ControladorAnuncio();
        }
        return instancia;
    }

    public void cadastrarAnuncio (Anuncio anuncio) throws ParametroNullException, JaExisteException {
        if (anuncio != null) {
            boolean existe = this.repositorio.existe(anuncio.getTitulo());
            if (!existe) {
                this.repositorio.cadastrarAnuncio(anuncio);
            } else {
                throw new JaExisteException("anúncio", "título " + anuncio.getTitulo());
            }
        } else {
            throw new ParametroNullException("anúncio");
        }
    }


    public Anuncio procurarAnuncio (String titulo) throws ParametroNullException, NaoExisteException{
        return this.repositorio.procurarAnuncio(titulo);
    }

    public void removerAnuncio (String titulo) throws ParametroNullException, NaoExisteException{
        this.repositorio.removerAnuncio(titulo);
    }

    public boolean existe (String titulo){
        return this.repositorio.existe(titulo);
    }

    public void alterarAnuncio (String nomeAntigo, Anuncio anuncio) throws ParametroNullException, NaoExisteException{
         this.repositorio.alterarAnuncio(nomeAntigo, anuncio);
    }

    /*public Anuncio[] getAnunciosCategoria (String categoria) {
        return repositorio.getAnunciosCategoria(categoria);
    }

    public Anuncio[] getAnunciosCategoria (int categoria){
        return repositorio.getAnunciosCategoria(categoria);
    }*/

    public void expirarAnuncio(Anuncio c) throws ParametroNullException,
            DataExpirarNaoChegouException,  NaoExisteException {
        LocalDate hoje = LocalDate.now();
        if( c != null) {
            LocalDate data = c.getDataFim();
            if (hoje == data || hoje.isAfter(data)) {
                this.repositorio.removerAnuncio(c.getTitulo());
            } else {
                throw new DataExpirarNaoChegouException(data, c);
            }
        } else {
            throw new ParametroNullException("anúncio");
        }
    }

    public void desativarAnuncioSemEstoque(Anuncio c) throws ParametroNullException, HaEstoqueException {
        if( c!= null){
            if(c.getQuantidadeProdutos() == 0){
                c.setAtivo(false);
            } else {
                throw new HaEstoqueException(c);
            }
        } else {
            throw new ParametroNullException("anúncio");
        }
    }

    public void incluirComentario(Anuncio c , String s) throws ParametroNullException {
        if(c != null && s != null){
            c.getComentarios().add(s);
        } else {
            throw new ParametroNullException("anúncio/comentário");
        }
    }

    public void avaliarProduto(Anuncio c , int i) throws ParametroNullException {
        if(c != null){
            c.setQuantidadeAvaliacoes(c.getQuantidadeProdutos() +1);
            c.setEstrela((c.getEstrela() + i)/c.getQuantidadeAvaliacoes() );
        } else {
            throw new ParametroNullException("anúncio");
        }
    }

    public void criarChat(Cliente comprador , Cliente vendedor, Anuncio anuncio) throws ParametroNullException {
        if(comprador != null && vendedor != null && anuncio != null) {
            Chat chat = new Chat(comprador, vendedor, anuncio);
            anuncio.getChat().add(anuncio.getQuantidadeChats(), chat);
        } else {
            throw new ParametroNullException("comprador/vendedor/anúncio");
        }
    }

    public Chat procurarChat(Cliente comprador , Cliente vendedor, Anuncio anuncio) throws ParametroNullException,
            NaoEncontradoException {
        Chat retorno = null;
        if(comprador != null && vendedor != null && anuncio != null) {
            for (int i = 0; i < anuncio.getChat().size(); i++) {
                if((anuncio.getChat().get(i).getAnuncio().getTitulo() == anuncio.getTitulo()) &&
                        (anuncio.getChat().get(i).getUsuarioCliente().getCpf() == comprador.getCpf()) &&
                        (anuncio.getChat().get(i).getUsuarioVendedor().getCpf() == vendedor.getCpf())  ){
                    retorno = anuncio.getChat().get(i);
                } else {
                    throw new NaoEncontradoException("chat entre " + comprador.getNome() + " e " +
                            vendedor.getNome() + " no anúncio " + anuncio.getTitulo());
                }
            }
        } else {
            throw new ParametroNullException("comprador/vendedor/anúncio");
        }
        return  retorno;
    }

    public void enviarChatParaVendedor(Cliente comprador , Cliente vendedor, Anuncio anuncio, String msg)
            throws ParametroNullException, NaoEncontradoException {
        Chat uol = instancia.procurarChat(comprador,vendedor,anuncio);
        uol.getMsgCliente().add(uol.getQuantidadeMsgCliente(),msg);
        uol.setQuantidadeMsgCliente(uol.getQuantidadeMsgCliente() + 1);

    }

    public void enviarChatParaCliente(Cliente comprador , Cliente vendedor, Anuncio anuncio, String msg)
            throws ParametroNullException, NaoEncontradoException {
        Chat uol = instancia.procurarChat(comprador,vendedor,anuncio);
        uol.getMsgVendedor().add(uol.getQuantidadeMsgVendedor(),msg);
        uol.setQuantidadeMsgVendedor(uol.getQuantidadeMsgVendedor() + 1);
    }

    public ArrayList<String> listarCategorias(){
        return Categorias.getCategorias();
    }


}
