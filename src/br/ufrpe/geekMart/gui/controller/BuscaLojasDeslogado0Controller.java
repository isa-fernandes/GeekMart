package br.ufrpe.geekMart.gui.controller;

import br.ufrpe.geekMart.negocio.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class BuscaLojasDeslogado0Controller {


        Fachada fachada = Fachada.getInstancia();

        @FXML
        protected  void  initialize(){
            Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
                @Override
                public void onScreenChanged(String newScreen, Object userData) {
                    if(newScreen.equals("resultadoBuscaLogadoScene")) {
                        updateComboBoxCategorias();
                        updateComboBoxLojas();

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
        private Label lbPrecoII1;

        @FXML
        private Label lbTituroII1;

        @FXML
        private Label lbPrecoII2;

        @FXML
        private Label lbTituroII2;

        @FXML
        private Label lbPrecoII3;

        @FXML
        private Label lbTituroII3;

        @FXML
        private Label lbPrecoII4;

        @FXML
        private Label lbTituroII4;

        @FXML
        private Label lbPrecoII5;

        @FXML
        private Label lbTituroII5;

        @FXML
        private Label lbPrecoII6;

        @FXML
        private Label lbTituroII6;

    @FXML
    private Button btEntre;

    @FXML
    private Button btCadastrar;

    @FXML
    protected  void btCadastrarAction(ActionEvent e){ Main.trocarTela("cadastrarNovoClienteScene"); }

    @FXML
    protected  void btEntrarAction(ActionEvent e){
        Main.trocarTela("telaLoginScene");
    }
    @FXML
    protected  void btHomeAction(ActionEvent e){
        Main.trocarTela("telaInicialLogadoScene");
    }




    }



