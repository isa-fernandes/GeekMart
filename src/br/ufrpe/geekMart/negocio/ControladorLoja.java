package br.ufrpe.geekMart.negocio;

import br.ufrpe.geekMart.dados.IRepositorioLoja;
import br.ufrpe.geekMart.dados.RepositorioLoja;
import br.ufrpe.geekMart.exceptions.JaExisteException;
import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.classesBasicas.*;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import br.ufrpe.geekMart.negocio.classesBasicas.EnumEstados;
import br.ufrpe.geekMart.negocio.classesBasicas.Loja;

import java.util.ArrayList;

public class ControladorLoja {
    private static ControladorLoja instancia;
    private IRepositorioLoja repositorio;

    public ControladorLoja() {
        this.repositorio = RepositorioLoja.getInstancia();
    }


    public static ControladorLoja getInstancia() {
        if (instancia == null) {
            instancia = new ControladorLoja();
        }
        return instancia;
    }

    public void cadastrarLoja( Loja c) throws ParametroNullException, JaExisteException{
        if (c != null) {
            if (!this.existeLoja(c.getNome())) {
                this.repositorio.cadastrarLoja(c);
                this.repositorio.salvarArquivo();
            } else {
                throw new JaExisteException("loja", "nome " + c.getNome());
            }
        } else {
            throw new ParametroNullException("loja");
        }
    }

    public Loja procurarLoja(String titulo) throws ParametroNullException, NaoExisteException{
        if (titulo != null) {
            if (this.existeLoja(titulo)) {
                return this.repositorio.procurarLoja(titulo);
            } else {
                throw new NaoExisteException("loja", "título " + titulo);
            }
        } else {
            throw new ParametroNullException("título");
        }
    }

    public ArrayList<Loja> procurarLojaPorCliente (Cliente cliente) throws ParametroNullException{
        return this.repositorio.procurarLojaPorCliente(cliente);
    }

    public Loja procurarLojaPorCategoria (EnumCategorias categoria) throws ParametroNullException, NaoExisteException{
        return this.repositorio.procurarLojaPorCategoria(categoria);
    }

    public ArrayList<Loja> procurarLojasPorCategoria (EnumCategorias categoriasEnum) {
        return this.procurarLojasPorCategoria(categoriasEnum);
    }

    public void removerLoja(Loja loja,String cpf) throws ParametroNullException, NaoExisteException{
        if(loja != null && cpf != null) {
            if (this.existeLoja(loja.getNome())) {
                this.repositorio.removerLoja(loja.getNome(), cpf);
                Cliente cliente = loja.getCliente();
                cliente.getLojas().remove(loja);
                Fachada.getInstancia().alterarUsuario(cliente, cliente);
                Fachada.getInstancia().salvarArquivo();
            } else {
                throw new NaoExisteException("loja", "nome " + loja.getNome());
            }
        } else {
            throw new ParametroNullException("loja/CPF");
        }
    }

    public  boolean existeLoja(String titulo) throws ParametroNullException{
        if (titulo != null) {
            return this.repositorio.existeLoja(titulo);
        } else {
            throw new ParametroNullException("título");
        }
    }

    public void alterarLoja (String nomeAntigo, Loja loja) throws ParametroNullException, NaoExisteException{
        if (nomeAntigo != null && loja != null) {
            if (this.existeLoja(nomeAntigo)) {
                this.repositorio.alterarLoja(nomeAntigo, loja);
                Cliente cliente = loja.getCliente();
                int i = cliente.getLojaPorTitulo(nomeAntigo);
                cliente.getLojas().set(i, loja);
                Fachada.getInstancia().alterarUsuario(cliente, cliente);
                Fachada.getInstancia().salvarArquivo();
            } else {
                throw new NaoExisteException("loja", "nome " + nomeAntigo);
            }
        } else {
            throw new ParametroNullException("antigo nome ou nova loja");
        }
    }

    public void alterarAnuncioNaLoja (String nomeAntigo, Anuncio anuncio) throws ParametroNullException {
        if (nomeAntigo != null && anuncio != null) {
            this.repositorio.alterarAnuncioNaLoja(nomeAntigo, anuncio);
        } else {
            throw new ParametroNullException("nome/anúncio");
        }
    }

    public void removerAnuncioDaLoja (String anuncio) throws ParametroNullException {
        if (anuncio != null) {
            this.repositorio.removerAnuncioDaLoja(anuncio);
        } else {
            throw new ParametroNullException("anúncio");
        }
    }

    public Loja[] listarLojas(){
        return  this.repositorio.listarLoja();
    }
    public int getProxima(){
        return this.repositorio.getProxima();
    }

    public ArrayList<Loja> buscarLojaPorTitulo(String palavra) {
        return this.repositorio.buscarLojaPorTitulo(palavra);
    }
    public ArrayList<Loja> buscarLojaPorCategoria(String categoria) {
        return this.repositorio.buscarLojaPorCategoria(categoria);
    }

    public void salvarArquivo () {
        this.repositorio.salvarArquivo();
    }
}
