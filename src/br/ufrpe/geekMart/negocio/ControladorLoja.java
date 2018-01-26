package br.ufrpe.geekMart.negocio;

import br.ufrpe.geekMart.dados.IRepositorioLoja;
import br.ufrpe.geekMart.dados.RepositorioLoja;
import br.ufrpe.geekMart.exceptions.JaExisteException;
import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.classesBasicas.Categorias;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import br.ufrpe.geekMart.negocio.classesBasicas.Loja;
import br.ufrpe.geekMart.negocio.classesBasicas.Usuario;

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
        this.repositorio.cadastrarLoja(c);
    }

    public Loja procurarLoja(String titulo) throws ParametroNullException, NaoExisteException{
        return this.repositorio.procurarLoja(titulo);
    }

    public ArrayList<Loja> procurarLojaPorCliente (Cliente cliente) throws ParametroNullException{
        return this.procurarLojaPorCliente(cliente);
    }
    public Loja procurarLojaPorCategoria (Categorias categoria) throws ParametroNullException, NaoExisteException{
        return this.procurarLojaPorCategoria(categoria);
    }

    public void removerLoja(Loja loja) throws ParametroNullException, NaoExisteException{
        this.repositorio.removerLoja(loja);
    }

    public  boolean existeLoja(String titulo) throws ParametroNullException{
        return this.repositorio.existeLoja(titulo);
    }

    public void alterarLoja (String cpf, Loja loja) throws ParametroNullException, NaoExisteException{
        this.repositorio.alterarLoja(cpf,loja);
    }

    public Loja[] listarLojas(){
        return  this.repositorio.listarLoja();
    }
    public int getProxima(){
        return this.repositorio.getProxima();
    }
}
