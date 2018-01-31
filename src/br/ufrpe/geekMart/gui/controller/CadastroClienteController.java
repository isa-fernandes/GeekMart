package br.ufrpe.geekMart.gui.controller;

import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;
import br.ufrpe.geekMart.negocio.classesBasicas.EnumCategorias;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import br.ufrpe.geekMart.negocio.classesBasicas.Loja;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class CadastroClienteController {

        Fachada fachada = Fachada.getInstancia();
        Cliente user;

        @FXML
        protected  void  initialize(){
                Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
                        @Override
                        public void onScreenChanged(String newScreen, Object userData, ArrayList<Anuncio> userData2,
                                                    ArrayList<Anuncio> userData3, ArrayList<Loja> userData4) {
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



        private  void  updateComboBoxCategorias(){
                this.cbCategorias.getItems().setAll(EnumCategorias.values());
        }

        private void updateComboBoxLojas(){
                this.cbLojas.getItems().setAll(EnumCategorias.values());
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
                lbEstado.setText(user.getEndereco().getEstado().toString());
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
        protected  void btMinhasLojasAction(ActionEvent e){

                ArrayList<Loja> lojas = user.getLojas();

                if(lojas.size()<6 && lojas.size()>=0) {

                        switch (lojas.size()) {
                                case 1:
                                        Main.trocarTela("minhasLojas1Scene", user);
                                        break;
                                case 2:
                                        Main.trocarTela("minhasLojas2Scene",user);
                                        break;
                                case 3:
                                        Main.trocarTela("minhasLojas3Scene",user);
                                        break;
                                case 4:
                                        Main.trocarTela("minhasLojas4Scene",user);
                                        break;
                                case 5:
                                        Main.trocarTela("minhasLojas5Scene", user);
                                        break;

                                case 0:
                                        Main.trocarTela("minhasLojas0Scene",user);
                                        break;
                        }
                } else if(lojas.size() >= 6) {
                        Main.trocarTela("minhasLojas6Scene",user);
                }


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

        @FXML
        protected  void btAlterarAction(ActionEvent e){
                Main.trocarTela("alterarClienteScene",user);
        }


        @FXML
        protected  void btMeusAnunciosAction(ActionEvent e){

                ArrayList<Anuncio> anuncios = user.getAnuncios();

                if(anuncios.size()<6 && anuncios.size()>=0) {

                        switch (anuncios.size()) {
                                case 1:
                                        Main.trocarTela("meusAnuncios1Scene", user,anuncios);
                                        break;
                                case 2:
                                        Main.trocarTela("meusAnuncios2Scene",user, anuncios);
                                        break;
                                case 3:
                                        Main.trocarTela("meusAnuncios3Scene",user, anuncios);
                                        break;
                                case 4:
                                        Main.trocarTela("meusAnuncios4Scene",user, anuncios);
                                        break;
                                case 5:
                                        Main.trocarTela("meusAnuncios5Scene", user,anuncios);
                                        break;

                                case 0:
                                        Main.trocarTela("meusAnuncios0Scene",user, anuncios);
                                        break;
                        }
                } else if(anuncios.size() >= 6) {
                        Main.trocarTela("meusAnuncios6Scene",user, anuncios);
                }


                Main.trocarTela("meusAnunciosScene",user,anuncios); }




}
