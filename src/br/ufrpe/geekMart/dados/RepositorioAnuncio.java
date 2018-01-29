package br.ufrpe.geekMart.dados;

import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;

import java.io.*;

public class RepositorioAnuncio implements IRepositorioAnuncio, Serializable {
    private Anuncio[] anuncios;
    private int proxima;
    private static RepositorioAnuncio instancia;

    public static RepositorioAnuncio getInstancia () {
        if (instancia == null) {
            instancia = lerDoArquivo();
        }
        return instancia;
    }

    private RepositorioAnuncio (int tamanho) {
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
                    /* Silent */}
            }
        }
    }

    public void cadastrarAnuncio (Anuncio c) {
        this.anuncios[this.proxima] = c;
        this.proxima = this.proxima + 1;
        if (this.proxima == this.anuncios.length) {
            this.duplicaArrayAnuncios();
        }
    }

    public int procurarIndice (String num){
        int i = 0;
        boolean achou = false;
        while ((!achou) && (i < this.proxima)){
            if (num.equals(this.anuncios[i].getTitulo())){
                achou = true;
            } else {
                i = i + 1;
            }
        }
        return i;
    }

    public int procurarIndiceRemover (String titulo, String cpf){
        int i = 0;
        boolean achou = false;
        while ((!achou) && (i < this.proxima)){
            if (titulo.equals(this.anuncios[i].getTitulo()) && cpf.equals(this.anuncios[i].getCliente().getCpf())){
                achou = true;
            } else {
                i = i + 1;
            }
        }
        return i;
    }

    /*public Anuncio[] getAnunciosCategoria (String categoria) {
        int i, qt = 0;
        Anuncio[] result = new Anuncio[this.proxima];
        int indice = Categorias.encontrarCategoria(categoria);
        for (i = 0; i < this.proxima; i++) {
            if (this.anuncios[i].getCategoria().equals(Categorias.getCategoria(indice))) {
                result[qt] = this.anuncios[i];
                qt++;
            }
        }
        return result;
    }

    public Anuncio[] getAnunciosCategoria (int categoria) {
        int i, qt = 0;
        Anuncio[] result = new Anuncio[this.proxima];
        for (i = 0; i < this.proxima; i++) {
            if (this.anuncios[i].getCategoria().equals(Categorias.getCategoria(categoria))) {
                result[qt] = this.anuncios[i];
                qt++;
            }
        }
        return result;
    }*/

    public Anuncio procurarAnuncio (String titulo) {
        int i = this.procurarIndice(titulo);
        Anuncio resultado;
        resultado = this.anuncios[i];
        return resultado;
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
