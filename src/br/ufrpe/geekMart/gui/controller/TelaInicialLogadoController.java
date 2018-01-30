package br.ufrpe.geekMart.gui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;
import br.ufrpe.geekMart.negocio.classesBasicas.EnumCategorias;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import br.ufrpe.geekMart.negocio.classesBasicas.Loja;
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
            public void onScreenChanged(String newScreen, Object userData,Object userData2) {
                if(newScreen.equals("telaInicialLogadoScene")) {
                    user = (Cliente)userData;
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
    protected  void buscaAnunciosPorCategoria(ActionEvent e){

        String palavra = cbCategorias.getSelectionModel().toString();
        ArrayList<Loja> anuncios = fachada.buscarLojaPorCategoria(palavra);


        if(anuncios.size()<6 && anuncios.size()>=0) {

            switch (anuncios.size()) {
                case 1:
                    Main.trocarTela("buscasLojasLogado1Scene", anuncios);
                    break;
                case 2:
                    Main.trocarTela("buscasLojasLogado2Scene", anuncios);
                    break;
                case 3:
                    Main.trocarTela("buscasLojasLogado3Scene", anuncios);
                    break;
                case 4:
                    Main.trocarTela("buscasLojasLogado4Scene", anuncios);
                    break;
                case 5:
                    Main.trocarTela("buscasLojasLogado5Scene", anuncios);
                    break;

                case 0:
                    Main.trocarTela("buscasLojasLogado0Scene", anuncios);
                    break;
            }
        } else if(anuncios.size() >= 6) {
            Main.trocarTela("resultadoBuscaLogado6Scene", anuncios);
        }


    }




    @FXML
    protected  void buscaLojasPorCategoria(ActionEvent e){

        String palavra = cbCategorias.getSelectionModel().toString();
        ArrayList<Loja> anuncios = fachada.buscarLojaPorTitulo(palavra);


        if(anuncios.size()<6 && anuncios.size()>=0) {

            switch (anuncios.size()) {
                case 1:
                    Main.trocarTela("buscasLojasLogado1Scene", anuncios);
                    break;
                case 2:
                    Main.trocarTela("buscasLojasLogado2Scene", anuncios);
                    break;
                case 3:
                    Main.trocarTela("buscasLojasLogado3Scene", anuncios);
                    break;
                case 4:
                    Main.trocarTela("buscasLojasLogado4Scene", anuncios);
                    break;
                case 5:
                    Main.trocarTela("buscasLojasLogado5Scene", anuncios);
                    break;

                case 0:
                    Main.trocarTela("buscasLojasLogado0Scene", anuncios);
                    break;
            }
        } else if(anuncios.size() >= 6) {
            Main.trocarTela("resultadoBuscaLogado6Scene", anuncios);
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
    protected  void buscaAnunciosPorTituloOrdenadoPorPreço(ActionEvent e){

        String palavra = tfBuscar.getText();
        ArrayList<Anuncio> resultado = fachada.buscarAnuncioPorTituloOrdenadoPeloPreco(palavra);


        Anuncio[] anuncios = fachada.listarAnuncios();

        if(resultado.size()<6 && resultado.size()>=0) {

            switch (resultado.size()) {
                case 1:
                    Main.trocarTela("resultadoBuscaLogado1Scene", anuncios);
                    break;
                case 2:
                    Main.trocarTela("resultadoBuscaLogado2Scene", anuncios);
                    break;
                case 3:
                    Main.trocarTela("resultadoBuscaLogado3Scene", anuncios);
                    break;
                case 4:
                    Main.trocarTela("resultadoBuscaLogado4Scene", anuncios);
                    break;
                case 5:
                    Main.trocarTela("resultadoBuscaLogado5Scene", anuncios);
                    break;

                    case 0:
                        Main.trocarTela("resultadoBuscaLogado0Scene", anuncios);
                        break;
            }
        } else if(resultado.size() >= 6) {
                    Main.trocarTela("resultadoBuscaLogado6Scene", anuncios);
            }


        }









}
