package br.ufrpe.geekMart.negocio;

import br.ufrpe.geekMart.dados.IRepositorioUsuario;
import br.ufrpe.geekMart.dados.RepositorioUsuario;
import br.ufrpe.geekMart.exceptions.JaExisteException;
import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.classesBasicas.Usuario;

public class ControladorUsuario {
    private static ControladorUsuario instancia;
    private IRepositorioUsuario repositorio;

    ControladorUsuario() {
        this.repositorio = RepositorioUsuario.getInstancia();
    }

    public static ControladorUsuario getInstancia() {
        if (instancia == null) {
            instancia = new ControladorUsuario();
        }
        return instancia;
    }

    public void cadastrarUsuario(Usuario user) throws ParametroNullException, JaExisteException {
        if (user != null) {
            boolean existe = this.repositorio.existeUsuario(user.getCpf());
            if (!existe) {
                this.repositorio.cadastrarUsuario(user);
            } else {
                throw new JaExisteException("usuário", "CPF " + user.getCpf());
            }
        } else {
            throw new ParametroNullException("usuário");
        }
    }

    public void removerUsuario(String cpf) throws ParametroNullException, NaoExisteException {
        if(cpf != null){
            if(this.repositorio.existeUsuario(cpf)) {
                this.repositorio.removerUsuario(cpf);
            } else {
                throw new NaoExisteException("usuário", "CPF " + cpf);
            }
        } else {
            throw new ParametroNullException("CPF");
        }
    }

    public boolean autenticarLogin(String senha, String cpf) throws ParametroNullException, NaoExisteException {
        boolean retorno = false;
        if (cpf != null && senha != null) {
            boolean existe = this.repositorio.existeUsuario(cpf);
            boolean tipo = repositorio.buscarUsuario(cpf).isAtivo();
            if (existe != false && tipo!=false) {
                boolean equivale = repositorio.buscarUsuario(cpf).getSenha().equals(senha);
                if(equivale != false){
                    retorno = true;
                }
            }

        }
        return retorno;

    }


    public void admBloquearDesbloquearUsuario (String cpf) throws ParametroNullException, NaoExisteException {
        if (cpf != null) {
            if(repositorio.buscarUsuario(cpf).isAtivo()){
                repositorio.buscarUsuario(cpf).setAtivo(false);
            } else {
                repositorio.buscarUsuario(cpf).setAtivo(true);
            }
        }
    }

}
