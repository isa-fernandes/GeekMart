package br.ufrpe.geekMart.negocio;

import br.ufrpe.geekMart.dados.IRepositorioAnuncio;
import br.ufrpe.geekMart.dados.RepositorioAnuncio;
import br.ufrpe.geekMart.exceptions.*;
import br.ufrpe.geekMart.negocio.classesBasicas.*;

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
                this.repositorio.salvarArquivo();
            } else {
                throw new JaExisteException("anúncio", "título " + anuncio.getTitulo());
            }
        } else {
            throw new ParametroNullException("anúncio");
        }
    }


    public Anuncio procurarAnuncio (String titulo) throws ParametroNullException, NaoExisteException{
        if (titulo != null) {
            if (this.repositorio.existe(titulo)) {
                return this.repositorio.procurarAnuncio(titulo);
            } else {
                throw new NaoExisteException("anúncio", "título " + titulo);
            }
        } else {
            throw new ParametroNullException("título");
        }
    }

    public void removerAnuncio (Anuncio anuncio,String cpf) throws ParametroNullException, NaoExisteException{
        if (anuncio != null && cpf != null) {
            if (this.repositorio.existe(anuncio.getTitulo())) {
                this.repositorio.removerAnuncio(anuncio.getTitulo(), cpf);
                Fachada.getInstancia().removerAnuncioDaLoja(anuncio.getTitulo());
                Cliente cliente = (Cliente) Fachada.getInstancia().buscaUsuario(cpf);
                cliente.getAnuncios().remove(anuncio);
                Fachada.getInstancia().alterarUsuario(cliente, cliente);
                Fachada.getInstancia().salvarArquivo();
            } else {
                throw new NaoExisteException("anúncio ", "título " + anuncio.getTitulo());
            }
        } else {
            throw new ParametroNullException("título/CPF");
        }
    }

    public boolean existe (String titulo){
        return this.repositorio.existe(titulo);
    }

    public void alterarAnuncio (String nomeAntigo, Anuncio anuncio) throws ParametroNullException, NaoExisteException{
        if (nomeAntigo != null && anuncio != null) {
            if (this.repositorio.existe(nomeAntigo)) {
                this.repositorio.alterarAnuncio(nomeAntigo, anuncio);
                Fachada.getInstancia().alterarAnuncioNaLoja(nomeAntigo, anuncio);
                Cliente cliente = (Cliente) Fachada.getInstancia().buscaUsuario(anuncio.getCpfCliente());
                int i = cliente.getAnuncioPorTitulo(nomeAntigo);
                cliente.getAnuncios().set(i, anuncio);
                Fachada.getInstancia().alterarUsuario(cliente, cliente);
                Fachada.getInstancia().salvarArquivo();
            } else {
                throw new NaoExisteException("anúncio", "título " + nomeAntigo);
            }
        } else {
            throw new ParametroNullException("anúncio");
        }
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
                this.removerAnuncio(c,c.getCpfCliente());
                Fachada.getInstancia().salvarArquivo();
            } else {
                throw new DataExpirarNaoChegouException(data, c);
            }
        } else {
            throw new ParametroNullException("anúncio");
        }
    }

    public void desativarAnuncioSemEstoque(Anuncio c) throws ParametroNullException,
            HaEstoqueException, NaoExisteException {
        if( c!= null){
            if(c.getQuantidadeProdutos() == 0){
                c.setAtivo(false);
                this.alterarAnuncio(c.getTitulo(), c);
                Fachada.getInstancia().salvarArquivo();
            } else {
                throw new HaEstoqueException(c);
            }
        } else {
            throw new ParametroNullException("anúncio");
        }
    }

    public void incluirComentario(Anuncio c , String s) throws ParametroNullException, NaoExisteException {
        if(c != null && s != null){
            c.getComentarios().add(s);
            this.alterarAnuncio(c.getTitulo(), c);
            Fachada.getInstancia().salvarArquivo();
        } else {
            throw new ParametroNullException("anúncio/comentário");
        }
    }

    public void avaliarProduto(Anuncio c , int i) throws ParametroNullException, NaoExisteException {
        if(c != null){
            c.setQuantidadeAvaliacoes(c.getQuantidadeProdutos() +1);
            c.setEstrela((c.getEstrela() + i)/c.getQuantidadeAvaliacoes());
            this.alterarAnuncio(c.getTitulo(), c);
            Fachada.getInstancia().salvarArquivo();
        } else {
            throw new ParametroNullException("anúncio");
        }
    }

    public void criarChat(Cliente comprador , Cliente vendedor, Anuncio anuncio)
            throws ParametroNullException, NaoExisteException {
        if(comprador != null && vendedor != null && anuncio != null) {
            Chat chat = new Chat(comprador, vendedor, anuncio);
            anuncio.getChat().add(anuncio.getQuantidadeChats(), chat);
            this.alterarAnuncio(anuncio.getTitulo(), anuncio);
            Fachada.getInstancia().salvarArquivo();
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
    }

    public void enviarChatParaCliente(Cliente comprador , Cliente vendedor, Anuncio anuncio, String msg)
            throws ParametroNullException, NaoEncontradoException {
        Chat uol = instancia.procurarChat(comprador,vendedor,anuncio);
        uol.getMsgVendedor().add(uol.getQuantidadeMsgVendedor(),msg);
    }



    public Anuncio[] listarAnuncios(){
        return this.repositorio.listarAnuncios();
    }

    public int getProxima(){
        return this.repositorio.getProxima();
    }

    public ArrayList<Anuncio> buscarAnuncioPorTituloOrdenadoPeloPreco(String palavra) {
        return  this.repositorio.buscarAnuncioPorTituloOrdenadoPeloPreco(palavra);
    }

    public ArrayList<Anuncio> buscarAnuncioPorCategoriaOrdenadoPeloPreco(String categoria) {
        return  this.repositorio.buscarAnuncioPorCategoriaOrdenadoPeloPreco(categoria);
    }

    public void salvarArquivo () {
        this.repositorio.salvarArquivo();
    }
}
