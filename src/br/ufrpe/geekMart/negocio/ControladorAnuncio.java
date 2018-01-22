package br.ufrpe.geekMart.negocio;

import br.ufrpe.geekMart.dados.IRepositorioAnuncio;
import br.ufrpe.geekMart.dados.RepositorioAnuncio;
import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;
import br.ufrpe.geekMart.negocio.classesBasicas.Chat;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;

import java.time.LocalDate;

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

    public void cadastrarAnuncio (Anuncio anuncio) {
        if (anuncio != null) {
            boolean existe = this.repositorio.existe(anuncio.getTitulo());
            if (!existe) {
                this.repositorio.cadastrarAnuncio(anuncio);
            }
        }
    }

    public void expirarAnuncio(Anuncio c){
        LocalDate hoje = LocalDate.now();
        LocalDate data = c.getDataFim();
        if( c != null) {
            if (hoje == data || hoje.isAfter(data)) {
                this.repositorio.removerAnuncio(c.getTitulo());
            }
        }
    }

    public void desativarAnuncioSemEstoque(Anuncio c){
        if( c!= null){
            if(c.getQuantidadeProdutos() == 0){
                c.setAtivo(false);
            }
        }
    }

    public void incluirComentario(Anuncio c , String s){
        if(c != null && s != null){
            c.getComentarios().add(c.getIndexComentario(),s);
            c.setIndexComentario(c.getIndexComentario()+1);
        }

    }

    public void avaliarProduto(Anuncio c , int i){
        if(c != null){
            c.setQuantidadeAvaliacoes(c.getQuantidadeProdutos() +1);
            c.setEstrela((c.getEstrela() + i)/c.getQuantidadeAvaliacoes() );
        }
    }

    public void criarChat(Cliente comprador , Cliente vendedor, Anuncio anuncio){
        if(comprador != null && vendedor != null && anuncio != null) {
            Chat chat = new Chat(comprador, vendedor, anuncio);
            anuncio.getChat().add(anuncio.getQuantidadeChats(), chat);
            anuncio.setQuantidadeChats(anuncio.getQuantidadeChats() + 1);
        }
    }

    public Chat procurarChat(Cliente comprador , Cliente vendedor, Anuncio anuncio){
        Chat retorno = null;
        if(comprador != null && vendedor != null && anuncio != null) {
            for (int i = 0; i < anuncio.getChat().size(); i++) {
                if((anuncio.getChat().get(i).getAnuncio().getTitulo() == anuncio.getTitulo()) &&
                        (anuncio.getChat().get(i).getUsuarioCliente().getCpf() == comprador.getCpf()) &&
                        (anuncio.getChat().get(i).getUsuarioVendedor().getCpf() == vendedor.getCpf())  ){
                    retorno = anuncio.getChat().get(i);
                }
            }

        }
        return  retorno;
    }

    public void enviarChatParaVendedor(Cliente comprador , Cliente vendedor, Anuncio anuncio, String msg){
        Chat uol = instancia.procurarChat(comprador,vendedor,anuncio);
        uol.getMsgCliente().add(uol.getQuantidadeMsgCliente(),msg);
        uol.setQuantidadeMsgCliente(uol.getQuantidadeMsgCliente() + 1);

    }

    public void enviarChatParaCliente(Cliente comprador , Cliente vendedor, Anuncio anuncio, String msg){
        Chat uol = instancia.procurarChat(comprador,vendedor,anuncio);
        uol.getMsgVendedor().add(uol.getQuantidadeMsgVendedor(),msg);
        uol.setQuantidadeMsgVendedor(uol.getQuantidadeMsgVendedor() + 1);

    }



}
