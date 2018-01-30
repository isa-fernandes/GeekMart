package br.ufrpe.geekMart.gui.controller;
import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;
import br.ufrpe.geekMart.negocio.classesBasicas.EnumCategorias;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import br.ufrpe.geekMart.negocio.classesBasicas.Loja;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ChatController {

        Cliente user;
        Fachada fachada = Fachada.getInstancia();

        @FXML
        protected  void  initialize(){
                Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
                        @Override
                        public void onScreenChanged(String newScreen, Object userData, ArrayList<Anuncio> userData2,
                                                    ArrayList<Anuncio> userData3, ArrayList<Loja> userData4) {
                                if(newScreen.equals("chatScene")) {
                                        user=(Cliente)userData;
                                        updateComboBoxCategorias();
                                        updateComboBoxLojas();

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


        @FXML
        public void btnEnviar (ActionEvent e) {

        }

        @FXML
        private TextArea txtAreaComentario;

        @FXML
        private Button btnEnviar;

        @FXML
        private VBox vbComentarios;

        @FXML
        private Button btHome;

        @FXML
        private Button btMeusAnuncios;

        @FXML
        private ComboBox cbCategorias;

        @FXML
        private Button btBuscar;

        @FXML
        private Button btMeuCadastro;

        @FXML
        private TextField tfBuscar;

        @FXML
        private Button btMinhasLojas;

        @FXML
        private MenuItem menuSair;

        @FXML
        private MenuItem menuLoginCliente;

        @FXML
        private Button btCHAT;

        @FXML
        private ComboBox cbLojas;

        @FXML
        private Button btNovaLoja;

        @FXML
        private MenuItem menuLoginAdm;

        @FXML
        private Button btNovoAnuncio;

        @FXML
        private MenuItem menuSobreApp;

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
