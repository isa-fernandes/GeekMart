package br.ufrpe.geekMart.gui.controller;

import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import br.ufrpe.geekMart.negocio.classesBasicas.EnumCategorias;
import br.ufrpe.geekMart.negocio.classesBasicas.Loja;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class AnuncioController {


    Fachada fachada = Fachada.getInstancia();
    Anuncio user;

    @FXML
    protected  void  initialize(){
        Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
            @Override
            public void onScreenChanged(String newScreen, Object userData,Object userData2) {
                if(newScreen.equals("AnuncioScene")) {
                    user = (Anuncio)userData;
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

    private void updateAnuncio(){
        lbPreco.setText(user.getPreco());
        lbTitulo.setText(user.getTitulo());
        lbCategoria.setText(user.getCategoria().toString());
        lbEstado.setText(user.getEstado().toString());
        lbDataInicio.setText(user.getData().toString());
        lbDataExpira.setText(user.getData().toString());
        String ativo;
        if(user.isAtivo()){
            ativo = "Ativo";
        } else {
            ativo = "Falso";
        }
        lbAtivo.setText(ativo);
        if(user.getEstrela() <= 1){
            Image image = new Image("estrela.png");
            estrela1.setImage(image);
        } if(user.getEstrela() <= 2){

        } if(user.getEstrela() <= 3){

        } if(user.getEstrela() <= 4){

        } if(user.getEstrela() <= 5){

        }
        taDescricao.setText(user.getDescricao());

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


    @FXML
    protected  void btHomeAction(ActionEvent e){
        Main.trocarTela("telaInicialLogadoScene");
    }

    @FXML
    protected  void btMeuCadastroAction(ActionEvent e){
        Main.trocarTela("cadastroClienteScene");
    }

    @FXML
    protected  void btMeusAnunciosAction(ActionEvent e){ Main.trocarTela("meusAnunciosScene"); }

    @FXML
    protected  void btMinhasLojasAction(ActionEvent e){
        Main.trocarTela("minhasLojasScene");
    }

    @FXML
    protected  void btNovoAnuncioAction(ActionEvent e){
        Main.trocarTela("cadastrarNovoAnuncioScene");
    }

    @FXML
    protected  void btNovaLojaAction(ActionEvent e){
        Main.trocarTela("cadastrarNovaLojaScene");
    }

    @FXML
    protected  void btChatAction(ActionEvent e){
        Main.trocarTela("chatScene");
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
    private Label lbPreco;

    @FXML
    private Label lbDataInicio;

    @FXML
    private Label lbCategoria;

    @FXML
    private ComboBox cbCategorias;

    @FXML
    private Button btBuscar;

    @FXML
    private Button btMeuCadastro;

    @FXML
    private ImageView im3;

    @FXML
    private ImageView im2;

    @FXML
    private Button btMinhasLojas;

    @FXML
    private TextArea taDescricao;

    @FXML
    private Label lbEstado;

    @FXML
    private Button btCHAT;

    @FXML
    private ComboBox cbEstrelas;

    @FXML
    private Label lbQtdade;

    @FXML
    private Button btNovaLoja;

    @FXML
    private MenuItem menuLoginAdm;

    @FXML
    private Button btNovoAnuncio;

    @FXML
    private MenuItem menuSobreApp;

    @FXML
    private Label lbAtivo;

    @FXML
    private ImageView imCentral;

    @FXML
    private Button btMeusAnuncios;

    @FXML
    private ImageView estrela1;

    @FXML
    private TextField tfBuscar;

    @FXML
    private ImageView estrela5;

    @FXML
    private ImageView estrela4;

    @FXML
    private Button btHome;

    @FXML
    private ImageView estrela3;

    @FXML
    private ImageView estrela2;

    @FXML
    private MenuItem menuSair;

    @FXML
    private MenuItem menuLoginCliente;

    @FXML
    private Label lbTitulo;

    @FXML
    private Label lbDataExpira;

    @FXML
    private ComboBox cbLojas;



}
