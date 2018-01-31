package br.ufrpe.geekMart.dados;

import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;

import java.io.*;
import java.util.ArrayList;

public class RepositorioAnuncio implements IRepositorioAnuncio, Serializable {
    private Anuncio[] anuncios;
    private int proxima;
    private static RepositorioAnuncio instancia;

    public static RepositorioAnuncio getInstancia() {
        if (instancia == null) {
            instancia = lerDoArquivo();
        }
        return instancia;
    }

    private RepositorioAnuncio(int tamanho) {
        this.anuncios = new Anuncio[tamanho];
        this.proxima = 0;
    }

    private static RepositorioAnuncio lerDoArquivo() {
        RepositorioAnuncio instanciaLocal = null;

        File f = new File("anuncios.dat");
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(f);
            objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            instanciaLocal = (RepositorioAnuncio) object;
        } catch (Exception e) {
            instanciaLocal = new RepositorioAnuncio(100);
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
        File f = new File("anuncios.dat");
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

    public void cadastrarAnuncio(Anuncio c) {
        this.anuncios[this.proxima] = c;
        System.out.println("Anuncio Cadastrado");
        this.proxima = this.proxima + 1;
        if (this.proxima == this.anuncios.length) {
            this.duplicaArrayAnuncios();
        }
    }

    public int procurarIndice(String num) {
        int i = 0;
        boolean achou = false;
        while ((!achou) && (i < this.proxima)) {
            if (num.equals(this.anuncios[i].getTitulo())) {
                achou = true;
            } else {
                i = i + 1;
            }
        }
        return i;
    }

    public int procurarIndiceRemover(String titulo, String cpf) {
        int i = 0;
        boolean achou = false;
        while ((!achou) && (i < this.proxima)) {
            if (titulo.equals(this.anuncios[i].getTitulo()) && cpf.equals(this.anuncios[i].getCpfCliente())) {
                achou = true;
            } else {
                i = i + 1;
            }
        }
        return i;
    }


    public Anuncio procurarAnuncio(String titulo) {
        int i = this.procurarIndice(titulo);
        Anuncio resultado;
        resultado = this.anuncios[i];
        return resultado;
    }

    public ArrayList<Anuncio> buscarAnuncioPorTituloOrdenadoPeloPreco(String palavra) {
        int i = 0;
        int j = 0;
        ArrayList<Anuncio> resultadoBuscaTitulo = new ArrayList<>();
        while (i < this.proxima) {
            if (this.anuncios[i].getTitulo().contains(palavra)) {
                resultadoBuscaTitulo.add(j,anuncios[i]);
                System.out.println("Anuncio encontrado: "+anuncios[i].getTitulo());
                j = j+1;
                i++;
            } else {
                i = i + 1;
            }
        }

        instancia.ordenaPorPreco(resultadoBuscaTitulo);






        return resultadoBuscaTitulo;
    }

    public ArrayList<Anuncio> buscarAnuncioPorCategoriaOrdenadoPeloPreco(String categoria) {
        int i = 0;
        ArrayList<Anuncio> resultadoBuscaCategoria = new ArrayList<>();
        while (i < this.proxima) {
            if (this.anuncios[i].getCategoria().toString() == categoria) {
                resultadoBuscaCategoria.add(anuncios[i]);
            } else {
                i = i + 1;
            }
        }

        instancia.ordenaPorPreco(resultadoBuscaCategoria);

        if (i == proxima) {
            System.out.println("Não foi encontrado nenhum anúncio da categoria: " + categoria);

        }




        return resultadoBuscaCategoria;
    }


    public  void ordenaPorPreco(ArrayList<Anuncio> an){
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
        System.out.println("Anuncio ordenado");
    }





    public void removerAnuncio (String titulo, String cpf) {
        int i = this.procurarIndiceRemover(titulo,cpf);
        if (i < this.proxima) {
            this.anuncios[i] = this.anuncios[this.proxima - 1];
            this.anuncios[this.proxima - 1] = null;
            this.proxima = this.proxima - 1;
        }
    }

    @Override
    public boolean existe (String titulo) {
        boolean existe = false;
        int indice = this.procurarIndice(titulo);
        if (indice < this.proxima) {
            existe = true;
        }
        return existe;
    }

    public void duplicaArrayAnuncios () {
        if (this.anuncios != null && this.anuncios.length>0) {
            Anuncio[] arrayDuplicado = new Anuncio[this.anuncios.length*2];
            for (int i=0; i< this.anuncios.length; i++) {
                arrayDuplicado[i] = this.anuncios[i];
            }
            this.anuncios = arrayDuplicado;
        }
    }


    public void alterarAnuncio (String nomeAntigo, Anuncio anuncio) {
        int i = this.procurarIndice(nomeAntigo);
        if (i < this.proxima) {
            this.anuncios[i] = anuncio;
        }
    }

    public Anuncio[] listarAnuncios(){
        return anuncios;
    }

    public int getProxima() {
        return proxima;
    }


}
