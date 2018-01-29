package br.ufrpe.geekMart.dados;

import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;

public class RepositorioAnuncio implements IRepositorioAnuncio {
    private Anuncio[] anuncios;
    private int proxima;
    private static RepositorioAnuncio instancia;

    public static RepositorioAnuncio getInstancia () {
        if (instancia == null) {
            instancia = new RepositorioAnuncio(100);
        }
        return instancia;
    }

    private RepositorioAnuncio (int tamanho) {
        this.anuncios = new Anuncio[tamanho];
        this.proxima = 0;
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

    public Anuncio procurarAnuncio (String titulo) throws ParametroNullException, NaoExisteException {
        if (titulo != null) {
            int i = this.procurarIndice(titulo);
            Anuncio resultado;
            if (i < this.proxima) {
                resultado = this.anuncios[i];
                return resultado;
            } else {
                throw new NaoExisteException("anúncio", "título " + titulo);
            }
        } else {
            throw new ParametroNullException("título");
        }
    }

    public void removerAnuncio (String titulo, String cpf) throws ParametroNullException, NaoExisteException {
        if (titulo != null) {
            int i = this.procurarIndiceRemover(titulo,cpf);
            if (i < this.proxima) {
                this.anuncios[i] = this.anuncios[this.proxima - 1];
                this.anuncios[this.proxima - 1] = null;
                this.proxima = this.proxima - 1;

            } else {
                throw new NaoExisteException("anúncio ", "título " + titulo);
            }
        } else {
            throw new ParametroNullException("título");
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


    public void alterarAnuncio (String nomeAntigo, Anuncio anuncio) throws ParametroNullException, NaoExisteException {
        if (nomeAntigo != null && anuncio != null) {
            int i = this.procurarIndice(nomeAntigo);
            if (i < this.proxima) {
                this.anuncios[i] = anuncio;
            } else {
                throw new NaoExisteException("anúncio", "título " + nomeAntigo);
            }
        } else {
            throw new ParametroNullException("anúncio");
        }
    }

    public Anuncio[] listarAnuncios(){
        return anuncios;
    }

    public int getProxima() {
        return proxima;
    }


}
