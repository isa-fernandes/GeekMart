package br.ufrpe.geekMart.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class TelaInicialLogadoController {


    Fachada fachada = Fachada.getInstancia();
    Cliente user;

    @FXML
    protected  void  initialize(){
        Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                if(newScreen.equals("telaInicialLogadoScene")) {
                    user = (Cliente)userData;
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
        private ResourceBundle resources;

        @FXML
        private URL location;

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

    @FXML
    protected  void buscaAnuncios(ActionEvent e){
         final int N = 10; //trocar por algo que declare os insteiros positivos
        int X1 = 1 + (N*6);
        int X2 = 2 + (N*6);
        int X3 = 3 + (N*6);
        int X4 = 4 + (N*6);
        int X5 = 5 + (N*6);
        int X6 = 6 + (N*6);

        Anuncio[] anuncios = fachada.listarAnuncios();

        if(anuncios.length == X1){ // anuncios será trocado por dados da busca
            Main.trocarTela("resultadoBuscaLogado1Scene",anuncios);
        } else if(anuncios.length == X2){
            Main.trocarTela("resultadoBuscaLogado2Scene",anuncios);
        } else if(anuncios.length == X3){
            Main.trocarTela("resultadoBuscaLogado3Scene",anuncios);
        } else if(anuncios.length == X4){
            Main.trocarTela("resultadoBuscaLogado4Scene",anuncios);
        } else if(anuncios.length == X5){
            Main.trocarTela("resultadoBuscaLogado5Scene",anuncios);
        } else if(anuncios.length == X6){
            Main.trocarTela("resultadoBuscaLogado6Scene",anuncios);
        }





    }





}