package br.ufrpe.geekMart.negocio;

import br.ufrpe.geekMart.dados.IRepositorioUsuario;
import br.ufrpe.geekMart.dados.RepositorioUsuario;
import br.ufrpe.geekMart.exceptions.JaExisteException;
import br.ufrpe.geekMart.exceptions.LoginSemSucessoException;
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
                this.repositorio.salvarArquivo();
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
                this.repositorio.salvarArquivo();
            } else {
                throw new NaoExisteException("usuário", "CPF " + cpf);
            }
        } else {
            throw new ParametroNullException("CPF");
        }
    }

    public Usuario buscarUsuario(String cpf) throws ParametroNullException, NaoExisteException{
        return this.repositorio.buscarUsuario(cpf);
    }

    public boolean existeUsuario(String cpf){
        return  this.repositorio.existeUsuario(cpf);
    }

    public  void alterarUsuario(Usuario usuario, Usuario usuarioNovo)
            throws ParametroNullException, NaoExisteException {
        if (usuario != null && usuarioNovo != null) {
            if (this.existeUsuario(usuario.getCpf())) {
                this.repositorio.alterarUsuario(usuario, usuarioNovo);
                this.repositorio.salvarArquivo();
            } else {
                throw new NaoExisteException("usuário", "CPF " + usuario.getCpf());
            }
        } else {
            throw new ParametroNullException("usuário");
        }
    }



    public boolean autenticarLogin(String senha, String cpf)
            throws ParametroNullException, NaoExisteException ,LoginSemSucessoException {
        boolean retorno = false;
        if (cpf != null && senha != null) {
            boolean existe = this.repositorio.existeUsuario(cpf);
            boolean tipo = repositorio.buscarUsuario(cpf).isAtivo();
            if (existe != false && tipo!=false) {
                boolean equivale = repositorio.buscarUsuario(cpf).getSenha().equals(senha);
                if(equivale != false){
                    retorno = true;
                } else {
                    LoginSemSucessoException lss = new LoginSemSucessoException(senha,cpf);
                    throw lss;
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

    public Usuario[] listarUsuarios(){
        return  this.repositorio.listarUsuarios();
    }

    public int getProxima(){
        return this.repositorio.getProxima();
    }

}
