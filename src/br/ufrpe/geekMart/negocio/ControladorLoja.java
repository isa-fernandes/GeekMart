package br.ufrpe.geekMart.negocio;

import br.ufrpe.geekMart.dados.IRepositorioLoja;
import br.ufrpe.geekMart.dados.RepositorioLoja;
import br.ufrpe.geekMart.negocio.classesBasicas.Loja;

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

    public void cadastrarLoja (String cpf, Loja loja){
        if(cpf != null && loja != null){
            boolean existe = this.repositorio.existeCpf(cpf);
            if (existe != true){
                this.repositorio.cadastrarLoja(loja);
            }
        }
    }



}
