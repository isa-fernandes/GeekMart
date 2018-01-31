package br.ufrpe.geekMart.dados;

import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;
import br.ufrpe.geekMart.negocio.classesBasicas.Usuario;

import java.io.*;

public class RepositorioUsuario implements IRepositorioUsuario, Serializable {
    private Usuario[] usuarios;
    private Usuario user;
    private int proxima;
    private static RepositorioUsuario instancia;

    public static RepositorioUsuario getInstancia() {
        if (instancia == null) {
            instancia = lerDoArquivo();
        }
        return instancia;
    }

    private RepositorioUsuario (int tamanho) {
        this.usuarios = new Usuario[tamanho];
        this.proxima = 0;
    }

    private static RepositorioUsuario lerDoArquivo() {
        RepositorioUsuario instanciaLocal = null;

        File f = new File("lojas.dat");
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(f);
            objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            instanciaLocal = (RepositorioUsuario) object;
        } catch (Exception e) {
            instanciaLocal = new RepositorioUsuario(100);
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
        File f = new File("usuarios.dat");
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

    @Override
    public void cadastrarUsuario (Usuario c) {
        this.usuarios[this.proxima] = c;
        this.proxima = this.proxima + 1;
        if (this.proxima == this.usuarios.length) {
            this.duplicaArrayUsuarios();
        }

    }

    public Usuario buscarUsuario(String cpf) throws ParametroNullException, NaoExisteException {
        Usuario retorno = null;
        if(cpf != null){
            boolean existe = this.existeUsuario(cpf);
            if (existe) {
                int i = this.procurarIndice(cpf);
                if (i != this.proxima) {
                    retorno = this.usuarios[i];
                }
                return retorno;
            } else {
                throw new NaoExisteException("usuário", "CPF " + cpf);
            }
        } else {
            throw new ParametroNullException("CPF");
        }
    }

    @Override
    public boolean existeUsuario (String cpf) {
        boolean existe = false;
        int indice = this.procurarIndice(cpf);
        if (indice != proxima){
            existe = true;
        }
        return existe;
    }

    public void alterarUsuario (Usuario usuarioAntigo, Usuario usuarioNovo) {
        int indice = this.procurarIndice(usuarioAntigo.getCpf());
        if (indice != this.proxima) {
            usuarios[indice] = usuarioNovo;
        }
    }

    private int procurarIndice(String num){
        int i = 0;
        boolean achou = false;
        while ((!achou) && (i < this.proxima)) {
            if (num.equals(this.usuarios[i].getCpf())) {
                achou = true;
            } else {
                i++;
            }
        }
        return i;
    }

    public void duplicaArrayUsuarios () {
        if(this.usuarios != null && this.usuarios.length>0){
            Usuario[] arrayDuplicado = new Usuario[this.usuarios.length*2];
            for (int i=0; i< this.usuarios.length; i++){
                arrayDuplicado[i] = this.usuarios[i];
            }
            this.usuarios = arrayDuplicado;
        }
    }

    public Usuario[] listarUsuarios(){
        return usuarios;
    }

    public int getProxima() {
        return proxima;
    }

    public void setProxima(int proxima) {
        this.proxima = proxima;
    }
}
