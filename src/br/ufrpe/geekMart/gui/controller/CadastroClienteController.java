package br.ufrpe.geekMart.gui.controller;

import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class CadastroClienteController {

        Fachada fachada = Fachada.getInstancia();
        Cliente user;

        @FXML
        protected  void  initialize(){
                Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
                        @Override
                        public void onScreenChanged(String newScreen, Object userData) {
                                if(newScreen.equals("cadastroClienteScene")) {
                                        user = (Cliente)userData;
                                        System.out.println(user);
                                        updateComboBoxCategorias();
                                        updateComboBoxLojas();
                                        updateCadastroTela();

                                } }
                });


                updateComboBoxCategorias();
                updateComboBoxLojas();


        }



        private void updateComboBoxCategorias(){
                for(int i = 0; i < fachada.listarCategorias().size(); i++){
                        cbCategorias.getItems().add(i,fachada.listarCategorias().get(i));
                }
        }

        private void updateComboBoxLojas(){
                for(int i = 0; i < fachada.listarCategorias().size(); i++){
                        cbLojas.getItems().add(i,fachada.listarCategorias().get(i));
                }
        }

        private void updateCadastroTela(){
                lbNome.setText(user.getNome());
                lbCPF.setText(user.getCpf());
                lbEmail.setText(user.getEmail());
                lbTelefone.setText(user.getTelefone());
                lbLogradouro.setText(user.getEndereco().getLogradouro());
                lbNumero.setText(user.getEndereco().getNumero());
                lbBairro.setText(user.getEndereco().getBairro());
                lbCidade.setText(user.getEndereco().getCidade());
                lbCEP.setText(user.getEndereco().getCep());
                lbEstado.setText(user.getEndereco().getEstado());
                lnComplemento.setText(user.getEndereco().getComplemento());


        }




        @FXML
        private ComboBox cbCategorias;

        @FXML
        private Button btBuscar;

        @FXML
        private Button btMeuCadastro;

        @FXML
        private Button btMinhasLojas;

        @FXML
        private Label lbEstado;

        @FXML
        private Label lbCidade;

        @FXML
        private Button btCHAT;

        @FXML
        private Label lbLogradouro;

        @FXML
        private Label lbCPF;

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
        private Button btMeusAnuncios;

        @FXML
        private Label lbCEP;

        @FXML
        private TextField tfBuscar;

        @FXML
        private Label lbNumero;

        @FXML
        private Button btHome;

        @FXML
        private Label lbTelefone;

        @FXML
        private Label lbBairro;

        @FXML
        private Button btAlterarCadastro;

        @FXML
        private MenuItem menuSair;

        @FXML
        private MenuItem menuLoginCliente;

        @FXML
        private Label lnComplemento;

        @FXML
        private Label lbNome;

        @FXML
        private ComboBox cbLojas;

        @FXML
        protected  void btHomeAction(ActionEvent e){
                Main.trocarTela("telaInicialLogadoScene",user);
        }

        @FXML
        protected  void btMeuCadastroAction(ActionEvent e){
                Main.trocarTela("cadastroClienteScene",user);
        }

        @FXML
        protected  void btMeusAnunciosAction(ActionEvent e){ Main.trocarTela("meusAnunciosScene",user); }

        @FXML
        protected  void btMinhasLojasAction(ActionEvent e){
                Main.trocarTela("minhasLojasScene",user);
        }

        @FXML
        protected  void btNovoAnuncioAction(ActionEvent e){
                Main.trocarTela("cadastrarNovoAnuncioScene",user);
        }

        @FXML
        protected  void btNovaLojaAction(ActionEvent e){
                Main.trocarTela("cadastrarNovaLojaScene",user);
        }

        @FXML
        protected  void btChatAction(ActionEvent e){
                Main.trocarTela("chatScene",user);
        }



}
