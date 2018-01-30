package br.ufrpe.geekMart.gui.controller;
import br.ufrpe.geekMart.exceptions.JaExisteException;
import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class AdmCadastrarNovoAdmController {


        Administrador user;
        Fachada fachada = Fachada.getInstancia();

        @FXML
        protected  void  initialize(){
                Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
                        @Override
                        public void onScreenChanged(String newScreen, Object userData, ArrayList<Anuncio> userData2,
                                                    ArrayList<Anuncio> userData3, ArrayList<Loja> userData4) {
                                if(newScreen.equals("admCadastrarNovoAdmScene")) {
                                        user=(Administrador)userData;


                                } }
                });




        }



        @FXML
        private Button btNovoAdm;

        @FXML
        private Button btMeusAnuncios;

        @FXML
        private ComboBox<?> cbCategorias;

        @FXML
        private Button btBuscar;

        @FXML
        private TextField tfEmail;

        @FXML
        private Button btMeuCadastro;

        @FXML
        private TextField tfBuscar;

        @FXML
        private PasswordField pwfSenha;

        @FXML
        private Button btMinhasLojas;

        @FXML
        private TextField tfTelefone;

        @FXML
        private  TextField tfNome;

        @FXML
        private  TextField tfCPF;

        @FXML
        private MenuItem menuSair;

        @FXML
        private MenuItem menuLoginCliente;

        @FXML
        private Button btCHAT;

        @FXML
        private ComboBox<?> cbLojas;

        @FXML
        private Button btNovaLoja;

        @FXML
        private MenuItem menuLoginAdm;

        @FXML
        private Button btNovoAnuncio;

        @FXML
        private MenuItem menuSobreApp;

        @FXML
        protected  void btMeuCadastroADMAction(ActionEvent e){
                Main.trocarTela("admCadastroScene",user);
        }

        @FXML
        protected  void btDesbloquearBloquearAction(ActionEvent e){ Main.trocarTela("admBloqueioDesbloqueioScene",user); }

        @FXML
        protected  void btDeletarAnuncioAction(ActionEvent e){
                Main.trocarTela("admDeletarAnuncioScene",user);
        }

        @FXML
        protected  void btDeletarLojaAction(ActionEvent e){
                Main.trocarTela("admDeletarLojaScene",user);
        }

        @FXML
        protected  void btNovoAdmAction(ActionEvent e){
                Main.trocarTela("admCadastrarNovoAdmScene",user);
        }

        @FXML
        protected  void cadastrarNovoAdmAction(ActionEvent e){
                try {
                        if(tfNome.getText().isEmpty())
                                throw new RuntimeException("O campo nome não pode ser vazio");
                        if(tfCPF.getText().isEmpty())
                                throw new RuntimeException("O campo cpf não pode ser vazio");
                        if(tfEmail.getText().isEmpty())
                                throw new RuntimeException("O campo e-mail não pode ser vazio");
                        if(tfTelefone.getText().isEmpty())
                                throw new RuntimeException("O campo telefone não pode ser vazio");
                        if(pwfSenha.getText().isEmpty())
                                throw new RuntimeException("O campo senha não pode ser vazio");


                        boolean adm = true;
                        boolean ativo = true;

                        Administrador g = new Administrador(
                                tfNome.getText(),
                                tfCPF.getText(),
                                tfEmail.getText(),
                                pwfSenha.getText(),
                                adm,
                                ativo,
                                tfTelefone.getText());



                        fachada.cadastrarUsuario(g);
                        System.out.println(fachada.buscaUsuario(g.getCpf()));

                        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                        alert2.setTitle("Informação");
                        alert2.setHeaderText("Cadastro de Usuário");
                        alert2.setContentText("Usuário "+tfNome.getText()+" cadastrado com sucesso!");
                        alert2.showAndWait();

                } catch (RuntimeException ex){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erro");
                        alert.setHeaderText("Erro ao criar o Usuário!!");
                        alert.setContentText(ex.getMessage());
                        alert.showAndWait();
                } catch (ParametroNullException exx){
                        Alert alertw = new Alert(Alert.AlertType.ERROR);
                        alertw.setTitle("Erro");
                        alertw.setHeaderText("Erro ao criar o Usuário");
                        alertw.setContentText("Não foi possível completar o cadastro!!!!!!!");
                        alertw.showAndWait();
                } catch (NaoExisteException exx){
                        Alert alertw = new Alert(Alert.AlertType.ERROR);
                        alertw.setTitle("Erro");
                        alertw.setHeaderText("Erro ao criar o Usuário");
                        alertw.setContentText("Não foi possível completar o cadastro!!!!");
                        alertw.showAndWait();
                } catch (JaExisteException exx) {
                        Alert alertw = new Alert(Alert.AlertType.ERROR);
                        alertw.setTitle("Erro");
                        alertw.setHeaderText("Erro ao criar o Usuário");
                        alertw.setContentText("Esse usuário já existe!!");
                        alertw.showAndWait();
                }


                tfNome.setText("");
                tfCPF.setText("");
                tfEmail.setText("");
                tfTelefone.setText("");
                pwfSenha.setText("");

        }





}
