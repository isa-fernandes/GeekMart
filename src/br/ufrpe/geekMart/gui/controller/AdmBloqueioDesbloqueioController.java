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

public class AdmBloqueioDesbloqueioController {

        Administrador user;
        Fachada fachada = Fachada.getInstancia();

        @FXML
        protected void initialize() {
                Main.addOnChangesScreenListener(new Main.OnChangeScreen() {
                        @Override
                        public void onScreenChanged(String newScreen, Object userData, ArrayList<Anuncio> userData2,
                                                    ArrayList<Anuncio> userData3, ArrayList<Loja> userData4) {
                                if (newScreen.equals("admBloqueioDesbloqueioScene")) {
                                        user = (Administrador) userData;


                                }
                        }
                });


        }


        @FXML
        private Button btMeusAnuncios;

        @FXML
        private ComboBox<?> cbCategorias;

        @FXML
        private Button btBuscar;

        @FXML
        private Button btMeuCadastro;

        @FXML
        private TextField tfBuscar;

        @FXML
        private Button btMinhasLojas;

        @FXML
        private Label lbTelefone;

        @FXML
        private Button btAlterarCadastro;

        @FXML
        private MenuItem menuSair;

        @FXML
        private MenuItem menuLoginCliente;

        @FXML
        private Button btCHAT;

        @FXML
        private Label lbNome;

        @FXML
        private ComboBox<?> cbLojas;

        @FXML
        private Label lbCPF;

        @FXML
        private Label lbStatus;

        @FXML
        private Label lbEmail;

        @FXML
        private Button btNovaLoja;

        @FXML
        private MenuItem menuLoginAdm;

        @FXML
        private Button btNovoAnuncio;

        @FXML
        private MenuItem menuSobreApp;


        @FXML
        protected void btMeuCadastroADMAction(ActionEvent e) {
                Main.trocarTela("admCadastroScene", user);
        }

        @FXML
        protected void btDesbloquearBloquearAction(ActionEvent e) {
                Main.trocarTela("admBloqueioDesbloqueioScene", user);
        }

        @FXML
        protected void btDeletarAnuncioAction(ActionEvent e) {
                Main.trocarTela("admDeletarAnuncioScene", user);
        }

        @FXML
        protected void btDeletarLojaAction(ActionEvent e) {
                Main.trocarTela("admDeletarLojaScene", user);
        }

        @FXML
        protected void btNovoAdmAction(ActionEvent e) {
                Main.trocarTela("admCadastrarNovoAdmScene", user);
        }

        @FXML
        protected void buscarClienteAction(ActionEvent e) {
                try {
                        Cliente usuario = (Cliente) fachada.buscaUsuario(tfBuscar.getText());
                        lbNome.setText(usuario.getNome());
                        String ativo;
                        if (usuario.isAtivo()) {
                                ativo = "Ativo";
                        } else {
                                ativo = "Bloqueado";
                        }
                        lbStatus.setText(usuario.getCpf());


                } catch (NaoExisteException ee) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erro");
                        alert.setHeaderText("Erro buscar usuário");
                        alert.setContentText("Cliente não existe");
                        alert.showAndWait();

                } catch (ParametroNullException eee) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erro");
                        alert.setHeaderText("Erro buscar usuário");
                        alert.setContentText("Campo 'CPF do Cliente' vazio!");
                        alert.showAndWait();


                }
        }


                @FXML
                protected void bloquearDesbloquearClienteAction (ActionEvent e){

                        try {
                                fachada.admBloquearDesbloquearUsuario(lbCPF.getText());

                                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                                alert2.setTitle("Informação");
                                alert2.setHeaderText("Bloqueio de Cliente");
                                alert2.setContentText("Status do cliente " + lbNome.getText() + " alterado com sucesso!");
                                alert2.showAndWait();

                        } catch (NaoExisteException ee) {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Erro");
                                alert.setHeaderText("Erro  buscar usuário");
                                alert.setContentText("Cliente não existe");
                                alert.showAndWait();

                        } catch (ParametroNullException eee) {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Erro");
                                alert.setHeaderText("Erro  buscar usuário");
                                alert.setContentText("Campo 'CPF do Cliente' vazio!");
                                alert.showAndWait();

                        }
                }


        }


