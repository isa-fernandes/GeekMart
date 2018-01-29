package br.ufrpe.geekMart.dados;

import br.ufrpe.geekMart.exceptions.JaExisteException;
import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.classesBasicas.Categorias;
import br.ufrpe.geekMart.negocio.classesBasicas.CategoriasEnum;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import br.ufrpe.geekMart.negocio.classesBasicas.Loja;

import java.io.*;
import java.util.ArrayList;

public class RepositorioLoja implements IRepositorioLoja, Serializable {
    private Loja[] lojas;
    private int proxima;
    private static RepositorioLoja instancia;

    public static RepositorioLoja getInstancia() {
        if (instancia == null) {
            instancia = lerDoArquivo();
        }
        return instancia;
    }

    private RepositorioLoja (int tamanho){
        this.lojas = new Loja[tamanho];
        this.proxima = 0;
    }

    private static RepositorioLoja lerDoArquivo() {
        RepositorioLoja instanciaLocal = null;

        File f = new File("lojas.dat");
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(f);
            objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            instanciaLocal = (RepositorioLoja) object;
        } catch (Exception e) {
            instanciaLocal = new RepositorioLoja(100);
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {/* Silent exception */
                }
            }
        }
        return instanciaLocal;
    }

    public void salvarArquivo() {
        if (instancia == null) {
            return;
        }
        File f = new File("lojas.dat");
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(f);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(instancia);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    /* Silent */}
            }
        }
    }

    public void cadastrarLoja (Loja c) {
        this.lojas[this.proxima] = c;
        this.proxima = this.proxima + 1;
        if (this.proxima == lojas.length) {
            this.duplicaArrayLojas();
        }
    }

    public Loja procurarLoja (String titulo) {
        Loja resultado = null;
        int i = this.procurarIndice(titulo);
        resultado = this.lojas[i];
        return resultado;
    }

    public ArrayList<Loja> procurarLojasPorCategoria (CategoriasEnum categoriasEnum) {
        ArrayList<Loja> resultados = null;
        for (int i = 0; i < this.proxima; i++) {
            if (this.lojas[i].getCategoriasEnum().equals(categoriasEnum)) {
                resultados.add(this.lojas[i]);
            }
        }
        return resultados;
    }

    /*public Loja procurarLojaPorCategoria (Categorias categoria) throws ParametroNullException, NaoExisteException {
        Loja resultado = null;
        if( categoria != null) {
            int i = this.procurarIndiceCategoria(categoria);
            if (i < this.proxima) {
                resultado = this.lojas[i];
                return resultado;
            } else {
                throw new NaoExisteException("loja", "categoria" ); //lembrar de alterar quando categoria for enum
            }
        } else {
            throw new ParametroNullException("categoria");
        }
    }*/

    public ArrayList<Loja> procurarLojaPorCliente (Cliente cliente) throws ParametroNullException {
        if( cliente != null) {
            return cliente.getLojas();
        } else {
            throw new ParametroNullException("cliente");
        }
    }

    public void removerLoja (String nomeDaLoja,String cpf) {
        int i = this.procurarIndiceRemover(nomeDaLoja,cpf);
        if (i < this.proxima) {
            this.lojas[i] = this.lojas[this.proxima - 1];
            this.lojas[this.proxima - 1] = null;
            this.proxima = this.proxima - 1;
        }
    }

    public int procurarIndiceRemover (String titulo, String cpf){
        int i = 0;
        boolean achou = false;
        while ((!achou) && (i < this.proxima)){
            if (titulo.equals(this.lojas[i].getNome()) && cpf.equals(this.lojas[i].getCliente().getCpf())){
                achou = true;
            } else {
                i = i + 1;
            }
        }
        return i;
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

    public boolean existeLoja (String titulo) {
        boolean existe = false;
        int indice = this.procurarIndice(titulo);
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
    public void alterarLoja (String nomeAntigo, Loja loja) {
        int indice = this.procurarIndice(nomeAntigo);
        if (indice < this.proxima) {
            lojas[indice] = loja;
        }
    }

    public Loja[] listarLoja(){
        return lojas;
    }

    public int getProxima() {
        return proxima;
    }


}
