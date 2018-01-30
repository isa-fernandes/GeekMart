package br.ufrpe.geekMart.gui.controller;

import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.EnumCategorias;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class MeusAnuncios0Controller {

    Cliente user;
    Fachada fachada = Fachada.getInstancia();

    @FXML
    protected  void  initialize(){
        Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
            @Override
            public void onScreenChanged(String newScreen, Object userData, Object userData2, String n) {
                if(newScreen.equals("meusAnuncios0Scene")) {
                    user=(Cliente)userData;
                    updateComboBoxCategorias();
                    updateComboBoxLojas();

                } }
        });


        updateComboBoxCategorias();
        updateComboBoxLojas();

    }

    @FXML
    private Button btVoltar;

    @FXML
    private Button btProxima;

    @FXML
    private Button btVerAnuncio1;

    @FXML
    private Button btVerAnuncio2;

    @FXML
    private Button btVerAnuncio3;

    @FXML
    private Button btVerAnuncio4;

    @FXML
    private Button btVerAnuncio5;

    @FXML
    private Button btVerAnuncio6;

    @FXML
    private ImageView imBusca1;

    @FXML
    private ImageView imBusca2;

    @FXML
    private ImageView imBusca3;

    @FXML
    private ImageView imBusca4;

    @FXML
    private ImageView imBusca5;

    @FXML
    private ImageView imBusca6;

    @FXML
    private  Button Editar1;

    @FXML
    private  Button Editar2;

    @FXML
    private  Button Editar3;

    @FXML
    private  Button Editar4;

    @FXML
    private  Button Editar5;

    @FXML
    private  Button Editar6;




    private  void  updateComboBoxCategorias(){
        this.cbCategorias.getItems().setAll(EnumCategorias.values());
    }

    private void updateComboBoxLojas(){
        this.cbLojas.getItems().setAll(EnumCategorias.values());
    }


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
