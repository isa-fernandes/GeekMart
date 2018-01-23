package br.ufrpe.geekMart.dados;

import br.ufrpe.geekMart.exceptions.JaExisteException;
import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.classesBasicas.Categorias;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import br.ufrpe.geekMart.negocio.classesBasicas.Loja;

import java.util.ArrayList;

public class RepositorioLoja implements IRepositorioLoja {
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

    public void cadastrarLoja (Loja c) throws ParametroNullException, JaExisteException {
        if (c != null) {
            boolean r = this.existeLoja(c.getNome());
            if (!r) {
                this.lojas[this.proxima] = c;
                this.proxima = this.proxima + 1;
                if (this.proxima == lojas.length) {
                    this.duplicaArrayLojas();
                }
            } else {
                throw new JaExisteException("loja", "nome " + c.getNome());
            }
        } else {
            throw new ParametroNullException("loja");
        }
    }

    public Loja procurarLoja (String titulo) throws ParametroNullException, NaoExisteException {
        Loja resultado = null;
        if( titulo != null) {
            int i = this.procurarIndice(titulo);
            if (i < this.proxima) {
                resultado = this.lojas[i];
                return resultado;
            } else {
                throw new NaoExisteException("loja", "título " + titulo);
            }
        } else {
            throw new ParametroNullException("título");
        }
    }

    public Loja procurarLojaPorCategoria (Categorias categoria) throws ParametroNullException, NaoExisteException {
        Loja resultado = null;
        if( categoria != null) {
            int i = this.procurarIndiceCategoria(categoria);
            if (i < this.proxima) {
                resultado = this.lojas[i];
                return resultado;
            } else {
                throw new NaoExisteException("loja", "categoria" + ); //lembrar de alterar quando categoria for enum
            }
        } else {
            throw new ParametroNullException("categoria");
        }
    }

    public ArrayList<Loja> procurarLojaPorCliente (Cliente cliente) throws ParametroNullException {
        if( cliente != null) {
            return cliente.getLojas();
        } else {
            throw new ParametroNullException("cliente");
        }
    }

    public void removerLoja (Loja loja) throws ParametroNullException, NaoExisteException {
        if(loja != null) {
            int i = this.procurarIndice(loja.getNome());
            if (i < this.proxima) {
                this.lojas[i] = this.lojas[this.proxima - 1];
                this.lojas[this.proxima - 1] = null;
                this.proxima = this.proxima - 1;
            } else {
                throw new NaoExisteException("loja", "nome " + loja.getNome());
            }
        } else {
            throw new ParametroNullException("loja");
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

    public boolean existeLoja (String titulo) throws ParametroNullException {
        boolean existe = false;
        if(titulo != null) {
            int indice = this.procurarIndice(titulo);
            if (indice != this.proxima) {
                existe = true;
            }
        } else {
            throw new ParametroNullException("título");
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
    public void alterarLoja (String nomeAntigo, Loja loja) throws ParametroNullException, NaoExisteException {
        if (nomeAntigo != null && loja != null) {
            int indice = this.procurarIndice(nomeAntigo);
            if (indice < this.proxima) {
                lojas[indice] = loja;
            } else {
                throw new NaoExisteException("loja", "nome " + nomeAntigo);
            }
        } else {
            throw new ParametroNullException("antigo nome ou nova loja");
        }
    }
}
