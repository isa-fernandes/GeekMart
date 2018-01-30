package br.ufrpe.geekMart.dados;

import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.classesBasicas.*;

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

    private RepositorioLoja(int tamanho) {
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
                    /* Silent */
                }
            }
        }
    }

    public void cadastrarLoja(Loja c) {
        this.lojas[this.proxima] = c;
        this.proxima = this.proxima + 1;
        if (this.proxima == lojas.length) {
            this.duplicaArrayLojas();
        }
    }

    public Loja procurarLoja(String titulo) {
        Loja resultado = null;
        int i = this.procurarIndice(titulo);
        resultado = this.lojas[i];
        return resultado;
    }


    //SUGESTAO METODO RETORNA LOJAS DE UMA CATEGORIA
    //TODO
    public ArrayList<Loja> procurarLojasPorCategoria(EnumCategorias categoriasEnum) {
        ArrayList<Loja> resultados = null;
        for (int i = 0; i < this.proxima; i++) {
            if (this.lojas[i].getCategoria().equals(categoriasEnum)) {
                resultados.add(this.lojas[i]);
            }
        }
        return resultados;
    }

    public Loja procurarLojaPorCategoria(EnumCategorias categoria) throws ParametroNullException, NaoExisteException {
        Loja resultado = null;
        if (categoria != null) {
            int i = this.procurarIndiceCategoria(categoria);
            if (i < this.proxima) {
                resultado = this.lojas[i];
                return resultado;
            } else {
                throw new NaoExisteException("loja", "categoria"); //lembrar de alterar quando categoria for enum
            }
        } else {
            throw new ParametroNullException("categoria");
        }
    }

    public ArrayList<Loja> procurarLojaPorCliente(Cliente cliente) throws ParametroNullException {
        if (cliente != null) {
            return cliente.getLojas();
        } else {
            throw new ParametroNullException("cliente");
        }
    }

    public void removerLoja(String nomeDaLoja, String cpf) {
        int i = this.procurarIndiceRemover(nomeDaLoja, cpf);
        if (i < this.proxima) {
            this.lojas[i] = this.lojas[this.proxima - 1];
            this.lojas[this.proxima - 1] = null;
            this.proxima = this.proxima - 1;
        }
    }

    public int procurarIndiceRemover(String titulo, String cpf) {
        int i = 0;
        boolean achou = false;
        while ((!achou) && (i < this.proxima)) {
            if (titulo.equals(this.lojas[i].getNome()) && cpf.equals(this.lojas[i].getCliente().getCpf())) {
                achou = true;
            } else {
                i = i + 1;
            }
        }
        return i;
    }

    private int procurarIndice(String titulo) {
        int i = 0;
        boolean achou = false;
        while ((!achou) && (i < this.proxima)) {
            if (titulo.equals(this.lojas[i].getNome())) {
                achou = true;
            } else {
                i = i + 1;
            }
        }
        return i;
    }

    private int procurarIndiceCategoria(EnumCategorias categoria) {
        int i = 0;
        boolean achou = false;
        while ((!achou) && (i < this.proxima)) {
            if (categoria.equals(this.lojas[i].getCategoria())) {
                achou = true;
            } else {
                i = i + 1;
            }
        }
        return i;
    }

    public boolean existeLoja(String titulo) {
        boolean existe = false;
        int indice = this.procurarIndice(titulo);
        if (indice != this.proxima) {
            existe = true;
        }
        return existe;
    }

    public void duplicaArrayLojas() {
        if (this.lojas != null && this.lojas.length > 0) {
            Loja[] arrayDuplicado = new Loja[this.lojas.length * 2];
            for (int i = 0; i < this.lojas.length; i++) {
                arrayDuplicado[i] = this.lojas[i];
            }
            this.lojas = arrayDuplicado;
        }
    }

    @Override
    public void alterarLoja(String nomeAntigo, Loja loja) {
        int indice = this.procurarIndice(nomeAntigo);
        if (indice < this.proxima) {
            lojas[indice] = loja;
        }
    }

    private int procurarIndiceAnuncioNaLoja (String nome) {
        int result = -1;
        for (int i = 0; i < this.proxima; i++) {
            for (int j = 0; j < this.lojas[i].getAnuncios().size(); j++) {
                if (this.lojas[i].getAnuncios().get(j).getTitulo().equals(nome)) {
                    result = j;
                }
            }
        }
        return result;
    }

    public void alterarAnuncioNaLoja (String nomeAntigo, Anuncio anuncio) {
        int i = this.procurarIndiceAnuncioNaLoja(nomeAntigo);
        if (i != -1) {
            this.lojas[i].getAnuncios().set(i, anuncio);
        }
    }

    public void removerAnuncioDaLoja (String  anuncio) {
        int i = this.procurarIndiceAnuncioNaLoja(anuncio);
        if (i != -1) {
            this.lojas[i].getAnuncios().remove(i);
        }
    }

    public Loja[] listarLoja() {
        return lojas;
    }

    public int getProxima() {
        return proxima;
    }

    public ArrayList<Loja> buscarLojaPorTitulo(String palavra) {
        int i = 0;
        ArrayList<Loja> resultadoBuscaTitulo = new ArrayList<>();
        while (i < this.proxima) {
            if (this.lojas[i].getNome().contains(palavra)) {
                resultadoBuscaTitulo.add(lojas[i]);
            } else {
                i = i + 1;
            }
        }


        if (i == proxima) {
            System.out.println("Não foi encontrado nenhuma loja que contenha a palavra: " + palavra);

        }


        return resultadoBuscaTitulo;
    }

    public ArrayList<Loja> buscarLojaPorCategoria(String categoria) {
        int i = 0;
        ArrayList<Loja> resultadoBuscaCategoria = new ArrayList<>();
        while (i < this.proxima) {
            if (this.lojas[i].getCategoria().toString() == categoria) {
                resultadoBuscaCategoria.add(lojas[i]);
            } else {
                i = i + 1;
            }
        }


        if (i == proxima) {
            System.out.println("Não foi encontrado nenhuma loa da categoria: " + categoria);

        }


        return resultadoBuscaCategoria;
    }
}


    /*public  void ordenaPorPreco(ArrayList<Loja> an){
        Anuncio aux;
        int cont1, cont2;
        for(cont1 =0; cont1<an.size(); cont1++){
            for(cont2 =0; cont2 <an.size()-1; cont2++){
                if(Integer.parseInt(an.get(cont2).getPreco())> Integer.parseInt(an.get(cont2+1).getPreco())){
                    aux = an.get(cont2);
                    an.remove(cont2);
                    an.add(cont2,an.get(cont2+1));
                    an.remove(cont2+1);
                    an.add(cont2+1,aux);

                }
            }
        }
    }


}*/
