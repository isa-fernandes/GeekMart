package br.ufrpe.geekMart.dados;

import br.ufrpe.geekMart.negocio.classesBasicas.Categorias;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import br.ufrpe.geekMart.negocio.classesBasicas.Loja;

public class RepositorioLoja implements IRepositorioLoja{
    private Loja[] lojas;
    private int proxima;
    private static RepositorioLoja instancia;

    public static RepositorioLoja getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioLoja(100);
        }
        return instancia;
    }

    private RepositorioLoja (int tamanho){
        this.lojas = new Loja[tamanho];
        this.proxima = 0;
    }

    public void cadastrarLoja (Loja c) {
        boolean r = this.existeLoja(c.getNome());
        if (r == false) {
            this.lojas[this.proxima] = c;
            this.proxima = this.proxima +1;
            if (this.proxima == lojas.length) {
                this.duplicaArrayLojas();
            }
        }
    }

    public Loja procurarLoja (String titulo) {
        Loja resultado = null;
        if( titulo != null) {
            int i = this.procurarIndice(titulo);
            if (i < this.proxima) {
                resultado = this.lojas[i];
            }
        }
        return resultado;
    }

    public Loja procurarLojaPorCategoria (Categorias categoria) {
        Loja resultado = null;
        if( categoria != null) {
            int i = this.procurarIndiceCategoria(categoria);
            if (i < this.proxima) {
                resultado = this.lojas[i];
            }
        }
        return resultado;
    }

    public Loja procurarLojaPorCliente (Cliente cliente) {
        Loja resultado = null;
        if( cliente != null) {
            int i = this.procurarIndiceCpf(cliente.getCpf());
            if (i < this.proxima) {
                resultado = this.lojas[i];
            }
        }
        return resultado;
    }

    public void removerLoja (String cpf){
        if(cpf != null) {
            int i = this.procurarIndiceCpf(cpf);
            if (i < this.proxima) {
                this.lojas[i] = this.lojas[this.proxima - 1];
                this.lojas[this.proxima - 1] = null;
                this.proxima = this.proxima - 1;
            } else {

            }
        }
    }

    private int procurarIndice (String titulo) {
        int i = 0;
        boolean achou = false;
        while ((!achou) && (i < this.proxima)){
            if (titulo.equals(this.lojas[i].getNome())) {
                achou = true;
            } else {
                i = i+1;
            }
        }
        return i;
    }

    private int procurarIndiceCpf (String titulo) {
        int i = 0;
        boolean achou = false;
        while ((!achou) && (i < this.proxima)){
            if (titulo.equals(this.lojas[i].getCliente().getCpf())) {
                achou = true;
            } else {
                i = i+1;
            }
        }
        return i;
    }


    private int procurarIndiceCategoria (Categorias categoria) {
        int i = 0;
        boolean achou = false;
        while ((!achou) && (i < this.proxima)){
            if (categoria.equals(this.lojas[i].getCategoria())) {
                achou = true;
            } else {
                i = i+1;
            }
        }
        return i;
    }

    public boolean existeLoja (String titulo) {
        boolean existe = false;
        if(titulo != null) {
            int indice = this.procurarIndice(titulo);
            if (indice != this.proxima) {
                existe = true;
            }
        }
        return existe;
    }

    public boolean existeCpf (String titulo) {
        boolean existe = false;
        int indice = this.procurarIndiceCpf(titulo);
        if (indice != this.proxima) {
            existe = true;
        }
        return existe;
    }

    public void duplicaArrayLojas(){
        if (this.lojas != null && this.lojas.length>0) {
            Loja[] arrayDuplicado = new Loja[this.lojas.length*2];
            for(int i=0; i< this.lojas.length; i++) {
                arrayDuplicado[i] = this.lojas[i];
            }
            this.lojas = arrayDuplicado;
        }
    }
    @Override
    public void alterarLoja (String cpf, Loja loja) {
        if (cpf != null && loja != null) {
            int indice = this.procurarIndiceCpf(cpf);
            if (indice < this.proxima) {
                lojas[indice] = loja;
            }
        }
    }
}
